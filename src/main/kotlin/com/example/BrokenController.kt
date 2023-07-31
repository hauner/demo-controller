package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller
class BrokenController: Api {

    @Get(uri = "/broken/inside", produces = ["text/plain"])
    fun insideFoo(@QueryValue(value = "query") query: String): String {
        return query
    }

    override fun foo(query: String): String {
        return query
    }

    override fun bar(query: String, attribute: String): String {
        return "$query with attribute $attribute"
    }
}
