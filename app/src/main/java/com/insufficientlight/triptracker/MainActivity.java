package com.insufficientlight.triptracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    //Making some Variables
    EditText emailEditText;
    EditText passwordEditText;
    EditText nameEditText;
    Button loginButton;
    Button signUpButton;
    TextView signUpView;
    String newString = "It does.";
    String APP_ID;
    String API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting some Variables
        emailEditText = findViewById(R.id.enter_email);
        passwordEditText = findViewById(R.id.enter_password);
        nameEditText = findViewById(R.id.enter_name);
        loginButton = findViewById(R.id.login_button);
        signUpButton = findViewById(R.id.sign_up_button);
        signUpView = findViewById(R.id.textView);
        signUpView.setText("Sign up");
        String APP_ID = getString(R.string.APP_ID);
        String API_KEY = getString(R.string.API_KEY);

        Backendless.initApp( this,
                getString(R.string.be_app_id),
                getString(R.string.be_android_api_key));


        //Signup/Cancel code
        signUpView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (signUpView.getText().equals("Sign up"))
                {
                    loginButton.setVisibility(View.GONE);
                    nameEditText.setVisibility(View.VISIBLE);
                    signUpButton.setVisibility(View.VISIBLE);
                    signUpView.setText("Cancel");
                }
                else
                {
                    loginButton.setVisibility(View.VISIBLE);
                    nameEditText.setVisibility(View.GONE);
                    signUpButton.setVisibility(View.GONE);
                    signUpView.setText("Sign up");
                }
            }
        });
    }
}
