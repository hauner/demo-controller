package com.example

import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.annotation.RequestAttribute
import io.micronaut.http.client.annotation.Client

@Client("/broken")
interface BrokenClient {

    @Post(uri = "/bar", consumes = ["text/plain"])
    fun bar(
        @QueryValue(value = "query") query: String,
        @RequestAttribute("a-request-attribute") attribute: String
    ): String
}