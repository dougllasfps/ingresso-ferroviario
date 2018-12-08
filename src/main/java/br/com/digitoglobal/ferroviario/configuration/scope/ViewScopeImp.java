package br.com.digitoglobal.ferroviario.configuration.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * This uses the FacesContext view map as a datastore for a scope in the Spring
 * Framework
 * <p>
 * More simply this is a view scope implementation that works in spring
 *
 * @author Optimus Prime(From the primefaces
 * team)(http://blog.primefaces.org/?p=702)
 */
public class ViewScopeImp implements Scope {

    public static ViewScopeImp createInstance() {
        return new ViewScopeImp();
    }

    private ViewScopeImp() {
    }

    public Object get(String name, ObjectFactory<? extends Object> objectFactory) {
        Map<String, Object> viewMap = FacesContext.getCurrentInstance()
                .getViewRoot().getViewMap();
        Object obj;
        if (viewMap.containsKey(name)) {
            obj = viewMap.get(name);
        } else {
            Object object = objectFactory.getObject();
            viewMap.put(name, object);
            obj = object;
        }
        return obj;
    }

    public Object remove(String name) {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap()
                .remove(name);
    }

    public String getConversationId() {
        return null;
    }

    public void registerDestructionCallback(String name, Runnable callback) {
        // Not supported
    }

    public Object resolveContextualObject(String key) {
        return null;
    }
}