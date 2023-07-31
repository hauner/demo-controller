package com.example;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;

public interface Api {

    @Get(uri = "/broken/foo", produces = {"text/plain"})
    String foo(@QueryValue(value = "query") String query);

    @Post(uri = "/broken/bar", produces = {"text/plain"})
    String bar(@QueryValue(value = "query") String query/*, @RequestAttribute("a-request-attribute") String attribute*/);
}
