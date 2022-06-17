
package ru.itmo.generate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.itmo.generate package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteLoyaltyResponse_QNAME = new QName("http://itmo.ru/", "deleteLoyaltyResponse");
    private final static QName _UpdateLoyalty_QNAME = new QName("http://itmo.ru/", "updateLoyalty");
    private final static QName _CreateLoyaltyResponse_QNAME = new QName("http://itmo.ru/", "createLoyaltyResponse");
    private final static QName _EmptyFieldException_QNAME = new QName("http://itmo.ru/", "EmptyFieldException");
    private final static QName _CreateLoyalty_QNAME = new QName("http://itmo.ru/", "createLoyalty");
    private final static QName _GetAll_QNAME = new QName("http://itmo.ru/", "getAll");
    private final static QName _CastToIntException_QNAME = new QName("http://itmo.ru/", "CastToIntException");
    private final static QName _DeleteLoyalty_QNAME = new QName("http://itmo.ru/", "deleteLoyalty");
    private final static QName _GetAllResponse_QNAME = new QName("http://itmo.ru/", "getAllResponse");
    private final static QName _UpdateLoyaltyResponse_QNAME = new QName("http://itmo.ru/", "updateLoyaltyResponse");
    private final static QName _RowIsNotExistsException_QNAME = new QName("http://itmo.ru/", "RowIsNotExistsException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.itmo.generate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CastToIntFault }
     * 
     */
    public CastToIntFault createCastToIntFault() {
        return new CastToIntFault();
    }

    /**
     * Create an instance of {@link CreateLoyalty }
     * 
     */
    public CreateLoyalty createCreateLoyalty() {
        return new CreateLoyalty();
    }

    /**
     * Create an instance of {@link GetAll }
     * 
     */
    public GetAll createGetAll() {
        return new GetAll();
    }

    /**
     * Create an instance of {@link RowIsNotExistsFault }
     * 
     */
    public RowIsNotExistsFault createRowIsNotExistsFault() {
        return new RowIsNotExistsFault();
    }

    /**
     * Create an instance of {@link DeleteLoyalty }
     * 
     */
    public DeleteLoyalty createDeleteLoyalty() {
        return new DeleteLoyalty();
    }

    /**
     * Create an instance of {@link GetAllResponse }
     * 
     */
    public GetAllResponse createGetAllResponse() {
        return new GetAllResponse();
    }

    /**
     * Create an instance of {@link UpdateLoyaltyResponse }
     * 
     */
    public UpdateLoyaltyResponse createUpdateLoyaltyResponse() {
        return new UpdateLoyaltyResponse();
    }

    /**
     * Create an instance of {@link DeleteLoyaltyResponse }
     * 
     */
    public DeleteLoyaltyResponse createDeleteLoyaltyResponse() {
        return new DeleteLoyaltyResponse();
    }

    /**
     * Create an instance of {@link UpdateLoyalty }
     * 
     */
    public UpdateLoyalty createUpdateLoyalty() {
        return new UpdateLoyalty();
    }

    /**
     * Create an instance of {@link EmptyFieldFault }
     * 
     */
    public EmptyFieldFault createEmptyFieldFault() {
        return new EmptyFieldFault();
    }

    /**
     * Create an instance of {@link CreateLoyaltyResponse }
     * 
     */
    public CreateLoyaltyResponse createCreateLoyaltyResponse() {
        return new CreateLoyaltyResponse();
    }

    /**
     * Create an instance of {@link Loyalty }
     * 
     */
    public Loyalty createLoyalty() {
        return new Loyalty();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLoyaltyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "deleteLoyaltyResponse")
    public JAXBElement<DeleteLoyaltyResponse> createDeleteLoyaltyResponse(DeleteLoyaltyResponse value) {
        return new JAXBElement<DeleteLoyaltyResponse>(_DeleteLoyaltyResponse_QNAME, DeleteLoyaltyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLoyalty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "updateLoyalty")
    public JAXBElement<UpdateLoyalty> createUpdateLoyalty(UpdateLoyalty value) {
        return new JAXBElement<UpdateLoyalty>(_UpdateLoyalty_QNAME, UpdateLoyalty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateLoyaltyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "createLoyaltyResponse")
    public JAXBElement<CreateLoyaltyResponse> createCreateLoyaltyResponse(CreateLoyaltyResponse value) {
        return new JAXBElement<CreateLoyaltyResponse>(_CreateLoyaltyResponse_QNAME, CreateLoyaltyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyFieldFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "EmptyFieldException")
    public JAXBElement<EmptyFieldFault> createEmptyFieldException(EmptyFieldFault value) {
        return new JAXBElement<EmptyFieldFault>(_EmptyFieldException_QNAME, EmptyFieldFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateLoyalty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "createLoyalty")
    public JAXBElement<CreateLoyalty> createCreateLoyalty(CreateLoyalty value) {
        return new JAXBElement<CreateLoyalty>(_CreateLoyalty_QNAME, CreateLoyalty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "getAll")
    public JAXBElement<GetAll> createGetAll(GetAll value) {
        return new JAXBElement<GetAll>(_GetAll_QNAME, GetAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CastToIntFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "CastToIntException")
    public JAXBElement<CastToIntFault> createCastToIntException(CastToIntFault value) {
        return new JAXBElement<CastToIntFault>(_CastToIntException_QNAME, CastToIntFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLoyalty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "deleteLoyalty")
    public JAXBElement<DeleteLoyalty> createDeleteLoyalty(DeleteLoyalty value) {
        return new JAXBElement<DeleteLoyalty>(_DeleteLoyalty_QNAME, DeleteLoyalty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "getAllResponse")
    public JAXBElement<GetAllResponse> createGetAllResponse(GetAllResponse value) {
        return new JAXBElement<GetAllResponse>(_GetAllResponse_QNAME, GetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLoyaltyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "updateLoyaltyResponse")
    public JAXBElement<UpdateLoyaltyResponse> createUpdateLoyaltyResponse(UpdateLoyaltyResponse value) {
        return new JAXBElement<UpdateLoyaltyResponse>(_UpdateLoyaltyResponse_QNAME, UpdateLoyaltyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RowIsNotExistsFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itmo.ru/", name = "RowIsNotExistsException")
    public JAXBElement<RowIsNotExistsFault> createRowIsNotExistsException(RowIsNotExistsFault value) {
        return new JAXBElement<RowIsNotExistsFault>(_RowIsNotExistsException_QNAME, RowIsNotExistsFault.class, null, value);
    }

}
