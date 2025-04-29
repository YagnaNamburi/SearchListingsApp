package org.searchListings.models;

import java.util.Objects;

public class SearchListingsInput {
    private int length;
    private int quantity;

    public SearchListingsInput() {
    }

    public SearchListingsInput(int length, int quantity) {
        this.length = length;
        this.quantity = quantity;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "searchListingInput{" +
                "length=" + length +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchListingsInput that = (SearchListingsInput) o;
        return length == that.length && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, quantity);
    }
}
