package org.searchListings;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link SearchListingsApp}.
 */
@Generated
public class SearchListingsApp__BeanDefinitions {
  /**
   * Get the bean definition for 'searchListingsApp'.
   */
  public static BeanDefinition getSearchListingsAppBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SearchListingsApp.class);
    beanDefinition.setTargetType(SearchListingsApp.class);
    ConfigurationClassUtils.initializeConfigurationClass(SearchListingsApp.class);
    beanDefinition.setInstanceSupplier(SearchListingsApp$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
