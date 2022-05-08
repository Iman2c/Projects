package edu.qc.seclass.fim;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.adevinta.android.barista.interaction.BaristaKeyboardInteractions.closeKeyboard;
import static com.adevinta.android.barista.interaction.BaristaSleepInteractions.sleep;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.not;

import android.util.Patterns;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;

import com.adevinta.android.barista.rule.flaky.AllowFlaky;

import org.junit.Test;


public class CustomerLoginTest {
    // Should cover all cases where a bad sign-in and a bad sign-up occurs
    @Test
    @AllowFlaky(attempts = 3)
    public void test_signin_login_bad_credentials() {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        //Bad username sign up
        onView(withId(R.id.etEmail))
                .perform(click(), typeText("hello!"));

        closeKeyboard();

        onView(withId(R.id.btnSignUp))
                .perform(click());

        onView(withId(R.id.etEmail))
                .check(
                        matches(not(withText(matchesRegex(Patterns.EMAIL_ADDRESS.toString())))));

        onView(withId(R.id.tvError))
                .check(
                        matches(withText(R.string.error_not_email_format)));

        // Valid user, Bad password (length too short)
        onView(withId(R.id.etEmail))
                .perform(clearText());

        onView(withId(R.id.etEmail))
                .perform(click(), typeText("bobtheturtle@gmail.com"));

        onView(withId(R.id.etPassword))
                .perform(click(), typeText("abc"));

        closeKeyboard();

        onView(withId(R.id.btnSignUp))
                .perform(click());

        onView(withId(R.id.tvError))
                .check(matches(withText(R.string.error_short_pw)));

        // Signup using existing account
        onView(withId(R.id.etEmail))
                .perform(clearText());

        onView(withId(R.id.etEmail))
                .perform(click(), typeText("testaccount1@gmail.com"));

        onView(withId(R.id.etPassword))
                .perform(click(), typeText("abc"));

        closeKeyboard();

        onView(withId(R.id.btnSignUp))
                .perform(click());

        sleep(1500);

        onView(withId(R.id.tvError))
                .check(matches(withText(R.string.error_signup_existing_account)));

        //Login invalid credentials
        onView(withId(R.id.btnSignIn))
                .perform(click());

        onView(withId(R.id.tvError))
            .check(matches(withText(containsString("Invalid"))));

        //Bad credentials sign in
        onView(withId(R.id.etEmail))
                .perform(clearText());

        onView(withId(R.id.btnSignIn))
                .perform(click());

        onView(withId(R.id.tvError))
                .check(matches(withText(containsString("is required"))));
    }

    //Test for a Valid login. The user should be able to see the database from the next activity
    @Test
    public void test_login_to_customer(){
        Intents.init();
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.etEmail))
                .perform(click(), typeText("testAccount1@gmail.com"));

        onView(withId(R.id.etEmail))
                .check(
                        matches(withText(matchesRegex(Patterns.EMAIL_ADDRESS.toString()))));

        onView(withId(R.id.etPassword))
                .perform(click(), typeText("abc123!@#"));

        onView(withId(R.id.btnSignIn))
                .perform(click());

        onView(withId(R.id.tvError))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        // Considers navigation delay. Without it, the test would fail
        sleep(1500);
        intended(hasComponent(LoginIn.class.getName()));
        Intents.release();

    }

    // Because the user is a customer, the user should stay in the same activity
    // Only the employee should be allowed to reach the next activity
    @Test
    @AllowFlaky(attempts = 3)
    public void test_customer_cant_add(){
        Intents.init();
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.etEmail))
                .perform(click(), typeText("testAccount1@gmail.com"));

        onView(withId(R.id.etPassword))
                .perform(click(), typeText("abc123!@#"));

        closeKeyboard();

        onView(withId(R.id.btnSignIn))
                .perform(click());

        sleep(1500);

        onView(withId(R.id.btnAdd))
                .perform(click());

        intended(hasComponent(LoginIn.class.getName()));
        Intents.release();

    }


}
