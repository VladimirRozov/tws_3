/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru;

import static java.lang.Integer.parseInt;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.itmo.generate.CastToIntException;
import ru.itmo.generate.EmptyFieldException;
import ru.itmo.generate.Loyalty;
import ru.itmo.generate.LoyaltyService_Service;
import ru.itmo.generate.RowIsNotExistsException;

/**
 *
 * @author rozov
 */
public class Client {
     public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/LoyaltyService?wsdl"); //standalone
        LoyaltyService_Service loyaltyService = new LoyaltyService_Service(url);        

         try (//  онсольный выбор CRUD метода
                 Scanner scanner = new Scanner(System.in)) {
             System.out.println("Choose CRUD method (input CREATE, READ, UPDATE or DELETE), or input 'exit' for exit:");
             String choosenMethod;
             do {
                 choosenMethod = scanner.nextLine();
                 // проверим строку на наличие аргумента: если строка не €вл€етс€ пустой и не состоит из пробелов, то
                 // провер€ем на наличие одной из возможных операций
                 if (choosenMethod != null && !choosenMethod.trim().isEmpty()) {
                     
                     switch (choosenMethod) {
                         case ("CREATE"):
                             createLoyaltyRow(loyaltyService);
                             System.out.println("That's it! You can choose another CRUD method or input 'exit' for exit");
                             break;
                         case ("READ"):
                             readLoyaltyRowsByFields(loyaltyService);
                             System.out.println("That's it! You can choose another CRUD method or input 'exit' for exit");
                             break;
                         case ("UPDATE"):
                             updateLoyaltyRowById(loyaltyService);
                             System.out.println("That's it! You can choose another CRUD method or input 'exit' for exit");
                             break;
                         case ("DELETE"):
                             deleteLoyaltyRowById(loyaltyService);
                             System.out.println("That's it! You can choose another CRUD method or input 'exit' for exit");
                             break;
                         case ("exit"):
                             System.out.println("Bye-Bye!");
                             break;
                         default:
                             System.out.println("You can input just CREATE, READ, UPDATE or DELETE!");
                             System.out.println("Try again or use 'exit' for exit.");
                             break;
                     }
                 }
             } while (!Objects.equals(choosenMethod, "exit"));
         }
    }
     private static void updateLoyaltyRowById(LoyaltyService_Service loyaltyService) {

        String status = "Bad";

        //  онсольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input rowID (integer): ");
        String rowIDString = scanner.nextLine();
        // ѕровер€ем rowId на число
        int rowId = -1;
        if (rowIDString != null && !rowIDString.trim().isEmpty()) {
            try {
                rowId = parseInt(rowIDString.trim());
            } catch (NumberFormatException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Your request is incorrect! RowId is not an integer.");
            }
        }

        if (rowId != -1) {

            System.out.println("What fields you want update for this row? \n" +
                    "Choose fields from 'spbso', 'name', 'brigade', 'event', 'cash' and input it's below \n" +
                    " separated by comma without spaces");
            String updateRows = scanner.nextLine();

            // ѕреобразуем полученную строку в список аргументов
            String[] updateRowsList = updateRows.split(",", -1);

            Map<String, String> updateRowsMap = new HashMap<>();
            updateRowsMap.put("spbso", "");
            updateRowsMap.put("name", "");
            updateRowsMap.put("brigade", "");
            updateRowsMap.put("event", "");
            updateRowsMap.put("cash", "");

            /*
            ѕроходим по списку аргументов и определ€ем совпадение с названи€ми полей таблицы Ѕƒ.
            ѕроверка на пустую строку или строку из пробелов не нужна, т.к. в подобных случа€х
            мы сразу перейдем к операции по умолчанию (default) в switch-case. “о же самое мы получим,
            если не было совпадений по шаблону.
            ≈сли совпадение найдено, то мы сразу запрашиваем ввести соответствующее значение, провер€ем его на пустую
            строку и добавл€ем в массив, который будет формировать значени€ в запросе.
            ≈сли в итоге сформирован пустой массив (ни одно из значений не подошло), то мы выводим сообщение,
            что введен некорректный запрос. ÷елочисленные значени€ age и student_id дополнительно провер€ем на число (int).
            */
            for (String row : updateRowsList) {
                switch (row) {
                    case "name":
                        System.out.println("Input new value for 'name' field:");
                        String name = scanner.nextLine();
                        if (name != null && !name.trim().isEmpty()) {
                            updateRowsMap.put("name", name);
                        } else {
                            System.out.println("Field 'name' is incorrect and will not be updated!");
                        }
                        break;
                    case "brigade":
                        System.out.println("Input new value for 'name' field:");
                        String brigade = scanner.nextLine();
                        if (brigade != null && !brigade.trim().isEmpty()) {
                            updateRowsMap.put("brigade", brigade);
                        } else {
                            System.out.println("Field 'name' is incorrect and will not be updated!");
                        }
                        break;

                    case "spbso":
                        System.out.println("Input new value for 'spbso' field (integer):");
                        String spbso = scanner.nextLine();
                        try {
                            Integer.parseInt(spbso.trim());
                        } catch (NumberFormatException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            spbso = "";
                        }
                        if (!spbso.trim().isEmpty()) {
                            updateRowsMap.put("spbso", spbso);
                        } else {
                            System.out.println("Field 'spbso' is not an integer and will not be updated!");
                        }
                        break;

                    case "cash":
                        System.out.println("Input new value for 'cash' field (integer):");
                        String cash = scanner.nextLine();
                        try {
                            Integer.parseInt(cash.trim());
                        } catch (NumberFormatException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Field 'cash' is not an integer and will not be updated!");
                            cash = "";
                        }
                        if (!cash.trim().isEmpty()) {
                            updateRowsMap.put("cash", cash);
                        } else {
                            System.out.println("Field 'cash' is not an integer and will not be updated!");
                        }
                        break;

                    case "event":
                        System.out.println("Input new value for 'event' field:");
                        String event = scanner.nextLine();
                        if (event != null && !event.trim().isEmpty()) {
                            updateRowsMap.put("event", event);
                        } else {
                            System.out.println("Field 'event' is incorrect and will not be updated!");
                        }
                        break;

                    default:
                        System.out.println("Incorrect request. Try again!");
                        break;
                }
            }

            int i = 0;
            for(String val : updateRowsMap.values()){
                if (val != null && !val.trim().isEmpty()) {
                    i++;
                }
            }

            if (i != 0) {

                System.out.println("You input new values for row " + rowId + ":\n" + updateRowsMap);
                System.out.println("Do you really want to change this fields for row " + rowId + "? (y -> yes, other -> no)");
                String agree = scanner.nextLine();
                if (agree.equals("y")) {
                    String name = updateRowsMap.get("name");
                    String brigade = updateRowsMap.get("brigade");
                    String cash = updateRowsMap.get("cash").trim();
                    String spbsoId = updateRowsMap.get("spbso").trim();
                    String event = updateRowsMap.get("event");

                    String param = ""+rowId;
                    try {
                        status = loyaltyService.getLoyaltyServicePort().updateLoyalty(param, spbsoId, name, event, cash, brigade);
                    } catch (CastToIntException | EmptyFieldException | RowIsNotExistsException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    System.out.println("You just cancel your request. Try another request or exit.");
                }



            } else {
                System.out.println("All arguments is empty. Row update can not be completed.");
            }
        }
        System.out.println("Status: " + status);
    }

     private static void deleteLoyaltyRowById(LoyaltyService_Service loyaltyService) {
        String status = "0";

        //  онсольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input rowID (integer): ");
        
        String rowId = scanner.nextLine();
         try {
             status = loyaltyService.getLoyaltyServicePort().deleteLoyalty(rowId);
         } catch (CastToIntException | RowIsNotExistsException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        System.out.println("Status: " + status);
    }
     
      private static void createLoyaltyRow(LoyaltyService_Service loyaltyService) {

        String status = "0";

        //  онсольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input spbsoId (integer): ");
        String spbsoIdStr = scanner.nextLine();
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input brigade: ");
        String brigade = scanner.nextLine();
        System.out.print("Input event: ");
        String event = scanner.nextLine();
        System.out.print("Input cash (integer): ");
        String cashStr = scanner.nextLine();

        String cash;
        String spbsoId;

        // проверим ввод на наличие значений: строка не €вл€етс€ пустой и не состоит из пробелов
        if ((name != null && !name.trim().isEmpty())  &&
                (event != null && !event.trim().isEmpty()) &&
                (cashStr != null && !cashStr.trim().isEmpty()) &&
                (spbsoIdStr != null && !spbsoIdStr.trim().isEmpty()) &&
                (brigade != null && !brigade.trim().isEmpty())) {
            try {
                cash = cashStr.trim();
                spbsoId = spbsoIdStr.trim();
                try {
                    status = loyaltyService.getLoyaltyServicePort().createLoyalty(spbsoId, name, event, cash, brigade);
                } catch (CastToIntException | EmptyFieldException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (status.equals("1")) status = "Good";
                System.out.println("Status: " + status);
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect age or studentId value!");
            }
        }
        else {
            System.out.println("Your request is incorrect!");
        }
    }

      private static void readLoyaltyRowsByFields(LoyaltyService_Service loyaltyService) {
        List<Loyalty> loyalties =
                loyaltyService.getLoyaltyServicePort().getAll();
        for (Loyalty loyalty : loyalties) {
            System.out.println("Loyalty {"  + "id=" + loyalty.getId()
                    + ", spbsoId=" + loyalty.getSpbso() +
                ", fullName=" + loyalty.getName() +
                ", brigade=" + loyalty.getBrigade() +
                ", event=" + loyalty.getEvent() +
                ", cash=" + loyalty.getCash() + '}');
        }
        System.out.println("Total persons: " + loyalties.size());
    }
}
