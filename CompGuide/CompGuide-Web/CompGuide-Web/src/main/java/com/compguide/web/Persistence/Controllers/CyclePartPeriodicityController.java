package com.compguide.web.Persistence.Controllers;

import com.compguide.web.Persistence.Entities.CyclePartPeriodicity;
import com.compguide.web.Persistence.Controllers.util.JsfUtil;
import com.compguide.web.Persistence.Controllers.util.JsfUtil.PersistAction;
import com.compguide.web.Persistence.SessionBeans.CyclePartPeriodicityFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("cyclePartPeriodicityController")
@SessionScoped
public class CyclePartPeriodicityController implements Serializable {

    @EJB
    private com.compguide.web.Persistence.SessionBeans.CyclePartPeriodicityFacade ejbFacade;
    private List<CyclePartPeriodicity> items = null;
    private CyclePartPeriodicity selected;

    public CyclePartPeriodicityController() {
    }

    public CyclePartPeriodicity getSelected() {
        return selected;
    }

    public void setSelected(CyclePartPeriodicity selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CyclePartPeriodicityFacade getFacade() {
        return ejbFacade;
    }

    public CyclePartPeriodicity prepareCreate() {
        selected = new CyclePartPeriodicity();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("resources/Bundle").getString("CyclePartPeriodicityCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("resources/Bundle").getString("CyclePartPeriodicityUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("resources/Bundle").getString("CyclePartPeriodicityDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CyclePartPeriodicity> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.UPDATE) {
                    getFacade().edit(selected);
                }
                if (persistAction == PersistAction.DELETE) {
                    getFacade().remove(selected);
                }
                if (persistAction == PersistAction.CREATE) {
                    getFacade().create(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public CyclePartPeriodicity getCyclePartPeriodicity(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CyclePartPeriodicity> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CyclePartPeriodicity> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CyclePartPeriodicity.class)
    public static class CyclePartPeriodicityControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CyclePartPeriodicityController controller = (CyclePartPeriodicityController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cyclePartPeriodicityController");
            return controller.getCyclePartPeriodicity(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CyclePartPeriodicity) {
                CyclePartPeriodicity o = (CyclePartPeriodicity) object;
                return getStringKey(o.getCyclePartPeriodicityID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CyclePartPeriodicity.class.getName()});
                return null;
            }
        }

    }

}
