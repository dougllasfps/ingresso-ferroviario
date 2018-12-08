package br.com.digitoglobal.ferroviario.configuration;

import br.com.digitoglobal.ferroviario.configuration.scope.ViewScopeImp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({FacesContext.class, UIViewRoot.class})
public class ScopesAutoConfiguration implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        configurableListableBeanFactory.registerScope("view", ViewScopeImp.createInstance());
    }
}
