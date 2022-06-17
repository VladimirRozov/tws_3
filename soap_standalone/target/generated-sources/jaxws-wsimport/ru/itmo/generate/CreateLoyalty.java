
package ru.itmo.generate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createLoyalty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createLoyalty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="spbsoID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="event" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="brigade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createLoyalty", propOrder = {
    "spbsoID",
    "fullName",
    "event",
    "cash",
    "brigade"
})
public class CreateLoyalty {

    protected String spbsoID;
    protected String fullName;
    protected String event;
    protected String cash;
    protected String brigade;

    /**
     * Gets the value of the spbsoID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpbsoID() {
        return spbsoID;
    }

    /**
     * Sets the value of the spbsoID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpbsoID(String value) {
        this.spbsoID = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvent(String value) {
        this.event = value;
    }

    /**
     * Gets the value of the cash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCash() {
        return cash;
    }

    /**
     * Sets the value of the cash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCash(String value) {
        this.cash = value;
    }

    /**
     * Gets the value of the brigade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrigade() {
        return brigade;
    }

    /**
     * Sets the value of the brigade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrigade(String value) {
        this.brigade = value;
    }

}
