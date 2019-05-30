package com.example.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.AppCompatCheckBox;
        import android.text.method.HideReturnsTransformationMethod;
        import android.text.method.PasswordTransformationMethod;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    EditText mTextEmail;
    RadioButton rd;
    private AppCompatCheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        mTextEmail = (EditText) findViewById(R.id.edittext_email);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextViewRegister = (TextView) findViewById(R.id.textview_register);
        mButtonLogin = (Button) findViewById(R.id.button_Login);
        checkBox=(AppCompatCheckBox) findViewById(R.id.checkbox);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (! isChecked){
                    mTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else {
                    mTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Email-Id", Toast.LENGTH_LONG).show();
                }
                if (mTextPassword.getText().toString().equals("")) {
                    mTextPassword.setError("Enter password");
                }
            }
        });
    }
}