package org.searchListings.helpers;

import org.searchListings.models.ListingParent;
import org.searchListings.models.SearchListingsInput;
import org.searchListings.models.SearchListingsOutput;
import org.springframework.stereotype.Component;

import java.util.*;

import static org.searchListings.constants.Constants.*;

@Component
public class SearchListingsHelper {
    public List<SearchListingsOutput> findBestListingMatches(List<SearchListingsInput> searchListingsInputs, List<ListingParent> totalAvailableListings) {
        //create a location->listings map
        Map<String, List<ListingParent>> listingForLocationMap = new HashMap<>();
        List<SearchListingsOutput> searchListingsOutput = new ArrayList<>();
        for (ListingParent availableListing : totalAvailableListings) {
            List<ListingParent> availableListingsForLocation;
            if (listingForLocationMap.containsKey(availableListing.getLocation_id())) {
                availableListingsForLocation = listingForLocationMap.get(availableListing.getLocation_id());
                availableListingsForLocation.add(availableListing);
            } else {
                availableListingsForLocation = new ArrayList<>();
                availableListingsForLocation.add(availableListing);
            }
            listingForLocationMap.put(availableListing.getLocation_id(), availableListingsForLocation);
        }
        for (Map.Entry<String, List<ListingParent>> entry : listingForLocationMap.entrySet()) {
            List<ListingParent> bestListingCombination = findBestCombinationOfListings(searchListingsInputs, entry);
            populateSearchListingsOutput(searchListingsOutput, bestListingCombination, entry.getKey());
        }
        return searchListingsOutput;
    }

    private void populateSearchListingsOutput(List<SearchListingsOutput> searchListingsOutput, List<ListingParent> bestListingCombination, String locationId) {
        if(bestListingCombination != null && bestListingCombination.size() > 0){
            List<String> listingIds = new ArrayList<>();
            int bestPrice = 0;
            for(ListingParent listingParent : bestListingCombination){
                listingIds.add(listingParent.getId());
                bestPrice += listingParent.getPrice_in_cents();
            }
            searchListingsOutput.add(new SearchListingsOutput(locationId, listingIds, bestPrice));
        }
    }

    private List<ListingParent> findBestCombinationOfListings(List<SearchListingsInput> searchListingsInputs, Map.Entry<String, List<ListingParent>> entry) {
        List<ListingParent> availableListings = entry.getValue();
        List<List<ListingParent>> result = new ArrayList<>();
        findBestCombination(0, searchListingsInputs, result, availableListings);
        int minPrice = Integer.MAX_VALUE;
        List<ListingParent> bestResultingCombinationList = null;
        for (List<ListingParent> resultingCombinationList : result) {
            int tempPrice = 0;
            for (ListingParent listingParent : resultingCombinationList) {
                tempPrice += listingParent.getPrice_in_cents();
            }
            if (tempPrice < minPrice) {
                minPrice = tempPrice;
                bestResultingCombinationList = new ArrayList<>();
                bestResultingCombinationList.addAll(resultingCombinationList);
            }
        }
        return bestResultingCombinationList;
    }

    private void findBestCombination(int startIndex, List<SearchListingsInput> searchListingsInputs, List<List<ListingParent>> result, List<ListingParent> availableListings) {
        if (startIndex == searchListingsInputs.size()) {
            List<ListingParent> tempCombosList = new ArrayList<>();
            for (ListingParent listingParent : availableListings) {
                if (listingParent.isOccupied()) {
                    tempCombosList.add(listingParent);
                }
            }
            if(tempCombosList.size() > 0)
                result.add(tempCombosList);
            return;
        }
        for (int index = startIndex; index < searchListingsInputs.size(); index++) {
            Collections.swap(searchListingsInputs, startIndex, index);
            SearchListingsInput searchListing = searchListingsInputs.get(startIndex);
            for (int i = 0; i < availableListings.size(); i++) {
                ListingParent availableListing = availableListings.get(i);
                if (availableListing.getOrientation() == null) {
                    if (availableListing.getWidth() >= searchListing.getLength() && availableListing.getLength() >= BUS_WIDTH) {
                        ListingParent tempAvailableListingHorizontal = new ListingParent(HORIZONTAL, true);
                        tempAvailableListingHorizontal.setId(availableListing.getId());
                        tempAvailableListingHorizontal.setLocation_id(availableListing.getLocation_id());
                        tempAvailableListingHorizontal.setPrice_in_cents(availableListing.getPrice_in_cents());
                        tempAvailableListingHorizontal.setWidth(availableListing.getWidth());
                        tempAvailableListingHorizontal.setLength(availableListing.getLength() - BUS_WIDTH);
                        availableListings.set(i, tempAvailableListingHorizontal);
                        findBestCombination(startIndex + 1, searchListingsInputs, result, availableListings);
                        availableListings.set(i, availableListing);
                    }
                    if (availableListing.getLength() >= searchListing.getLength() && availableListing.getWidth() >= BUS_WIDTH) {
                        ListingParent tempAvailableListingVertical = new ListingParent(VERTICAL, true);
                        tempAvailableListingVertical.setId(availableListing.getId());
                        tempAvailableListingVertical.setLocation_id(availableListing.getLocation_id());
                        tempAvailableListingVertical.setPrice_in_cents(availableListing.getPrice_in_cents());
                        tempAvailableListingVertical.setLength(availableListing.getLength());
                        tempAvailableListingVertical.setWidth(availableListing.getWidth() - BUS_WIDTH);
                        availableListings.set(i, tempAvailableListingVertical);
                        findBestCombination(startIndex + 1, searchListingsInputs, result, availableListings);
                        availableListings.set(i, availableListing);
                    }
                }
                else if (availableListing.getOrientation().equals(HORIZONTAL)) {
                    if (availableListing.getWidth() >= searchListing.getLength() && availableListing.getLength() >= BUS_WIDTH) {
                        ListingParent tempAvailableListingHorizontal = new ListingParent(HORIZONTAL, true);
                        tempAvailableListingHorizontal.setId(availableListing.getId());
                        tempAvailableListingHorizontal.setLocation_id(availableListing.getLocation_id());
                        tempAvailableListingHorizontal.setPrice_in_cents(availableListing.getPrice_in_cents());
                        tempAvailableListingHorizontal.setWidth(availableListing.getWidth());
                        tempAvailableListingHorizontal.setLength(availableListing.getLength() - BUS_WIDTH);
                        availableListings.set(i, tempAvailableListingHorizontal);
                        findBestCombination(startIndex + 1, searchListingsInputs, result, availableListings);
                        availableListings.set(i, availableListing);
                    }
                }
                else if (availableListing.getOrientation().equals(VERTICAL)) {
                    if (availableListing.getLength() >= searchListing.getLength() && availableListing.getWidth() >= BUS_WIDTH) {
                        ListingParent tempAvailableListingVertical = new ListingParent(VERTICAL, true);
                        tempAvailableListingVertical.setId(availableListing.getId());
                        tempAvailableListingVertical.setLocation_id(availableListing.getLocation_id());
                        tempAvailableListingVertical.setPrice_in_cents(availableListing.getPrice_in_cents());
                        tempAvailableListingVertical.setLength(availableListing.getLength());
                        tempAvailableListingVertical.setWidth(availableListing.getWidth() - BUS_WIDTH);
                        availableListings.set(i, tempAvailableListingVertical);
                        findBestCombination(startIndex + 1, searchListingsInputs, result, availableListings);
                        availableListings.set(i, availableListing);
                    }
                }
            }
            Collections.swap(searchListingsInputs, startIndex, index);
        }
    }

}
