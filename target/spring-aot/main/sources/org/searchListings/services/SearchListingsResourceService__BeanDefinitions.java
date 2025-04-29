package org.searchListings.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SearchListingsResourceService}.
 */
@Generated
public class SearchListingsResourceService__BeanDefinitions {
  /**
   * Get the bean definition for 'searchListingsResourceService'.
   */
  public static BeanDefinition getSearchListingsResourceServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SearchListingsResourceService.class);
    InstanceSupplier<SearchListingsResourceService> instanceSupplier = InstanceSupplier.using(SearchListingsResourceService::new);
    instanceSupplier = instanceSupplier.andThen(SearchListingsResourceService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
