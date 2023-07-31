package com.example

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest

@MicronautTest
class BrokenClientTest(
    sut: BrokenClient
) : BehaviorSpec({

    Given("BrokenClient") {
        When("sending POST request to /bar with query and attribute") {
            val response = sut.bar("~query~", "~attribute~")

            Then("response should be as expected") {
                response.shouldBe("~query~")
            }
        }
    }
})
