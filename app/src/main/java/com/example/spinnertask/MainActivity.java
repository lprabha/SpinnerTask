package com.example.spinnertask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editName,editEmail,editPhone;
    Spinner spinner;
    Button Submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinnerAddress);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.address,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        viewValue();

        Submit.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name, phone, email, address;
                name = editName.getText().toString();
                phone = editPhone.getText().toString();
                email = editEmail.getText().toString();
                address = spinner.getSelectedItem().toString();

                Intent intentForm = new Intent(MainActivity.this, SpinnerDisplay.class);
                intentForm.putExtra("forName", name);
                intentForm.putExtra("forPhone", phone);
                intentForm.putExtra("forEmail",email);
                intentForm.putExtra("forAddress",address);

                startActivity(intentForm);

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void viewValue() {
        editName = findViewById(R.id.enterName);
        editPhone = findViewById(R.id.phoneNo);
        editEmail = findViewById(R.id.Email);
        spinner = findViewById(R.id.spinnerAddress);
        Submit= findViewById(R.id.buttonSubmit);
    }
}
