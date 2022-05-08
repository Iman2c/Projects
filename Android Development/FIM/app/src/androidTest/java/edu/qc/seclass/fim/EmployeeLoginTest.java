package edu.qc.seclass.fim;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Test;

public class EmployeeLoginTest {

    @Test
    public void test_login_to_employee(){
        Intents.init();
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.etEmail))
                .perform(click(), typeText("testAccount2@gmail.com"));

        onView(withId(R.id.etPassword))
                .perform(click(), typeText("admin123"));

        onView(withId(R.id.btnSignIn))
                .perform(click());

        onView(withId(R.id.tvError))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        // Considers navigation delay. Without it, the test would fail
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        intended(hasComponent(LoginIn.class.getName()));

        onView(withId(R.id.btnAdd))
                .perform(click());

        intended(hasComponent(AddEdit.class.getName()));

        Intents.release();

    }
}
