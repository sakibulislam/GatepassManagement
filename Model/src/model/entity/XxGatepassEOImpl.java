package model.entity;

import java.sql.SQLException;

import java.util.Map;

import oracle.adf.share.ADFContext;

import oracle.jbo.AttributeList;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Apr 02 14:50:24 BDT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XxGatepassEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        HeaderId {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getHeaderId();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setHeaderId((Number)value);
            }
        }
        ,
        OrderNumber {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getOrderNumber();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setOrderNumber((Number)value);
            }
        }
        ,
        OrderedDate {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getOrderedDate();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setOrderedDate((Date)value);
            }
        }
        ,
        DeliveryId {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getDeliveryId();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setDeliveryId((Number)value);
            }
        }
        ,
        OrganizationId {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getOrganizationId();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setOrganizationId((Number)value);
            }
        }
        ,
        OrganizationCode {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getOrganizationCode();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setOrganizationCode((String)value);
            }
        }
        ,
        OperatingUnit {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getOperatingUnit();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setOperatingUnit((Number)value);
            }
        }
        ,
        CustomerId {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getCustomerId();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setCustomerId((Number)value);
            }
        }
        ,
        CustomerNumber {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getCustomerNumber();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setCustomerNumber((String)value);
            }
        }
        ,
        CustomerName {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getCustomerName();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setCustomerName((String)value);
            }
        }
        ,
        SystemDeliveryDate {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getSystemDeliveryDate();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setSystemDeliveryDate((Date)value);
            }
        }
        ,
        Subinventory {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getSubinventory();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setSubinventory((String)value);
            }
        }
        ,
        GatepassNo {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getGatepassNo();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setGatepassNo((String)value);
            }
        }
        ,
        GatepassDate {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getGatepassDate();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setGatepassDate((Date)value);
            }
        }
        ,
        TransportNo {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getTransportNo();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setTransportNo((String)value);
            }
        }
        ,
        DriverName {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getDriverName();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setDriverName((String)value);
            }
        }
        ,
        DriverContactNo {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getDriverContactNo();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setDriverContactNo((String)value);
            }
        }
        ,
        FinalDestination {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getFinalDestination();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setFinalDestination((String)value);
            }
        }
        ,
        VatChallanNo {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getVatChallanNo();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setVatChallanNo((String)value);
            }
        }
        ,
        TotalWeight {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getTotalWeight();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setTotalWeight((Number)value);
            }
        }
        ,
        Status {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getStatus();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setStatus((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setCreatedBy((Number)value);
            }
        }
        ,
        CreationDate {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getCreationDate();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setCreationDate((Date)value);
            }
        }
        ,
        LastUpdatedBy {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setLastUpdatedBy((Number)value);
            }
        }
        ,
        LastUpdateDate {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getLastUpdateDate();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setLastUpdateDate((Date)value);
            }
        }
        ,
        OuName {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getOuName();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setOuName((String)value);
            }
        }
        ,
        RowID {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getRowID();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ItemCode {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getItemCode();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setItemCode((String)value);
            }
        }
        ,
        ItemDescription {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getItemDescription();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setItemDescription((String)value);
            }
        }
        ,
        ItemId {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getItemId();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setItemId((Number)value);
            }
        }
        ,
        LineNumber {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getLineNumber();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setLineNumber((Number)value);
            }
        }
        ,
        RespId {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getRespId();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setRespId((Number)value);
            }
        }
        ,
        PropietorContactNo {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getPropietorContactNo();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setPropietorContactNo((String)value);
            }
        }
        ,
        ProprietorName {
            public Object get(XxGatepassEOImpl obj) {
                return obj.getProprietorName();
            }

            public void put(XxGatepassEOImpl obj, Object value) {
                obj.setProprietorName((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(XxGatepassEOImpl object);

        public abstract void put(XxGatepassEOImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int HEADERID = AttributesEnum.HeaderId.index();
    public static final int ORDERNUMBER = AttributesEnum.OrderNumber.index();
    public static final int ORDEREDDATE = AttributesEnum.OrderedDate.index();
    public static final int DELIVERYID = AttributesEnum.DeliveryId.index();
    public static final int ORGANIZATIONID = AttributesEnum.OrganizationId.index();
    public static final int ORGANIZATIONCODE = AttributesEnum.OrganizationCode.index();
    public static final int OPERATINGUNIT = AttributesEnum.OperatingUnit.index();
    public static final int CUSTOMERID = AttributesEnum.CustomerId.index();
    public static final int CUSTOMERNUMBER = AttributesEnum.CustomerNumber.index();
    public static final int CUSTOMERNAME = AttributesEnum.CustomerName.index();
    public static final int SYSTEMDELIVERYDATE = AttributesEnum.SystemDeliveryDate.index();
    public static final int SUBINVENTORY = AttributesEnum.Subinventory.index();
    public static final int GATEPASSNO = AttributesEnum.GatepassNo.index();
    public static final int GATEPASSDATE = AttributesEnum.GatepassDate.index();
    public static final int TRANSPORTNO = AttributesEnum.TransportNo.index();
    public static final int DRIVERNAME = AttributesEnum.DriverName.index();
    public static final int DRIVERCONTACTNO = AttributesEnum.DriverContactNo.index();
    public static final int FINALDESTINATION = AttributesEnum.FinalDestination.index();
    public static final int VATCHALLANNO = AttributesEnum.VatChallanNo.index();
    public static final int TOTALWEIGHT = AttributesEnum.TotalWeight.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int OUNAME = AttributesEnum.OuName.index();
    public static final int ROWID = AttributesEnum.RowID.index();
    public static final int ITEMCODE = AttributesEnum.ItemCode.index();
    public static final int ITEMDESCRIPTION = AttributesEnum.ItemDescription.index();
    public static final int ITEMID = AttributesEnum.ItemId.index();
    public static final int LINENUMBER = AttributesEnum.LineNumber.index();
    public static final int RESPID = AttributesEnum.RespId.index();
    public static final int PROPIETORCONTACTNO = AttributesEnum.PropietorContactNo.index();
    public static final int PROPRIETORNAME = AttributesEnum.ProprietorName.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XxGatepassEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("model.entity.XxGatepassEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for HeaderId, using the alias name HeaderId.
     * @return the HeaderId
     */
    public Number getHeaderId() {
        return (Number)getAttributeInternal(HEADERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for HeaderId.
     * @param value value to set the HeaderId
     */
    public void setHeaderId(Number value) {
        setAttributeInternal(HEADERID, value);
    }

    /**
     * Gets the attribute value for OrderNumber, using the alias name OrderNumber.
     * @return the OrderNumber
     */
    public Number getOrderNumber() {
        return (Number)getAttributeInternal(ORDERNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrderNumber.
     * @param value value to set the OrderNumber
     */
    public void setOrderNumber(Number value) {
        setAttributeInternal(ORDERNUMBER, value);
    }

    /**
     * Gets the attribute value for OrderedDate, using the alias name OrderedDate.
     * @return the OrderedDate
     */
    public Date getOrderedDate() {
        return (Date)getAttributeInternal(ORDEREDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrderedDate.
     * @param value value to set the OrderedDate
     */
    public void setOrderedDate(Date value) {
        setAttributeInternal(ORDEREDDATE, value);
    }

    /**
     * Gets the attribute value for DeliveryId, using the alias name DeliveryId.
     * @return the DeliveryId
     */
    public Number getDeliveryId() {
        return (Number)getAttributeInternal(DELIVERYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DeliveryId.
     * @param value value to set the DeliveryId
     */
    public void setDeliveryId(Number value) {
        setAttributeInternal(DELIVERYID, value);
    }

    /**
     * Gets the attribute value for OrganizationId, using the alias name OrganizationId.
     * @return the OrganizationId
     */
    public Number getOrganizationId() {
        return (Number)getAttributeInternal(ORGANIZATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrganizationId.
     * @param value value to set the OrganizationId
     */
    public void setOrganizationId(Number value) {
        setAttributeInternal(ORGANIZATIONID, value);
    }

    /**
     * Gets the attribute value for OrganizationCode, using the alias name OrganizationCode.
     * @return the OrganizationCode
     */
    public String getOrganizationCode() {
        return (String)getAttributeInternal(ORGANIZATIONCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrganizationCode.
     * @param value value to set the OrganizationCode
     */
    public void setOrganizationCode(String value) {
        setAttributeInternal(ORGANIZATIONCODE, value);
    }

    /**
     * Gets the attribute value for OperatingUnit, using the alias name OperatingUnit.
     * @return the OperatingUnit
     */
    public Number getOperatingUnit() {
        return (Number)getAttributeInternal(OPERATINGUNIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for OperatingUnit.
     * @param value value to set the OperatingUnit
     */
    public void setOperatingUnit(Number value) {
        setAttributeInternal(OPERATINGUNIT, value);
    }

    /**
     * Gets the attribute value for CustomerId, using the alias name CustomerId.
     * @return the CustomerId
     */
    public Number getCustomerId() {
        return (Number)getAttributeInternal(CUSTOMERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CustomerId.
     * @param value value to set the CustomerId
     */
    public void setCustomerId(Number value) {
        setAttributeInternal(CUSTOMERID, value);
    }

    /**
     * Gets the attribute value for CustomerNumber, using the alias name CustomerNumber.
     * @return the CustomerNumber
     */
    public String getCustomerNumber() {
        return (String)getAttributeInternal(CUSTOMERNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for CustomerNumber.
     * @param value value to set the CustomerNumber
     */
    public void setCustomerNumber(String value) {
        setAttributeInternal(CUSTOMERNUMBER, value);
    }

    /**
     * Gets the attribute value for CustomerName, using the alias name CustomerName.
     * @return the CustomerName
     */
    public String getCustomerName() {
        return (String)getAttributeInternal(CUSTOMERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for CustomerName.
     * @param value value to set the CustomerName
     */
    public void setCustomerName(String value) {
        setAttributeInternal(CUSTOMERNAME, value);
    }

    /**
     * Gets the attribute value for SystemDeliveryDate, using the alias name SystemDeliveryDate.
     * @return the SystemDeliveryDate
     */
    public Date getSystemDeliveryDate() {
        return (Date)getAttributeInternal(SYSTEMDELIVERYDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for SystemDeliveryDate.
     * @param value value to set the SystemDeliveryDate
     */
    public void setSystemDeliveryDate(Date value) {
        setAttributeInternal(SYSTEMDELIVERYDATE, value);
    }

    /**
     * Gets the attribute value for Subinventory, using the alias name Subinventory.
     * @return the Subinventory
     */
    public String getSubinventory() {
        return (String)getAttributeInternal(SUBINVENTORY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Subinventory.
     * @param value value to set the Subinventory
     */
    public void setSubinventory(String value) {
        setAttributeInternal(SUBINVENTORY, value);
    }

    /**
     * Gets the attribute value for GatepassNo, using the alias name GatepassNo.
     * @return the GatepassNo
     */
    public String getGatepassNo() {
        return (String)getAttributeInternal(GATEPASSNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for GatepassNo.
     * @param value value to set the GatepassNo
     */
    public void setGatepassNo(String value) {
        setAttributeInternal(GATEPASSNO, value);
    }

    /**
     * Gets the attribute value for GatepassDate, using the alias name GatepassDate.
     * @return the GatepassDate
     */
    public Date getGatepassDate() {
        return (Date)getAttributeInternal(GATEPASSDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for GatepassDate.
     * @param value value to set the GatepassDate
     */
    public void setGatepassDate(Date value) {
        setAttributeInternal(GATEPASSDATE, value);
    }

    /**
     * Gets the attribute value for TransportNo, using the alias name TransportNo.
     * @return the TransportNo
     */
    public String getTransportNo() {
        return (String)getAttributeInternal(TRANSPORTNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for TransportNo.
     * @param value value to set the TransportNo
     */
    public void setTransportNo(String value) {
        setAttributeInternal(TRANSPORTNO, value);
    }

    /**
     * Gets the attribute value for DriverName, using the alias name DriverName.
     * @return the DriverName
     */
    public String getDriverName() {
        return (String)getAttributeInternal(DRIVERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for DriverName.
     * @param value value to set the DriverName
     */
    public void setDriverName(String value) {
        setAttributeInternal(DRIVERNAME, value);
    }

    /**
     * Gets the attribute value for DriverContactNo, using the alias name DriverContactNo.
     * @return the DriverContactNo
     */
    public String getDriverContactNo() {
        return (String)getAttributeInternal(DRIVERCONTACTNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for DriverContactNo.
     * @param value value to set the DriverContactNo
     */
    public void setDriverContactNo(String value) {
        setAttributeInternal(DRIVERCONTACTNO, value);
    }

    /**
     * Gets the attribute value for FinalDestination, using the alias name FinalDestination.
     * @return the FinalDestination
     */
    public String getFinalDestination() {
        return (String)getAttributeInternal(FINALDESTINATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for FinalDestination.
     * @param value value to set the FinalDestination
     */
    public void setFinalDestination(String value) {
        setAttributeInternal(FINALDESTINATION, value);
    }

    /**
     * Gets the attribute value for VatChallanNo, using the alias name VatChallanNo.
     * @return the VatChallanNo
     */
    public String getVatChallanNo() {
        return (String)getAttributeInternal(VATCHALLANNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for VatChallanNo.
     * @param value value to set the VatChallanNo
     */
    public void setVatChallanNo(String value) {
        setAttributeInternal(VATCHALLANNO, value);
    }

    /**
     * Gets the attribute value for TotalWeight, using the alias name TotalWeight.
     * @return the TotalWeight
     */
    public Number getTotalWeight() {
        return (Number)getAttributeInternal(TOTALWEIGHT);
    }

    /**
     * Sets <code>value</code> as the attribute value for TotalWeight.
     * @param value value to set the TotalWeight
     */
    public void setTotalWeight(Number value) {
        setAttributeInternal(TOTALWEIGHT, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the Status
     */
    public String getStatus() {
        return (String)getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public Number getCreatedBy() {
        return (Number)getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreationDate.
     * @param value value to set the CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdateDate.
     * @param value value to set the LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**
     * Gets the attribute value for OuName, using the alias name OuName.
     * @return the OuName
     */
    public String getOuName() {
        return (String)getAttributeInternal(OUNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for OuName.
     * @param value value to set the OuName
     */
    public void setOuName(String value) {
        setAttributeInternal(OUNAME, value);
    }

    /**
     * Gets the attribute value for RowID, using the alias name RowID.
     * @return the RowID
     */
    public RowID getRowID() {
        return (RowID)getAttributeInternal(ROWID);
    }

    /**
     * Gets the attribute value for ItemCode, using the alias name ItemCode.
     * @return the ItemCode
     */
    public String getItemCode() {
        return (String)getAttributeInternal(ITEMCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItemCode.
     * @param value value to set the ItemCode
     */
    public void setItemCode(String value) {
        setAttributeInternal(ITEMCODE, value);
    }

    /**
     * Gets the attribute value for ItemDescription, using the alias name ItemDescription.
     * @return the ItemDescription
     */
    public String getItemDescription() {
        return (String)getAttributeInternal(ITEMDESCRIPTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItemDescription.
     * @param value value to set the ItemDescription
     */
    public void setItemDescription(String value) {
        setAttributeInternal(ITEMDESCRIPTION, value);
    }

    /**
     * Gets the attribute value for ItemId, using the alias name ItemId.
     * @return the ItemId
     */
    public Number getItemId() {
        return (Number)getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItemId.
     * @param value value to set the ItemId
     */
    public void setItemId(Number value) {
        setAttributeInternal(ITEMID, value);
    }

    /**
     * Gets the attribute value for LineNumber, using the alias name LineNumber.
     * @return the LineNumber
     */
    public Number getLineNumber() {
        return (Number)getAttributeInternal(LINENUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for LineNumber.
     * @param value value to set the LineNumber
     */
    public void setLineNumber(Number value) {
        setAttributeInternal(LINENUMBER, value);
    }

    /**
     * Gets the attribute value for RespId, using the alias name RespId.
     * @return the RespId
     */
    public Number getRespId() {
        return (Number)getAttributeInternal(RESPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RespId.
     * @param value value to set the RespId
     */
    public void setRespId(Number value) {
        setAttributeInternal(RESPID, value);
    }

    /**
     * Gets the attribute value for PropietorContactNo, using the alias name PropietorContactNo.
     * @return the PropietorContactNo
     */
    public String getPropietorContactNo() {
        return (String)getAttributeInternal(PROPIETORCONTACTNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for PropietorContactNo.
     * @param value value to set the PropietorContactNo
     */
    public void setPropietorContactNo(String value) {
        setAttributeInternal(PROPIETORCONTACTNO, value);
    }

    /**
     * Gets the attribute value for ProprietorName, using the alias name ProprietorName.
     * @return the ProprietorName
     */
    public String getProprietorName() {
        return (String)getAttributeInternal(PROPRIETORNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProprietorName.
     * @param value value to set the ProprietorName
     */
    public void setProprietorName(String value) {
        setAttributeInternal(PROPRIETORNAME, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }


    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

      /**
       * Custom DML update/insert/delete logic here.
       * @param operation the operation type
       * @param e the transaction event
       */
       protected void doDML(int operation, TransactionEvent e) {
             
            Map sessionScope = ADFContext.getCurrent().getSessionScope();   
            String user = (String)sessionScope.get("userId");
//            String user = "6489";
            
            String respId = (String)sessionScope.get("respId");
//            String respId = "5555";
             if (DML_INSERT == operation){
              
                 try {
                     System.out.println("@In INSERT DODML");
                     System.out.println("operation number: " + operation);
                      
                    setCreationDate((Date)Date.getCurrentDate());
                     
                     
                    setCreatedBy(new oracle.jbo.domain.Number(user));
                         
                     
                     
                     
                     setRespId(new oracle.jbo.domain.Number(respId));
                     
                    
                    
                 } catch (SQLException f) {
                     System.out.println(f.getMessage());
                 }
             }
             
           if(DML_UPDATE == operation){
               try {
                   System.out.println("@In UPDATE DODML");
                   System.out.println("operation number: " + operation);
                   setLastUpdateDate((Date)Date.getCurrentDate());
                   
                   setLastUpdatedBy(new oracle.jbo.domain.Number(user));
                   
               } catch (SQLException f) {
                   System.out.println(f.getMessage());
               }
           }
             super.doDML(operation, e);
       }
}