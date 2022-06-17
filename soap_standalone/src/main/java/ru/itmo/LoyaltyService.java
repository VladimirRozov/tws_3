package ru.itmo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import com.sun.xml.ws.fault.SOAPFaultBuilder;
import java.util.ArrayList;
import javax.jws.WebParam;
import ru.itmo.error.*;

@WebService(serviceName = "LoyaltyService")
public class LoyaltyService {
    SOAPFaultBuilder soapFaultBuilder;

        public LoyaltyService(){
            soapFaultBuilder.captureStackTrace = false;
        }

    @WebMethod(operationName = "getAll")
    public List<Loyalty> getAll() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.getAll();
    }
    
    @WebMethod(operationName = "createLoyalty")
    public String createLoyalty(@WebParam(name = "spbsoID") String spbsoID,
                                       @WebParam(name = "fullName") String name,
                                       @WebParam(name = "event") String event,
                                       @WebParam(name = "cash") String cash,
                                       @WebParam(name = "brigade") String brigade)  throws EmptyFieldException, CastToIntException {
        
        String status;

        if (name != null && !name.trim().isEmpty() &&
                event != null && !event.trim().isEmpty() &&
                cash != null && !cash.trim().isEmpty() &&
                spbsoID != null && !spbsoID.trim().isEmpty() &&
                brigade != null && !brigade.trim().isEmpty()) {

                try {
                    int cashInt = Integer.parseInt(cash.trim());
                    int spbsoIdInt = Integer.parseInt(spbsoID.trim());


                        PostgreSQLDAO dao = new PostgreSQLDAO();
                        status = dao.createLoyalty(spbsoIdInt, name, brigade, event, cashInt);

                } catch (NumberFormatException ex) {
                    CastToIntFault fault = CastToIntFault.defaultInstance();
                    throw new CastToIntException("Error was occurred in class: " + LoyaltyService.class.getName() +
                            ", method - createLoyalty(). \n We get 'NumberFormatException': " + ex +
                            ", when trying convert cash and spbsoID to integers.", fault);
                }


        } else {
            EmptyFieldFault fault = EmptyFieldFault.defaultInstance();
            throw new EmptyFieldException("Error was occurred in class " + LoyaltyService.class.getName() +
                    ", method createLoyalty().", fault);
        }

        return status;
    }

    @WebMethod(operationName = "deleteLoyalty")
    public String deleteLoyalty(@WebParam(name = "rowId") String rowId) throws CastToIntException, RowIsNotExistsException {
         String status;
        try {
            int rowIdInt = Integer.parseInt(rowId.trim());
            PostgreSQLDAO dao = new PostgreSQLDAO();
            status = dao.deleteLoyalty(rowIdInt);
            System.out.println(status);
            if (status.equals("0")) {
                RowIsNotExistsFault fault = RowIsNotExistsFault.defaultInstance();
                throw new RowIsNotExistsException("Error was occurred in class: " + LoyaltyService.class.getName() +
                        ", method - deleteLoyalty(). \n We get 'status = 0' after deletion row in table in DB with rowId " + rowId, fault);
            }

        } catch (NumberFormatException ex) {
            CastToIntFault fault = CastToIntFault.defaultInstance();
            throw new CastToIntException("Error was occurred in class: " + LoyaltyService.class.getName() +
                    ", method - deleteLoyalty(). \n We get 'NumberFormatException': " + ex +
                    ", when trying convert rowId to int.", fault);
        }

        return status;
    }
    
    @WebMethod(operationName = "updateLoyalty")
    public String updateLoyalty(@WebParam(name = "rowId") String  rowId,
                                @WebParam(name = "spbsoID") String  spbsoID,
                                       @WebParam(name = "fullName") String name,
                                       @WebParam(name = "event") String event,
                                       @WebParam(name = "cash") String  cash,
                                       @WebParam(name = "brigade") String brigade) throws EmptyFieldException,
            RowIsNotExistsException,CastToIntException {

        String status;

        try {
            int rowIdInt = Integer.parseInt(rowId.trim());

            Integer.parseInt(spbsoID.trim());
            Integer.parseInt(cash.trim());

            List<String> updateArgs = new ArrayList<>();

            if (name != null && !name.trim().isEmpty()) updateArgs.add("name = '" + name + "'");
            if (event != null && !event.trim().isEmpty()) updateArgs.add("event = '" + event + "'");

            if (!cash.trim().isEmpty()) {
                try {
                    Integer.parseInt(cash.trim());
                    updateArgs.add("cash = '" + cash + "'");
                } catch (NumberFormatException ex) {
                    CastToIntFault fault = CastToIntFault.defaultInstance();
                    throw new CastToIntException("Error was occurred in class: " + LoyaltyService.class.getName() +
                            ", method - updateLoyalty(). \n We get 'NumberFormatException': " + ex +
                            ", when trying convert 'cash' to int.", fault);
                }
            }

            if (!spbsoID.trim().isEmpty()) {
                try {
                    Integer.parseInt(spbsoID.trim());
                    updateArgs.add("spbso = '" + spbsoID + "'");
                } catch (NumberFormatException ex) {
                    CastToIntFault fault = CastToIntFault.defaultInstance();
                    throw new CastToIntException("Error was occurred in class: " + LoyaltyService.class.getName() +
                            ", method - updateLoyalty(). \n We get 'NumberFormatException': " + ex +
                            ", when trying convert 'studentId' to int.", fault);
                }
            }
            

            int i = 0;
            for (String param : updateArgs) {
                if (param != null && !param.trim().isEmpty()) {
                    i++;
                }
            }
            if (i > 0) {

                PostgreSQLDAO dao = new PostgreSQLDAO();
                status = dao.updateLoyalty(rowIdInt, updateArgs);

            } else {
                EmptyFieldFault fault = EmptyFieldFault.defaultInstance();
                fault.setMessage("All required parameters are empty. Please, input at least one of them.");
                throw new EmptyFieldException("Error was occurred in class " + LoyaltyService.class.getName() +
                        ", method updateLoyalty().", fault);
            }

            if (status.equals("0")) {
                RowIsNotExistsFault fault = RowIsNotExistsFault.defaultInstance();
                throw new RowIsNotExistsException("Error was occurred in class: " + LoyaltyService.class.getName() +
                        ", method - updateLoyalty(). \n We get 'status = 0' after deletion row in table in DB with rowId " + rowId, fault);
            }

        } catch (NumberFormatException ex) {
            CastToIntFault fault = CastToIntFault.defaultInstance();
            throw new CastToIntException("Error was occurred in class: " + LoyaltyService.class.getName() +
                    ", method - updateLoyalty(). \n We get 'NumberFormatException': " + ex +
                    ", when trying convert rowId to int.", fault);
        }

        return status;
    }

}
