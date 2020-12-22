package com.example.codechallenge21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static Button submit;
    public static EditText email, phone;
    public static CheckBox accept;

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.button);
        email = findViewById(R.id.edittext1);
        phone = findViewById(R.id.edittext2);
        accept = findViewById(R.id.checkbox);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(! isEmailValid(email.getText().toString()))
                {
                    email.setError("Fill the input with a valid email address");
                    email.getBackground().setColorFilter(getResources().getColor(R.color.teal_700, getTheme()), PorterDuff.Mode.SRC_ATOP);
                }
                else if (!accept.isChecked())
                {
                    accept.setError("You need to accept T&C");
                }
                else
                {
                    submit.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Login Successful",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}