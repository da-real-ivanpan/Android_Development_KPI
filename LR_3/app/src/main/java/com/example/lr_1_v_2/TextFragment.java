package com.example.lr_1_v_2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TextFragment extends Fragment {

    public TextFragment(){
        super(R.layout.fragment_text);
    }

    TextView textView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        textView= (TextView) view.findViewById(R.id.textView1);
    }

    public void changeText(String x)
    {
        textView.setText(x);
    }

}
