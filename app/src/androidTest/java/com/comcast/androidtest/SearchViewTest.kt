package com.comcast.androidtest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.comcast.androidtest.ui.components.SearchField
import com.comcast.androidtest.ui.theme.AndroidTestTheme
import org.junit.Rule
import org.junit.Test

class SearchViewTest {
    private val searchField = "DOG"

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        composeTestRule.setContent {
            AndroidTestTheme {
                SearchField(searchValue = searchField, {}, {})
            }
        }
        composeTestRule.onNodeWithText(searchField).assertIsDisplayed()
    }
}