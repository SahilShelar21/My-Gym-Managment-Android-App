package com.example.mygym;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddMemberActivity extends AppCompatActivity {

    private EditText nameEditText, paymentMethodEditText, amountEditText;
    private Spinner dishSpinner;
    private DataHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        nameEditText = findViewById(R.id.nameEditText);
        dishSpinner = findViewById(R.id.dishSpinner);
        paymentMethodEditText = findViewById(R.id.paymentMethodEditText);
        amountEditText = findViewById(R.id.amountEditText);

        // Initialize data helper
        dataHelper = new DataHelper(this);

        // Populate dishSpinner with available dishes (you can fetch this data from your database)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.packages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dishSpinner.setAdapter(adapter);

        Button orderButton = findViewById(R.id.orderButton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmOrder();
            }
        });
    }

    private void confirmOrder() {
        String name = nameEditText.getText().toString();
        String dish = dishSpinner.getSelectedItem().toString();
        String paymentMethod = paymentMethodEditText.getText().toString();
        String amountStr = amountEditText.getText().toString();

        if (name.isEmpty() || paymentMethod.isEmpty() || amountStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Store the order information in the database
        dataHelper.insertOrder(name, dish, paymentMethod, Double.parseDouble(amountStr));

        // Show a toast message confirming the order
        Toast.makeText(this, "Your Gym Membership is confirmed", Toast.LENGTH_SHORT).show();
    }
}
