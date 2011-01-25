//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.31 at 02:27:35 PM EEST 
//


package generated;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jvnet.hyperjaxb3.xml.bind.annotation.adapters.XMLGregorianCalendarAsDate;
import org.jvnet.hyperjaxb3.xml.bind.annotation.adapters.XmlAdapterUtils;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.builder.JAXBEqualsBuilder;
import org.jvnet.jaxb2_commons.lang.builder.JAXBHashCodeBuilder;


/**
 * <p>Java class for PurchaseOrderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PurchaseOrderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shipTo" type="{}USAddress"/>
 *         &lt;element name="billTo" type="{}USAddress"/>
 *         &lt;element ref="{}comment" minOccurs="0"/>
 *         &lt;element name="items" type="{}Items"/>
 *       &lt;/sequence>
 *       &lt;attribute name="orderDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseOrderType", propOrder = {
    "shipTo",
    "billTo",
    "comment",
    "items"
})
@Entity(name = "generated.PurchaseOrderType")
@Table(name = "PURCHASEORDERTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class PurchaseOrderType
    implements Equals, HashCode
{

    @XmlElement(required = true)
    protected generated.USAddress shipTo;
    @XmlElement(required = true)
    protected generated.USAddress billTo;
    protected String comment;
    @XmlElement(required = true)
    protected generated.Items items;
    @XmlAttribute
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orderDate;
    @XmlAttribute(name = "Hjid")
    protected Long hjid;

    /**
     * Gets the value of the shipTo property.
     * 
     * @return
     *     possible object is
     *     {@link generated.USAddress }
     *     
     */
    @ManyToOne(targetEntity = generated.USAddress.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "SHIPTO_PURCHASEORDERTYPE_ID")
    public generated.USAddress getShipTo() {
        return shipTo;
    }

    /**
     * Sets the value of the shipTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link generated.USAddress }
     *     
     */
    public void setShipTo(generated.USAddress value) {
        this.shipTo = value;
    }

    /**
     * Gets the value of the billTo property.
     * 
     * @return
     *     possible object is
     *     {@link generated.USAddress }
     *     
     */
    @ManyToOne(targetEntity = generated.USAddress.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "BILLTO_PURCHASEORDERTYPE_ID")
    public generated.USAddress getBillTo() {
        return billTo;
    }

    /**
     * Sets the value of the billTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link generated.USAddress }
     *     
     */
    public void setBillTo(generated.USAddress value) {
        this.billTo = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "COMMENT_")
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link generated.Items }
     *     
     */
    @ManyToOne(targetEntity = generated.Items.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "ITEMS_PURCHASEORDERTYPE_ID")
    public generated.Items getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link generated.Items }
     *     
     */
    public void setItems(generated.Items value) {
        this.items = value;
    }

    /**
     * Gets the value of the orderDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    @Transient
    public XMLGregorianCalendar getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the value of the orderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDate(XMLGregorianCalendar value) {
        this.orderDate = value;
    }

    public void equals(Object object, EqualsBuilder equalsBuilder) {
        if (!(object instanceof PurchaseOrderType)) {
            equalsBuilder.appendSuper(false);
            return ;
        }
        if (this == object) {
            return ;
        }
        final PurchaseOrderType that = ((PurchaseOrderType) object);
        equalsBuilder.append(this.getShipTo(), that.getShipTo());
        equalsBuilder.append(this.getBillTo(), that.getBillTo());
        equalsBuilder.append(this.getComment(), that.getComment());
        equalsBuilder.append(this.getItems(), that.getItems());
        equalsBuilder.append(this.getOrderDate(), that.getOrderDate());
    }

    public boolean equals(Object object) {
        if (!(object instanceof PurchaseOrderType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EqualsBuilder equalsBuilder = new JAXBEqualsBuilder();
        equals(object, equalsBuilder);
        return equalsBuilder.isEquals();
    }

    public void hashCode(HashCodeBuilder hashCodeBuilder) {
        hashCodeBuilder.append(this.getShipTo());
        hashCodeBuilder.append(this.getBillTo());
        hashCodeBuilder.append(this.getComment());
        hashCodeBuilder.append(this.getItems());
        hashCodeBuilder.append(this.getOrderDate());
    }

    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new JAXBHashCodeBuilder();
        hashCode(hashCodeBuilder);
        return hashCodeBuilder.toHashCode();
    }

    /**
     * Gets the value of the hjid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getHjid() {
        return hjid;
    }

    /**
     * Sets the value of the hjid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHjid(Long value) {
        this.hjid = value;
    }

    @Basic
    @Column(name = "ORDERDATEITEM")
    @Temporal(TemporalType.DATE)
    public Date getOrderDateItem() {
        return XmlAdapterUtils.unmarshall(XMLGregorianCalendarAsDate.class, this.getOrderDate());
    }

    public void setOrderDateItem(Date target) {
        setOrderDate(XmlAdapterUtils.marshall(XMLGregorianCalendarAsDate.class, target));
    }
    
    public java.math.BigDecimal getTotalPrice() {
        return  (java.math.BigDecimal) jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, "getTotalPrice"); 
    }

    public int getTotalNumberOfItems() {
        return ((Integer)jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, "getTotalNumberOfItems")); 
    }

}
