package edu.qc.seclass.fim;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    Button signIn;
    Button signUp;
    EditText user, pw;
    TextView tvError;
    String emailRegex = Patterns.EMAIL_ADDRESS.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pw = findViewById(R.id.etPassword);
        tvError = findViewById(R.id.tvError);

        //Do if "Sign In" is pressed
        signIn = findViewById(R.id.btnSignIn);

        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText username = findViewById(R.id.etEmail);
                EditText password = findViewById(R.id.etPassword);

                //Logging in
                ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), (user, e) -> {
                    if(user != null){
                        Toast.makeText(MainActivity.this, "Successful Login", Toast.LENGTH_LONG).show();
                        findViewById(R.id.tvError).setVisibility(View.INVISIBLE);

                        //Now we need to check if user is an employee or not
                        boolean employeeStatus = Boolean.valueOf(ParseUser.getCurrentUser().getBoolean("isEmployee"));
                        if(employeeStatus){
                            Intent intent = new Intent(MainActivity.this, LoginIn.class);
                            startActivity(intent);
                        }
                        else{
                            Intent intent = new Intent(MainActivity.this, LoginIn.class);
                            startActivity(intent);
                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        tvError.setText(e.getMessage() + " User is case sensitive", TextView.BufferType.EDITABLE);
                        findViewById(R.id.tvError).setVisibility(View.VISIBLE);

                    }
                });

                /**
                 //else if user isEmployee set to true, give LoginIn Employee access
                 if(isEmployee) {
                 Intent intent = new Intent(MainActivity.this, LoginIn.class);
                 startActivity(intent);
                 }

                 //else if user isEmployee set to false, give LoginCustomer access
                 else {
                 Intent intent = new Intent(MainActivity.this, LoginCustomer.class);
                 startActivity(intent);
                 }
                 **/
            }
        });

        //Do if "Sign Up" is pressed
        signUp = findViewById(R.id.btnSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.etEmail);
                EditText password = findViewById(R.id.etPassword);

                if(username.getText().toString().matches(emailRegex)) {
                    if(password.getText().toString().length() < 5){
                        Toast.makeText(MainActivity.this, R.string.error_short_pw, Toast.LENGTH_SHORT).show();
                        tvError.setText(R.string.error_short_pw, TextView.BufferType.EDITABLE);
                        findViewById(R.id.tvError).setVisibility(View.VISIBLE);
                    }

                    // Valid user and valid password -> Add the account to the database
                    else {
                        ParseUser user = new ParseUser();
                        user.setUsername(username.getText().toString());
                        user.setPassword(password.getText().toString());

                        user.signUpInBackground(e -> {
                            if (e == null) {
                                findViewById(R.id.tvError).setVisibility(View.INVISIBLE);
                                Toast.makeText(MainActivity.this, "Account creation successful", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                tvError.setText(e.getMessage(), TextView.BufferType.EDITABLE);
                                findViewById(R.id.tvError).setVisibility(View.VISIBLE);
                            }
                        });
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.error_not_email_format, Toast.LENGTH_SHORT).show();
                    tvError.setText(R.string.error_not_email_format, TextView.BufferType.EDITABLE);
                    findViewById(R.id.tvError).setVisibility(View.VISIBLE);
                }
            }
        });
    }

}