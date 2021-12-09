package com.example.lr_1_v_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_view, ContentFragment.class, null)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_view2, TextFragment.class, null)
                    .commit();
        }
        Button button = (Button) findViewById((R.id.nextbutton));
        button.setOnClickListener(this::changeActivity);
        Button button2 = (Button) findViewById(((R.id.clearbutton)));
        button2.setOnClickListener(this::clearText);
    }

    private void changeActivity(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }
    public void clearText(View view){
        BufferedWriter writer = null;
        try {
            new FileOutputStream(this.getFilesDir() + "Result.txt").close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}