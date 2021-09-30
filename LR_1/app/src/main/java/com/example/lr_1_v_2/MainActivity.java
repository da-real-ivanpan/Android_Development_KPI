package com.example.lr_1_v_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Authors, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    public void sendMessage(View view) {
        // Do something in response to button click
        RadioGroup radiogrp = (RadioGroup) findViewById(R.id.radioGroup);
        builder = new AlertDialog.Builder(this);
        String Title = "None";
        String Message = "None";
        if (radiogrp.getCheckedRadioButtonId() == -1)
        {

            Title = "Publication year is not chosen";
            Message = "Please, choose publication years.";
        }
        else
        {
            Spinner spinner = (Spinner)findViewById(R.id.spinner1);
            RadioButton radioButton = (RadioButton) findViewById(radiogrp.getCheckedRadioButtonId());
            Title = "Congratulations!";
            Message = "You have chosen: " + spinner.getSelectedItem().toString() + " " + radioButton.getText();
        }
        //Uncomment the below code to Set the message and title from the strings.xml file
        builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage(Message)
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),"Returning to main menu...",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(Title);
        alert.show();
    }

}