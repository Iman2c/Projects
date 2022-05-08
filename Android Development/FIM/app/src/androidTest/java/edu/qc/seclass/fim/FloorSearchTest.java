package edu.qc.seclass.fim;

import static com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed;
import static com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn;
import static com.adevinta.android.barista.interaction.BaristaEditTextInteractions.typeTo;

import androidx.test.core.app.ActivityScenario;

import org.junit.Test;

// Each test ensures that an input (case-insensitive) displays an expected result
// if there must be a result the error textView shouldn't appear and vice versa
// Type and sub category are checked
public class FloorSearchTest {
    @Test
    public void test_edit_button_displayed() {
        ActivityScenario activityScenario = ActivityScenario.launch(LoginIn.class);
        assertDisplayed(R.id.btnAdd);
    }

    @Test
    public void test_search_display() {
        ActivityScenario activityScenario = ActivityScenario.launch(LoginIn.class);

        clickOn(R.id.actionSearch);
        typeTo(R.id.actionSearch, "Wood");

        assertNotDisplayed(R.id.tvNoData);
    }

    @Test
    public void test_search_display2() {
        ActivityScenario activityScenario = ActivityScenario.launch(LoginIn.class);

        clickOn(R.id.actionSearch);
        typeTo(R.id.actionSearch, "Woo");

        assertNotDisplayed(R.id.tvNoData);
    }

    @Test
    public void test_search_display3() {
        ActivityScenario activityScenario = ActivityScenario.launch(LoginIn.class);

        clickOn(R.id.actionSearch);
        typeTo(R.id.actionSearch, "!@#");

        assertDisplayed(R.id.tvNoData);
    }

    @Test
    public void test_search_display4() {
        ActivityScenario activityScenario = ActivityScenario.launch(LoginIn.class);

        clickOn(R.id.actionSearch);
        typeTo(R.id.actionSearch, "1000");

        assertDisplayed(R.id.tvNoData);
    }

    @Test
    public void test_search_display5() {
        ActivityScenario activityScenario = ActivityScenario.launch(LoginIn.class);

        clickOn(R.id.actionSearch);
        typeTo(R.id.actionSearch, "Hunter");

        assertDisplayed(R.id.tvNoData);
    }

    @Test
    public void test_search_type1() {
        ActivityScenario activityScenario = ActivityScenario.launch(LoginIn.class);

        clickOn(R.id.actionSearch);
        typeTo(R.id.actionSearch, "laminate");

        assertNotDisplayed(R.id.tvNoData);
    }

    @Test
    public void test_search_type2() {
        ActivityScenario activityScenario = ActivityScenario.launch(LoginIn.class);

        clickOn(R.id.actionSearch);
        typeTo(R.id.actionSearch, "sol");

        assertNotDisplayed(R.id.tvNoData);
    }

    @Test
    public void test_search_type3() {
        ActivityScenario activityScenario = ActivityScenario.launch(LoginIn.class);

        clickOn(R.id.actionSearch);
        typeTo(R.id.actionSearch, "Enggineered");

        assertDisplayed(R.id.tvNoData);
    }

}
