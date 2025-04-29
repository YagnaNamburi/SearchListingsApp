package org.searchListings.resources;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SearchListingsResource}.
 */
@Generated
public class SearchListingsResource__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SearchListingsResource apply(RegisteredBean registeredBean,
      SearchListingsResource instance) {
    instance.searchListingsResourceService = AutowiredFieldValueResolver.forRequiredField("searchListingsResourceService").resolve(registeredBean);
    return instance;
  }
}
