package org.searchListings.resources;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SearchListingsResource}.
 */
@Generated
public class SearchListingsResource__BeanDefinitions {
  /**
   * Get the bean definition for 'searchListingsResource'.
   */
  public static BeanDefinition getSearchListingsResourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SearchListingsResource.class);
    beanDefinition.setInstanceSupplier(SearchListingsResource::new);
    return beanDefinition;
  }
}
