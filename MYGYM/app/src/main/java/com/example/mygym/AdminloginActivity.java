package com.example.mygym;

// src/your_package_name/AdminLoginActivity.java

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AdminloginActivity extends AppCompatActivity {

    private static final String FIXED_ADMIN_ID = "admin";
    private static final String FIXED_ADMIN_PASSWORD = "admin123";

    private EditText editTextId;
    private EditText editTextPassword;
    private Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        editTextId = findViewById(R.id.adminUsername);
        editTextPassword = findViewById(R.id.adminPassword);
        btnLogin = findViewById(R.id.adminlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the entered ID and password match the fixed values
                String enteredId = editTextId.getText().toString();
                String enteredPassword = editTextPassword.getText().toString();

                if (enteredId.equals(FIXED_ADMIN_ID) && enteredPassword.equals(FIXED_ADMIN_PASSWORD)) {
                    // If the credentials are correct, open the next activity (replace NextActivity.class with your desired activity)
                    Intent intent = new Intent(AdminloginActivity.this, d1.class);
                    startActivity(intent);
                } else {
                    // Display an error message for incorrect credentials
                    // You can handle this in a more user-friendly way in a real application
                    editTextId.setError("Invalid ID or password");
                    editTextPassword.setError("Invalid ID or password");
                }
            }
        });
    }
}
