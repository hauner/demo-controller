package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.annotation.RequestFilter
import io.micronaut.http.annotation.ServerFilter
import java.util.*

@ServerFilter(ServerFilter.MATCH_ALL_PATTERN)
class Filter {

    @RequestFilter
    fun filterRequest(request: HttpRequest<*>?) {
        var pid: String? = request!!.headers.get("a-request-attribute")
        if (pid == null) {
            pid = UUID.randomUUID().toString()
        }

        request.setAttribute("a-request-attribute", pid)
    }
}
