package com.example.lr_1_v_2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class ContentFragment extends Fragment
{

    public ContentFragment(){
        super(R.layout.fragment_content);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner1);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Authors, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Button button = (Button) view.findViewById((R.id.button1));
        button.setOnClickListener(this::sendMessage);
    }

    public void sendMessage(View view) {

        RadioGroup radiogrp = (RadioGroup) getView().findViewById(R.id.radioGroup);
        String Message = "None";
        if (radiogrp.getCheckedRadioButtonId() == -1)
        {
            Message = "Publication year is not chosen. Please, choose publication years.";
        }
        else
        {
            Spinner spinner = (Spinner) getView().findViewById(R.id.spinner1);
            RadioButton radioButton = (RadioButton) getView().findViewById(radiogrp.getCheckedRadioButtonId());
            Message = "Congratulations! You have chosen: " + spinner.getSelectedItem().toString() + " " + radioButton.getText();
        }

        TextFragment nextFr = (TextFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_container_view2);
        nextFr.changeText(Message);
    }

}
