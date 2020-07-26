/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.SimpleCalc

import android.test.suitebuilder.annotation.SmallTest
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4::class)
class CalculatorTest {
    private lateinit var mCalculator: Calculator
    /**
     * Set up the environment for testing
     */
    @Before
    fun setUp() {
        mCalculator = Calculator()
    }

    /**
     * Test for simple addition
     */
    @Test
    fun addTwoNumbers() {
        val resultAdd = mCalculator.add(1.0, 1.0)
        assertThat(resultAdd, `is`(equalTo(2.0)))
    }

    @Test
    fun addTwoNegativeNumbers() {
        val resultAdd = mCalculator.add(-111.0, -123.0)
        assertThat(resultAdd, `is`(equalTo(-234.0)))
    }

    @Test
    fun addTwoFloatingNumbers() {
        val resultAdd = mCalculator.add((1.0F).toDouble(), (3.0F).toDouble())
        assertThat(resultAdd, `is`(equalTo(4.0)))
    }

    @Test
    fun addTwoLargeNumbers() {
        val resultAdd = mCalculator.add(11111111.0, 22222222.0)
        assertThat(resultAdd, `is`(equalTo(33333333.0)))
    }

    @Test
    fun addTwoNumbersWithOneZero() {
        val resultAdd = mCalculator.add(0.0, 22222222.0)
        assertThat(resultAdd, `is`(equalTo(22222222.0)))
    }

    @Test
    fun addTwoNumbersWithOneInfintiy() {
        val resultAdd = mCalculator.add(Double.POSITIVE_INFINITY, 22222222.0)
        assertThat(resultAdd, `is`(equalTo(Double.POSITIVE_INFINITY)))
    }
}