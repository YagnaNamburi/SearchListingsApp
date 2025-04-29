package org.searchListings.helpers;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SearchListingsHelper}.
 */
@Generated
public class SearchListingsHelper__BeanDefinitions {
  /**
   * Get the bean definition for 'searchListingsHelper'.
   */
  public static BeanDefinition getSearchListingsHelperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SearchListingsHelper.class);
    beanDefinition.setInstanceSupplier(SearchListingsHelper::new);
    return beanDefinition;
  }
}
