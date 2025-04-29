package org.searchListings.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SearchListingsResourceService}.
 */
@Generated
public class SearchListingsResourceService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SearchListingsResourceService apply(RegisteredBean registeredBean,
      SearchListingsResourceService instance) {
    instance.searchListingsHelper = AutowiredFieldValueResolver.forRequiredField("searchListingsHelper").resolve(registeredBean);
    instance.resourceLoader = AutowiredFieldValueResolver.forRequiredField("resourceLoader").resolve(registeredBean);
    return instance;
  }
}
