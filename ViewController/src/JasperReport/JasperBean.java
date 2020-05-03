package JasperReport;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;



import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import model.services.AppModuleImpl;

import oracle.adf.model.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCDataControl;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;


import java.sql.Connection;


import javax.naming.Context;
import javax.naming.InitialContext;



import javax.sql.DataSource;


import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.util.JRLoader;








public class JasperBean {
    public JasperBean() {
    }
    
    public ApplicationModule getAppM(){
        
        DCBindingContainer bindingContainer = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCDataControl dc = bindingContainer.findDataControl("AppModuleDataControl");
        AppModuleImpl appM = (AppModuleImpl)dc.getDataProvider();
        return appM;
    }
    
    AppModuleImpl am = (AppModuleImpl)this.getAppM();
    
   
    
    public void showMessage (String message){
    
        FacesMessage Message = new FacesMessage(message);   
        Message.setSeverity(FacesMessage.SEVERITY_INFO);   
        FacesContext fc = FacesContext.getCurrentInstance();   
        fc.addMessage(null, Message);     
    
    }
    
    
    /**
     * Jasper report code starts
     */
    
     public BindingContainer getBindings()
       {
         return (BindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
       } 
       
       public Connection getDataSourceConnection(String dataSourceName) throws Exception
         {
           Context ctx = new InitialContext();
           DataSource ds = (DataSource)ctx.lookup(dataSourceName);
           return ds.getConnection();
         }
       
       private Connection getConnection() throws Exception
       {
         return getDataSourceConnection("java:comp/env/jdbc/Conn1DS"); // use datasourse in your application; datasource must be defined in weblogic
//         return getDataSourceConnection("Conn1");
//         return getDataSourceConnection("jdbc/Conn1DS"); //JNDI Name for deployment
//         String amDef = "model.services.AppModule";
//         String config = "AppModuleLocal";
//         PreparedStatement st = null;
//
//         AppModuleImpl appM =(AppModuleImpl)Configuration.createRootApplicationModule(amDef,config);
//         
//         st = appM.getDBTransaction().createPreparedStatement("select 1 from dual", 0);
//         Connection conn = st.getConnection();
//         
//         return conn; 
         
       }
       
       public  ServletContext getContext()
       {
         return (ServletContext)getFacesContext().getExternalContext().getContext();
       }
       
       public  HttpServletResponse getResponse()
       {
         return (HttpServletResponse)getFacesContext().getExternalContext().getResponse();
       }
       
       public static FacesContext getFacesContext()
       {
         return FacesContext.getCurrentInstance();
       }
       
       public void runReport(String repPath, java.util.Map param) throws Exception
       {
         Connection conn = null;
         try
         {
           HttpServletResponse response = getResponse();
           ServletOutputStream out = response.getOutputStream();
           response.setHeader("Cache-Control", "max-age=0");
           response.setContentType("application/pdf");
           ServletContext context = getContext();
           InputStream fs = context.getResourceAsStream("/reports/" + repPath);//we will put the report under folder "reports" under Web Content
           
           
           JasperReport template = (JasperReport) JRLoader.loadObject(fs);
           template.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
           conn = getConnection();
           JasperPrint print = JasperFillManager.fillReport(template, param, conn);
           
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           JasperExportManager.exportReportToPdfStream(print, baos);
           
           out.write(baos.toByteArray());
           
           out.flush();
           out.close();
           FacesContext.getCurrentInstance().responseComplete();
           System.out.println(" Report Run Successfully from JasperBean!");
           
           
            
         }
         catch (Exception jex)
         {
           //showMessage(jex.getMessage());
           showMessage(jex.toString());
           jex.printStackTrace();
           
         }
         finally
         {    
           close(conn);
         }
       }
       
       public void close(Connection con)
        {
          if (con != null)
          {
            try
            {
              con.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
          }
        }

    public void runGatePassReportCommandLink(ActionEvent actionEvent) {
        ViewObject vo = am.getXxGatepassVO1();
        try {
            String headerId =  vo.getCurrentRow().getAttribute("HeaderId").toString();
            System.out.println("HeaderId: " + headerId);
            
            Map m = new HashMap();
            m.put("HeaderId", headerId); // HeaderId is a jasper parameter name
            
//            runReport("report3.jasper", m);
//            runReport("deliveryChallanReport.jasper", m);
//            runReport("report4.jasper", m);
//            runReport("report5.jasper", m);
            runReport("report10.jasper", m);
//            runReport("report1.jasper", m);
            
        } catch (NullPointerException ex){
            
            showMessage("No Data Available For Generating Report!");
        }
        
        catch (Exception e) {
            
            showMessage(e.toString());
            
            e.printStackTrace();
        }
    }
    
    public void refreshVO(ViewObject vo){
        
        vo.executeQuery();
        
        System.out.println("VO executed in JasperBean");
    }
    
    

}
