package com.example.mygym;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddStaffActivity extends AppCompatActivity {

    private EditText staffEditText, addressEditText, salaryEditText;
    private Spinner postSpinner;
    private DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);

        staffEditText = findViewById(R.id.nameStaff);
        postSpinner = findViewById(R.id.postSpinner);
        addressEditText = findViewById(R.id.address);
        salaryEditText = findViewById(R.id.salary);

        // Initialize data helper
        databaseHelper = new DatabaseHelper(this);

        // Populate dishSpinner with available dishes (you can fetch this data from your database)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.post_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        postSpinner.setAdapter(adapter);

        Button BookButton = findViewById(R.id.BookButton);
        BookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmBook();
            }

        });
    }

    private void confirmBook() {
        String name = staffEditText.getText().toString();
        String dish = postSpinner.getSelectedItem().toString();
        String paymentMethod = addressEditText.getText().toString();
        String amountStr = salaryEditText.getText().toString();

        if (name.isEmpty() || paymentMethod.isEmpty() || amountStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Store the order information in the database
        databaseHelper.insertOrder(name, dish, paymentMethod, Double.parseDouble(amountStr));

        // Show a toast message confirming the order
        Toast.makeText(this, "Your new Trainer is added", Toast.LENGTH_SHORT).show();
    }
}
