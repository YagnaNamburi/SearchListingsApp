package org.searchListings.models;

public class Listing {
    private String id;
    private String location_id;
    private int length;
    private int width;
    private int price_in_cents;

    public Listing() {
    }

    public Listing(String id, String location_id, int length, int width, int price_in_cents) {
        this.id = id;
        this.location_id = location_id;
        this.length = length;
        this.width = width;
        this.price_in_cents = price_in_cents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPrice_in_cents() {
        return price_in_cents;
    }

    public void setPrice_in_cents(int price_in_cents) {
        this.price_in_cents = price_in_cents;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id='" + id + '\'' +
                ", location_id='" + location_id + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", price_in_cents=" + price_in_cents +
                '}';
    }
}
