package org.searchListings.resources;

import org.searchListings.services.SearchListingsResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchListingsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchListingsResource.class);

    @Autowired
    SearchListingsResourceService searchListingsResourceService;

    @PostMapping("/searchListings")
    public String searchListings(@RequestBody String searchListingsInputString){
        LOGGER.info("This is the request String : "+searchListingsInputString);
        if(searchListingsInputString == null || searchListingsInputString.length() == 0){
            return "Please enter some input to search for listings";
        }
        return searchListingsResourceService.searchListings(searchListingsInputString);
    }
}
