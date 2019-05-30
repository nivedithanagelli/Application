package com.example.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextcnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;
    EditText mTextEmail;
    EditText Address;
    EditText MobileNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mTextcnfPassword = (EditText) findViewById(R.id.edittext_cnfpassword);
        mTextEmail = (EditText) findViewById(R.id.edittext_email);
        Address=(EditText)findViewById(R.id.input_address);
        MobileNumber=(EditText) findViewById(R.id.input_mobile);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(LoginIntent);
            }
        });
        if (mTextUsername.getText().toString().equals("")) {
            mTextUsername.setError("Enter valid username");
        }
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";

                String email = mTextEmail.getText().toString();
                Matcher matcher = Pattern.compile(validemail).matcher(email);
                if (matcher.matches()) {
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Email-Id", Toast.LENGTH_LONG).show();
                }
                if (mTextPassword.getText().toString().equals("")) {
                    mTextPassword.setError("Enter valid password");
                }
            }
        });
    }
}
