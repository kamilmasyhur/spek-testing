package com.ahmadkamilalmasyhur.spek_testing

import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

@RunWith(JUnitPlatform::class)
internal class PresenterTest: Spek({
    println("first line spek")

    beforeGroup {
        println("before group outside feature")
    }

    beforeEachGroup {
        println("before each group outside feature")
    }

    beforeEachTest {
        println("before each test outside feature")
    }

    lateinit var lateinitValue: String
    val realValue = "real value"
    val lazyValue by lazy {
        "lazy value"
    }
//    val value: MutableSet<String> by memoized {
//        println("value inside memoized")
//        mutableSetOf<String>()
//    }

    Feature("feature") {
        lateinit var lateinitValueInsideFeature: String
        val otherValue: MutableSet<String> by memoized {
            println("other value inside memoized")
            mutableSetOf<String>()
        }

        println("first line inside feature")

        beforeEachTest {
            println("before each test inside feature")
        }

        beforeFeature {
            println("before feature inside feature")
        }

        beforeEachScenario {
            println("before each scenario inside feature")
        }

        Scenario("A") {
            val anotherValue: MutableSet<String> by memoized {
                println("another value inside memoized")
                mutableSetOf<String>()
            }

            println("first line inside scenario A")

            beforeEachStep {
                println("before each step A")
            }

            beforeEachGroup {
                println("before each group A")
            }

            beforeScenario {
                println("before scenario A")
            }

            Given("Foo") {
                lateinitValue = "lateinit value"
                lateinitValueInsideFeature = "lateinit value inside feature"
//                value.add("value")
                otherValue.add("other value")
                anotherValue.add("another value")
                println("given A")
                println(realValue)
                println(lazyValue)
//                println(value)
                println(otherValue)
                println(anotherValue)
            }

            When("Zoo") {
                println("when A")
                println(realValue)
                println(lazyValue)
//                println(value)
                println(otherValue)
                println(anotherValue)
            }

            Then("Bar") {
                println("then A")
                println(realValue)
                println(lazyValue)
//                println(value)
                println(otherValue)
                println(anotherValue)
//                assertTrue(value.contains("value"))
                assertTrue(otherValue.contains("other value"))
                assertTrue(anotherValue.contains("another value"))
                assertTrue(lateinitValue == "lateinit value")
                assertTrue(lateinitValueInsideFeature == "lateinit value inside feature")
            }

            afterEachStep {
                println("after each step A")
            }

            afterScenario {
                println("after scenario A")
            }

            afterEachGroup {
                println("after each group A")
            }

            println("last line inside scenario A")
        }

        Scenario("B") {
            println("first line inside scenario B")

            lateinit var lateinitValueInsideScenario: String
            val anotherValue: MutableSet<String> by memoized {
                println("another value inside memoized")
                mutableSetOf<String>()
            }

            beforeEachStep {
                println("before each step B")
            }

            beforeEachGroup {
                println("before each group B")
            }

            beforeScenario {
                println("before scenario B")
            }

            Given("Foo") {
                lateinitValue = "lateinit value"
                lateinitValueInsideScenario = "lateinit value inside scenario"
//                value.add("value")
                otherValue.add("other value")
                anotherValue.add("another value")
                println("given B")
//                println(value)
                println(otherValue)
                println(anotherValue)
            }

            When("Zoo") {
                println("when B")
//                println(value)
                println(otherValue)
                println(anotherValue)
            }

            Then("Bar") {
                println("then B")
//                println(value)
                println(otherValue)
                println(anotherValue)
//                assertTrue(value.contains("value"))
                assertTrue(otherValue.contains("other value"))
                assertNotNull(anotherValue)
                assertTrue(lateinitValue == "lateinit value")
                assertTrue(lateinitValueInsideScenario == "lateinit value inside scenario")
            }

            afterEachStep {
                println("after each step B")
            }

            afterScenario {
                println("after scenario B")
            }

            afterEachGroup {
                println("after each group B")
            }

            println("last line inside scenario B")
        }

        afterEachTest {
            println("after each test inside feature")
        }

        afterEachScenario {
            println("after each scenario inside feature")
        }

        afterFeature {
            println("after feature inside feature")
        }

        println("last line inside feature")
    }

    afterEachTest {
        println("after each test outside feature")
    }

    afterEachGroup {
        println("after each group outside feature")
    }

    afterGroup {
        println("after group outside feature")
    }

    println("last line in spek")
})
