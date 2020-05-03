package Main;

import JasperReport.JasperBean;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;

import java.text.DateFormat;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.services.AppModuleImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.adf.view.rich.util.ResetUtils;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class Main {
    private RichInputText insertIntoXXGatePassTable;
    private RichInputText gatePassNoInputValueBind;
    private RichInputText transportNo;
    private RichInputText getTransportNoInputBind;
    private RichInputText getDriverNameInputBind;
    private RichInputText getDriverContactInputBind;
    private RichInputText getFinalDestinationInputBind;
    private RichInputText getVatChallanNoInputBind;
    private RichInputText getTotalWeightInputBind;
    private RichInputDate getGatePassInputBind;
    private RichInputDate gatePassDate;
    private RichTable getPassHeaderTableBind;
    private String rowsNo="", dateStr="";
    private String finalDestInputField = "", vatChallanInputField = "", totalWeight = "";
    private JasperBean jasperBean = new JasperBean();
    private RichCommandLink submitReportCommLinkBind;
    private RichTable gatePassDetailTable;


    public Main() {
    }

    public void setInsertIntoXXGatePassTable(RichInputText insertIntoXXGatePassTable) {
        this.insertIntoXXGatePassTable = insertIntoXXGatePassTable;
    }

    public RichInputText getInsertIntoXXGatePassTable() {
        return insertIntoXXGatePassTable;
    }

    public void setGatePassNoInputValueBind(RichInputText gatePassNoInputValueBind) {
        this.gatePassNoInputValueBind = gatePassNoInputValueBind;

    }
              

    public RichInputText getGatePassNoInputValueBind() {
        return gatePassNoInputValueBind;
    }
    
    public ApplicationModule getAppM(){
            DCBindingContainer bindingContainer =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            //BindingContext bindingContext = BindingContext.getCurrent();
            DCDataControl dc =
                bindingContainer.findDataControl("AppModuleDataControl"); // Name of application module in datacontrolBinding.cpx
            AppModuleImpl appM = (AppModuleImpl)dc.getDataProvider();
           
        return appM;
        }
        
        AppModuleImpl am = (AppModuleImpl)this.getAppM();

    public void saveXXGatePassTable(ActionEvent actionEvent) {

        System.out.println(" In @saveXXGatePassTable Method ");
        
        
        
        try {
            //am.getDBTransaction().clearEntityCache("model.entity.XxGatepassEO");
//            ViewObject vo = am.getXxGatepassVO1();
            ViewObject vo = am.getgatepass1();

            
            String headerId =  vo.getCurrentRow().getAttribute("HeaderId").toString();
            System.out.println("HeaderId: " + headerId);
            
            Map m = new HashMap();
            m.put("HeaderId", headerId); // HeaderId is a jasper parameter name
            

            
            
            if (getGetTransportNoInputBind().getValue()==null){
                warnMessage("Please Enter Required Value!");
                return;
            }
            else if (getGetDriverNameInputBind().getValue()==null) {
                warnMessage("Please Enter Required Value!");
                return;
            }  
            else if (getGetDriverContactInputBind().getValue()==null) {
                warnMessage("Please Enter Required Value!");
                return;
            }

                 
            //else starts
            System.out.println("else.......");
            Row sendTableRow = createSendTableLines();
              
            insertXXGetPassTableMap(sendTableRow);
            
            jasperBean.runReport("report10.jasper", m);
            
            System.out.println("Report Generated Successfully!");
            
            vo.executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(getPassHeaderTableBind);
        } 
        
           catch(NullPointerException e){
                e.printStackTrace();
                warnMessage(e.toString());
            
            }
        
        
            catch (Exception e) {
            
                e.printStackTrace();
                warnMessage(e.toString());
            
            }
        
          

    }
    
    public void insertXXGetPassTableMap(Row sendingTableRow) { //inserting XXGetPass table
        System.out.println(" In @Insert Method ");
//        am = (AppModuleImpl)this.getAppM();
        
                    
           
            
        try {
            //System.out.println("Gate Pass Date:"+getGatePassDate().getValue().toString());
            //java.sql.Date sqlDate =  java.sql.Date.valueOf(dateStr);
            //System.out.println("sqlDate:"+getGatePassDate().getValue().toString());
            System.out.println("Gatepass Date:" + getGatePassDate().getValue().toString());
            
            ViewObject getVO = am.getgatepass1(); 
            ViewObject getLineVO = am.getGatePassDetail1();
            getAutoGeneratedGatePassNo();
            
            System.out.println("Gatepass No: " + rowsNo);
            
            sendingTableRow.setAttribute("HeaderId", Integer.parseInt(getVO.getCurrentRow().getAttribute("HeaderId").toString()));
            sendingTableRow.setAttribute("OrderNumber", Integer.parseInt(getVO.getCurrentRow().getAttribute("OrderNumber").toString()));
            sendingTableRow.setAttribute("DeliveryId", Integer.parseInt(getVO.getCurrentRow().getAttribute("DeliveryId").toString()));
            sendingTableRow.setAttribute("OuName", getVO.getCurrentRow().getAttribute("OperatingUnitName").toString());
            sendingTableRow.setAttribute("CustomerId", getVO.getCurrentRow().getAttribute("CustomerId").toString());
            sendingTableRow.setAttribute("CustomerNumber", getVO.getCurrentRow().getAttribute("CustomerNumber").toString());
            sendingTableRow.setAttribute("CustomerName", getVO.getCurrentRow().getAttribute("CustomerName").toString());
            sendingTableRow.setAttribute("Subinventory", getVO.getCurrentRow().getAttribute("Subinventory").toString());
//            if (getVO.getCurrentRow().getAttribute("ProprietorName") == null){
//                    sendingTableRow.setAttribute("ProprietorName", "");
//                }
//            else{
//                
//            }
            sendingTableRow.setAttribute("ProprietorName", getVO.getCurrentRow().getAttribute("ProprietorName"));
            sendingTableRow.setAttribute("PropietorContactNo", getVO.getCurrentRow().getAttribute("ProprietorContactNo"));
            sendingTableRow.setAttribute("LineNumber", Integer.parseInt(getVO.getCurrentRow().getAttribute("LineNumber").toString()));
            
            sendingTableRow.setAttribute("SystemDeliveryDate", getVO.getCurrentRow().getAttribute("SystemDeliveryDate"));
            sendingTableRow.setAttribute("Status", "Yes");

            sendingTableRow.setAttribute("OrderedDate", getVO.getCurrentRow().getAttribute("OrderedDate"));
            sendingTableRow.setAttribute("OrganizationCode", getVO.getCurrentRow().getAttribute("OrganizationCode"));
            sendingTableRow.setAttribute("OperatingUnit", getVO.getCurrentRow().getAttribute("OperatingUnit"));
            sendingTableRow.setAttribute("OrganizationId", getVO.getCurrentRow().getAttribute("OrganizationId"));
            
            sendingTableRow.setAttribute("ItemCode", getLineVO.getCurrentRow().getAttribute("ItemCode").toString());
            sendingTableRow.setAttribute("ItemDescription", getLineVO.getCurrentRow().getAttribute("ItemDesc").toString());
            sendingTableRow.setAttribute("ItemId", Integer.parseInt(getLineVO.getCurrentRow().getAttribute("ItemId").toString()));
         
            
            sendingTableRow.setAttribute("GatepassNo", rowsNo);
       
            sendingTableRow.setAttribute("TransportNo", getGetTransportNoInputBind().getValue().toString());


            sendingTableRow.setAttribute("DriverName", getGetDriverNameInputBind().getValue().toString());


            sendingTableRow.setAttribute("DriverContactNo", getGetDriverContactInputBind().getValue().toString());


            if (getFinalDestinationInputBind.getValue() == null){
                    
                    
                    sendingTableRow.setAttribute("FinalDestination", " ");
                
            }
            else{
                sendingTableRow.setAttribute("FinalDestination",getGetFinalDestinationInputBind().getValue().toString());
            }

            if (getVatChallanNoInputBind.getValue() == null){
                    
                    
                    sendingTableRow.setAttribute("VatChallanNo", " ");
                
            }
            else{
                sendingTableRow.setAttribute("VatChallanNo", getGetVatChallanNoInputBind().getValue().toString());
            }

            if (getTotalWeightInputBind.getValue() == null){
                
                sendingTableRow.setAttribute("TotalWeight", " ");
            }
            else{
                sendingTableRow.setAttribute("TotalWeight", Integer.parseInt(getGetTotalWeightInputBind().getValue().toString()));
            }

                   
            sendingTableRow.setAttribute("GatepassDate", getGatePassDate().getValue());
            
            
            am.getDBTransaction().commit();
//            showMessage("Submitted Successfully!");
            
//            ViewObject vo= am.getgatepass1();
//            vo.executeQuery();
//            System.out.println("VO executed in MainBean");
            

        } 
        
        catch(NullPointerException ex){
            
            
            ex.printStackTrace();
            warnMessage(ex.toString());
            
        }
        
        catch (Exception e) {
            
            e.printStackTrace();
            warnMessage(e.toString());
        }
        
    }
    
    public void showMessage (String message){
//        System.out.println("enters showMessage()..........");
        FacesMessage Message = new FacesMessage(message);   
        Message.setSeverity(FacesMessage.SEVERITY_INFO);   
        FacesContext fc = FacesContext.getCurrentInstance();   
        fc.addMessage(null, Message);     
    
    }
    
    public void warnInputText (RichInputText inputText,String message){
        FacesMessage Message = new FacesMessage(message);
        Message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(inputText.getClientId(fc), Message);
        
        
    }
    
    public void warnMessage(String message){
        FacesMessage Message = new FacesMessage(message);   
        Message.setSeverity(FacesMessage.SEVERITY_WARN);   
        FacesContext fc = FacesContext.getCurrentInstance();   
        fc.addMessage(null, Message);   
    }
    
    public boolean emptyValueCheck(String value,String message){
        
        if(value!=""){
            return true;
        }else{
              FacesMessage Message = new FacesMessage(message);   
              Message.setSeverity(FacesMessage.SEVERITY_INFO);   
              FacesContext fc = FacesContext.getCurrentInstance();   
              fc.addMessage(null, Message);
            return false;
        }
               
    }
    
    
    
    public String getPopulateValue(Row r, String columnName) {
//        System.out.println(" In @getPopulateValue Method ");
        String value = null;
        try {
            value = r.getAttribute(columnName).toString();
//            System.out.println( "  -->Column Value: " + value );
        } catch (Exception e) {
            ;
        }
        return value;
    }
    
    public Row createSendTableLines() {
        System.out.println(" In @CreateLines Method ");
        ViewObject populatevo = am.getXxGatepassVO1();
        Row row = populatevo.createRow(); //Creates a new Row object, but does not insert it into the Row Set
        populatevo.insertRow(row); //Inserts a row to the Row Set, before the current row
        row.setNewRowState(Row.STATUS_INITIALIZED);
        
        //Sets a new unposted row, created in this transaction,
        //to either STATUS_NEW or STATUS_INITIALIZED(new row but temporary row) mode
        return row;
    }
   


    public void setTransportNo(RichInputText transportNo) {
        this.transportNo = transportNo;
    }

    public RichInputText getTransportNo() {
        return transportNo;
    }

    public void setGetTransportNoInputBind(RichInputText getTransportNoInputBind) {
        this.getTransportNoInputBind = getTransportNoInputBind;
    }

    public RichInputText getGetTransportNoInputBind() {
        return getTransportNoInputBind;
    }

    public void setGetDriverNameInputBind(RichInputText getDriverNameInputBind) {
        this.getDriverNameInputBind = getDriverNameInputBind;
    }

    public RichInputText getGetDriverNameInputBind() {
        return getDriverNameInputBind;
    }

    public void setGetDriverContactInputBind(RichInputText getDriverContactInputBind) {
        this.getDriverContactInputBind = getDriverContactInputBind;
    }

    public RichInputText getGetDriverContactInputBind() {
        return getDriverContactInputBind;
    }

    public void setGetFinalDestinationInputBind(RichInputText getFinalDestinationInputBind) {
        this.getFinalDestinationInputBind = getFinalDestinationInputBind;
    }

    public RichInputText getGetFinalDestinationInputBind() {
        return getFinalDestinationInputBind;
    }

    public void setGetVatChallanNoInputBind(RichInputText getVatChallanNoInputBind) {
        this.getVatChallanNoInputBind = getVatChallanNoInputBind;
    }

    public RichInputText getGetVatChallanNoInputBind() {
        return getVatChallanNoInputBind;
    }

    public void setGetTotalWeightInputBind(RichInputText getTotalWeightInputBind) {
        this.getTotalWeightInputBind = getTotalWeightInputBind;
    }

    public RichInputText getGetTotalWeightInputBind() {
        return getTotalWeightInputBind;
    }

    public void setGetGatePassInputBind(RichInputDate getGatePassInputBind) {
        this.getGatePassInputBind = getGatePassInputBind;
    }

    public RichInputDate getGetGatePassInputBind() {
        return getGatePassInputBind;
    }

    public void setGatePassDate(RichInputDate gatePassDate) {
        this.gatePassDate = gatePassDate;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date = new java.util.Date();
        dateStr = dateFormat.format(date);
        System.out.println("Gatepass Date: " + dateStr);
        this.gatePassDate.setValue(dateStr);
    }

    public RichInputDate getGatePassDate() {
        return gatePassDate;
    }

    public void setGetPassHeaderTableBind(RichTable getPassHeaderTableBind) {
        this.getPassHeaderTableBind = getPassHeaderTableBind;
    }

    public RichTable getGetPassHeaderTableBind() {
        return getPassHeaderTableBind;
    }

    public void gatepassInfoPopUpFetchListener(PopupFetchEvent popupFetchEvent) {
        
        ViewObject vo = am.getXxGatepassVO1();
        
        vo.executeQuery();
    }
    
   
    public void getAutoGeneratedGatePassNo(){        
            DCBindingContainer bindingContainer =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            
            DCDataControl dc =
                bindingContainer.findDataControl("AppModuleDataControl"); // Name of application module in datacontrolBinding.cpx
            AppModuleImpl appM1 = (AppModuleImpl)dc.getDataProvider();
            
//            AppModuleImpl am = (AppModuleImpl)this.getAppM();
//            System.out.println("am"+a
            
            String sql="select xx_ssl_gatepass_no((select to_number((select count(*) as tt from XX_GATEPASS where creation_date=(SELECT TO_DATE(to_char(sysdate,'mm/dd/yyyy'),'mm/dd/yyyy') as dd FROM dual))) as nm from dual)+1) as rows_num from dual";
            
            ResultSet rs;
                   // Integer code = null;
            
                    try {
                        rs = appM1.getDBTransaction().createStatement(0).executeQuery(sql);
                        
                        if (rs.next()) {
                            rowsNo = rs.getString("rows_num");
                            
                            
                        }

                        rs.close();
                        //return code;

                    } catch (SQLException e) {
                        throw new JboException(e);
                    }
            
            
        }


    public void orderDetailsPopupFetchListener(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
        
        ViewObject vo = am.getGatePassDetail1();
        vo.executeQuery();
    }

    public void transportNoValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        
        
        if(getTransportNoInputBind.getValue().toString().equals("")){
            warnInputText(getGetTransportNoInputBind(),"Please Enter Transport No.!");   
        }
        

    }

    public void driverNameValueChangeEvent(ValueChangeEvent valueChangeEvent) {
       
        
        if (getDriverNameInputBind.getValue().toString().equals("")){
            warnInputText(getGetDriverNameInputBind(),"Please Enter Driver Name!"); 
        }
    }

    public void driverContactNoValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        if (getDriverContactInputBind.getValue().toString().equals("")){
            warnInputText(getGetDriverContactInputBind(),"Please Enter Driver Contact No.!"); 
        }
    }

    public void saveXXGatePassCommandLink(ActionEvent actionEvent) {
        System.out.println(" In @saveXXGatePassTable Method ");
        
        
        
        try {
            //am.getDBTransaction().clearEntityCache("model.entity.XxGatepassEO");
        //            ViewObject vo = am.getXxGatepassVO1();
            ViewObject vo = am.getgatepass1();

            
            String headerId =  vo.getCurrentRow().getAttribute("HeaderId").toString();
            System.out.println("HeaderId: " + headerId);
            
            Map m = new HashMap();
            m.put("HeaderId", headerId); // HeaderId is a jasper parameter name
            

            
            
            if (getGetTransportNoInputBind().getValue()==null || getGetTransportNoInputBind().equals(null) || getGetTransportNoInputBind().equals("") ){
                warnMessage("Please Enter Required Value!");
                return;
            }
            else if (getGetDriverNameInputBind().getValue()==null || getGetTransportNoInputBind().equals(null) || getGetTransportNoInputBind().equals("")) {
                warnMessage("Please Enter Required Value!");
                return;
            }  
            else if (getGetDriverContactInputBind().getValue()==null || getGetTransportNoInputBind().equals(null) || getGetTransportNoInputBind().equals("")) {
                warnMessage("Please Enter Required Value!");
                return;
            }

                 
            //else starts
            System.out.println("else.......");
            Row sendTableRow = createSendTableLines();
              
            insertXXGetPassTableMap(sendTableRow);
            
//            warnMessage("Successfully Generated PDF Report, Please Refresh the Application Now!");
            
            jasperBean.runReport("report10.jasper", m);
            
            System.out.println("Report Generated Successfully from MainBean!");
            
            

            
//            AdfFacesContext.getCurrentInstance().addPartialTarget(getPassHeaderTableBind);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(submitReportCommLinkBind);
        } 
        
           catch(NullPointerException e){
                e.printStackTrace();
                warnMessage(e.toString());
            
            }
        
        
            catch (Exception e) {
            
                e.printStackTrace();
                warnMessage(e.toString());
            
            }
    }

    public void setSubmitReportCommLinkBind(RichCommandLink submitReportCommLinkBind) {
        this.submitReportCommLinkBind = submitReportCommLinkBind;
    }

    public RichCommandLink getSubmitReportCommLinkBind() {
        return submitReportCommLinkBind;
    }

    public void refreshButtonActionListener(ActionEvent actionEvent) {
        jasperBean.refreshVO(am.getgatepass1());
    }

    public String callAttachment() {
        System.out.println("Enter in call attachment....");
        String orderNo = null;
        ViewObject vo = am.getXxGatepassVO1();
        try {
            orderNo = vo.getCurrentRow().getAttribute("OrderNumber").toString();
            System.out.println("Order No: " + orderNo);
            String newPage = "http://192.168.200.115:7003/FileUploading-ViewController-context-root/faces/view1?doc=Order_No_&docNo=" + orderNo;
            FacesContext ctx = FacesContext.getCurrentInstance();
            ExtendedRenderKitService erks = Service.getService(ctx.getRenderKit(), ExtendedRenderKitService.class);
            String url = "window.open('" + newPage + "','_blank','toolbar=no,location=no,menubar=no,alwaysRaised=yes,height=500,width=1100');";
            erks.addScript(FacesContext.getCurrentInstance(), url);
            System.out.println("Attachment Appears!");
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return null;
    }

    public String refreshAll() {
        System.out.println("Enter in Refresh All....");
        ViewObject vo1, vo2;
        

        
        AdfFacesContext.getCurrentInstance().addPartialTarget(getPassHeaderTableBind);
        AdfFacesContext.getCurrentInstance().addPartialTarget(gatePassDetailTable);
        
        vo1 = am.getgatepass1();
        vo2 = am.getGatePassDetail1();
        
        vo1.executeQuery();
        vo2.executeQuery();
        
        
    
        
        System.out.println("Refresh All executed!");
        
        return null;
    }

    public void setGatePassDetailTable(RichTable gatePassDetailTable) {
        this.gatePassDetailTable = gatePassDetailTable;
    }

    public RichTable getGatePassDetailTable() {
        return gatePassDetailTable;
    }
}


