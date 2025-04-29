package org.searchListings.resources;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
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
    InstanceSupplier<SearchListingsResource> instanceSupplier = InstanceSupplier.using(SearchListingsResource::new);
    instanceSupplier = instanceSupplier.andThen(SearchListingsResource__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
