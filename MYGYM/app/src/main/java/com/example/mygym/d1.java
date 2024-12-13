package com.example.mygym;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class d1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d1);

        Button addMemberButton = findViewById(R.id.addMemberButton);
        addMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open AddMemberActivity when the "Add Member" button is clicked
                Intent intent = new Intent(d1.this, AddMemberActivity.class);
                startActivity(intent);
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button addStaffButton = findViewById(R.id.addStaffButton);
        addStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open AddMemberActivity when the "Add Member" button is clicked
                Intent intent = new Intent(d1.this, AddStaffActivity.class);
                startActivity(intent);
            }
        });
    }
    // This method will be called when the "Add Member" button is clicked
    public void onAddMemberClick(View view) {
        // Open AddMemberActivity when the "Add Member" button is clicked
        Intent intent = new Intent(this, AddMemberActivity.class);
        startActivity(intent);
    }
    public void onAddStaffClick(View view) {
        // Open AddMemberActivity when the "Add Member" button is clicked
        Intent intent = new Intent(this, AddStaffActivity.class);
        startActivity(intent);
    }

}
