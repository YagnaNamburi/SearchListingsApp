package org.searchListings.services;

import org.searchListings.helpers.SearchListingsHelper;
import org.searchListings.models.ListingParent;
import org.searchListings.models.SearchListingsInput;
import org.searchListings.models.SearchListingsOutput;
import org.slf4j.Logger;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.searchListings.models.Listing;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class SearchListingsResourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchListingsResourceService.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    SearchListingsHelper searchListingsHelper;

    public String searchListings(String searchListingsInputString)
    {
        try {
            List<SearchListingsInput> searchListingsInputList = objectMapper.readValue(searchListingsInputString, new TypeReference<List<SearchListingsInput>>() {
            });
            if (searchListingsInputList.size() == 0) {
                return "Please enter atleast one search input in order to display listings";
            }
            else
            {
                List<SearchListingsInput> searchListingsInputs = granularizeSearchInputs(searchListingsInputList);
                List<Listing> totalAvailableListingsList = objectMapper.readValue(new File("src/main/resources/listings.json"), new TypeReference<List<Listing>>() {
                });
                List<ListingParent> totalAvailableListings = new ArrayList<>();
                for(Listing listing : totalAvailableListingsList){
                    totalAvailableListings.add(new ListingParent(listing.getId(), listing.getLocation_id(), listing.getLength(), listing.getWidth(), listing.getPrice_in_cents(),null, false));
                }
                List<SearchListingsOutput> searchListingsOutputs = searchListingsHelper.findBestListingMatches(searchListingsInputs, totalAvailableListings);
                if(searchListingsOutputs == null || searchListingsOutputs.size() == 0) {
                    return "No search listings found for the search criteria";
                }
                else {
                    LOGGER.info("These are the number of output locations :"+searchListingsOutputs.size());
                    return searchListingsOutputs.toString();
                }
            }
        }
        catch(Exception e){
            LOGGER.error("Error :" + e);
        }
        return "error";
    }

    private List<SearchListingsInput> granularizeSearchInputs(List<SearchListingsInput> searchListingsInputList) {
        List<SearchListingsInput> granularizedSearchInputs = new ArrayList<>();
        for(SearchListingsInput searchListingsInput : searchListingsInputList){
            int quantity = searchListingsInput.getQuantity();
            while(quantity >= 1){
                SearchListingsInput searchListingsInput1 = new SearchListingsInput(searchListingsInput.getLength(), 1);
                granularizedSearchInputs.add(searchListingsInput1);
                quantity--;
            }
        }
        return granularizedSearchInputs;
    }
}
