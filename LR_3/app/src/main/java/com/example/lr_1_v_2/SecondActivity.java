package com.example.lr_1_v_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private StringBuilder text = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = (Button) findViewById((R.id.backbutton));
        button.setOnClickListener(this::ChangeActivity);

        try (BufferedReader reader = new BufferedReader(new FileReader(this.getFilesDir() + "Result.txt"));) {
            String line = reader.readLine();
            if (line == null) {
                Toast.makeText(this, "File is empty", Toast.LENGTH_SHORT);
                TextView output = (TextView) findViewById(R.id.textView_File);
                output.setText("File is empty");
            } else {
                StringBuilder res = new StringBuilder();
                res.append(line);
                res.append("\n");
                while ((line = reader.readLine()) != null) {
                    res.append(line);
                    res.append("\n");
                }
                TextView output = (TextView) findViewById(R.id.textView_File);
                output.setText(res.toString());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void ChangeActivity(View view) {
        finish();
    }

}