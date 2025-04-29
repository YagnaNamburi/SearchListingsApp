package org.searchListings.models;

import java.util.List;
import java.util.Objects;

public class SearchListingsOutput {
    private String location_id;
    private List<String> listing_ids;
    private int total_price_in_cents ;

    public SearchListingsOutput() {
    }

    public SearchListingsOutput(String location_id, List<String> listing_ids, int total_price_in_cents) {
        this.location_id = location_id;
        this.listing_ids = listing_ids;
        this.total_price_in_cents = total_price_in_cents;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public List<String> getListing_ids() {
        return listing_ids;
    }

    public void setListing_ids(List<String> listing_ids) {
        this.listing_ids = listing_ids;
    }

    public int getTotal_price_in_cents() {
        return total_price_in_cents;
    }

    public void setTotal_price_in_cents(int total_price_in_cents) {
        this.total_price_in_cents = total_price_in_cents;
    }

    @Override
    public String toString() {
        return "SearchListingsOutput{" +
                "location_id='" + location_id + '\'' +
                ", listing_ids=" + listing_ids +
                ", total_price_in_cents=" + total_price_in_cents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchListingsOutput that = (SearchListingsOutput) o;
        return total_price_in_cents == that.total_price_in_cents && Objects.equals(location_id, that.location_id) && Objects.equals(listing_ids, that.listing_ids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location_id, listing_ids, total_price_in_cents);
    }
}
