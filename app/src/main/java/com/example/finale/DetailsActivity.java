package com.example.finale;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

// DetailsActivity.java
public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView tvDetails = findViewById(R.id.tvDetails);
        MaterialButton btnBack = findViewById(R.id.btnBack);

        // Get bundle data
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String type = bundle.getString("type");
            StringBuilder details = new StringBuilder();

            if (type.equals("login")) {
                details.append("Login Details:\n\n");
                details.append("Email: ").append(bundle.getString("email")).append("\n");
                details.append("Password: ").append(bundle.getString("password"));
            } else {
                details.append("Sign Up Details:\n\n");
                details.append("Full Name: ").append(bundle.getString("fullName")).append("\n");
                details.append("Email: ").append(bundle.getString("email")).append("\n");
                details.append("Password: ").append(bundle.getString("password"));
            }

            tvDetails.setText(details.toString());
        }

        // Back button click
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}