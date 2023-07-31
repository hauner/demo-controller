package com.example

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest

@MicronautTest
class BrokenControllerTest(
    @Client("/") client: HttpClient,
) : BehaviorSpec({

    Given("BrokenController") {

        forAll(
            row(HttpRequest.GET("/broken/inside?query=inside-foo"), "inside-foo"),
            row(HttpRequest.GET<Any>("/broken/foo?query=foo"), "foo"),
            row(HttpRequest.POST("/broken/bar?query=bar", null), "bar")
        ) { httpRequest, expectedBody ->
            When("requesting $httpRequest") {
                val httpResponse = client.toBlocking().exchange(
                    httpRequest,
                    String::class.java
                )

                Then("response status should be as expected") {
                    assertSoftly(httpResponse) {
                        status shouldBe HttpStatus.OK
                        body.get() shouldBe expectedBody
                    }
                }
            }
        }
    }
})
