/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author anton
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
        try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cguide.db.webservices.ExamWebService.class);
        resources.add(cguide.db.webservices.FormulaWebService.class);
        resources.add(cguide.db.webservices.GuideexecWebService.class);
        resources.add(cguide.db.webservices.GuideexecsWebService.class);
        resources.add(cguide.db.webservices.GuidelineWebService.class);
        resources.add(cguide.db.webservices.GuidelinesWebService.class);
        resources.add(cguide.db.webservices.MedicationWebService.class);
        resources.add(cguide.db.webservices.NonmedicationWebService.class);
        resources.add(cguide.db.webservices.ObservationWebService.class);
        resources.add(cguide.db.webservices.PatientWebService.class);
        resources.add(cguide.db.webservices.ProcedureWebService.class);
        resources.add(cguide.db.webservices.TaskWebService.class);
        resources.add(cguide.db.webservices.UserWebService.class);
        resources.add(cguide.execution.webservices.GuidelineWebService.class);
        resources.add(cguide.execution.webservices.GuidelineWebService2.class);
        resources.add(cguide.execution.webservices.TaskWebService.class);
        resources.add(cguide.filters.OldExceptionMapper.class);
    }
    
}
