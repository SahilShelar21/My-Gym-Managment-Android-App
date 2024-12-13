package com.example.mygym;
import static com.example.mygym.R.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    private CardView d1, d2, d3, d4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);

        d1 = (CardView) findViewById(id.HOMEE);
        d2 = (CardView) findViewById(id.dietnutrition);
        d3 = (CardView) findViewById(id.workout);
        d4 = (CardView) findViewById(id.aboutus);

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(HomeActivity.this, AdminloginActivity.class);
                startActivity(int1);
            }
        });
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(HomeActivity.this, d2.class);
                startActivity(int2);
            }
        });
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(HomeActivity.this, d3.class);
                startActivity(int3);
            }
        });
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(HomeActivity.this, d4.class);
                startActivity(int4);
            }
        });
    }
}

