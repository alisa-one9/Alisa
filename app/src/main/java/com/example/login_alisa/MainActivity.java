package com.example.login_alisa;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegistr;

    private View.OnClickListener mOnEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isLoginEmpty() && isPasswordValid()) {
                //переход в приложение
            } else {
                showMessage(R.string.login_input_error);

            }

        }
    };

    private View.OnClickListener mOnRegistrClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) { // todo

        }
    };

    private boolean isLoginEmpty() {
        return !TextUtils.isEmpty(mLogin.getText())
                && Patterns.EMAIL_ADDRESS.matcher(
                mLogin.getText()).matches();

    }

    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(mLogin.getText());

    }

    private void showMessage(@StringRes int string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLogin = findViewById(R.id.etLogin);
        mPassword = findViewById(R.id.etPassword);
        mEnter = findViewById(R.id.buttonLogin);
        mRegistr = findViewById(R.id.buttonRegistr);

        mEnter.setOnClickListener(mOnEnterClickListener);
        mRegistr.setOnClickListener(mOnRegistrClickListener);
    }
}