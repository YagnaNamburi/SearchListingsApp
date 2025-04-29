package org.searchListings.models;

public class ListingParent extends Listing{
    private String orientation;
    private boolean isOccupied;

    public ListingParent(String orientation, boolean isOccupied) {
        this.orientation = orientation;
        this.isOccupied = isOccupied;
    }

    public ListingParent(String id, String location_id, int length, int width, int price_in_cents, String orientation, boolean isOccupied) {
        super(id, location_id, length, width, price_in_cents);
        this.orientation = orientation;
        this.isOccupied = isOccupied;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
