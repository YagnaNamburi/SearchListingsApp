package org.searchListings.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
public class SearchListingsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchListingsResource.class);
    @GetMapping("/testPath")
    public String testApi(@RequestParam String name){
        LOGGER.info("This is the request param : "+name);
        return "Hello "+name;
    }
}
