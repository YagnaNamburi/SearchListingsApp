package org.searchListings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchListingsApp {
    public static void main(String[] args) {
        SpringApplication.run(SearchListingsApp.class, args);
        System.out.println("Hello world!");
    }
}