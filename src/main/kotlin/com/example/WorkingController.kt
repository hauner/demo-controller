package com.example

import io.micronaut.http.annotation.*

@Controller
class WorkingController {

    @Get(uri = "/working/foo", produces = ["text/plain"])
    fun foo(@QueryValue(value = "query") query: String): String {
        return query
    }

    @Post(uri = "/working/bar", produces = ["text/plain"])
    fun bar(@QueryValue(value = "query") query: String, @RequestAttribute("a-request-attribute") attribute: String): String {
        return "$query with attribute $attribute"
    }
}
