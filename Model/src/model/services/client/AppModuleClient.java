package model.services.client;

import model.services.common.AppModule;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Apr 04 16:47:02 BDT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleClient extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleClient() {
    }

    public void setSessionValues(String orgId, String userId, String respId,
                                 String respAppl) {
        Object _ret =
            this.riInvokeExportedMethod(this,"setSessionValues",new String [] {"java.lang.String","java.lang.String","java.lang.String","java.lang.String"},new Object[] {orgId, userId, respId, respAppl});
        return;
    }
}
