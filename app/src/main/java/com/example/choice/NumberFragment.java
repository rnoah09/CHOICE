package com.example.choice;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment {

    private TextView textViewNumber;
    private EditText editTextMin;
    private EditText editTextMax;
    private Button buttonGenerate;
    private Button buttonD4;
    private Button buttonD6;
    private Button buttonD10;
    private Button buttonD20;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_numgen, container, false);
        wireWidgets(rootView);
        setListeners();

        return rootView;
    }
    public void setListeners(){
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(editTextMin.getText()) && !TextUtils.isEmpty(editTextMax.getText())){
                    int max = Integer.parseInt(editTextMax.getText().toString());
                    int min = Integer.parseInt(editTextMin.getText().toString());

                    if(min < max){
                        int randomNumber = (int)((Math.random() * ((max - min) + 1)) + min);
                        textViewNumber.setText("Your Number: " + randomNumber);
                    }
                    else{
                        Toast.makeText(getContext(), "Please enter the values on the correct side", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getContext(), "Please enter two integer values", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = (int)((Math.random() * ((4 - 1) + 1)) + 1);
                textViewNumber.setText("Your Number: " + randomNumber);
            }
        });
        buttonD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = (int)((Math.random() * ((6 - 1) + 1)) + 1);
                textViewNumber.setText("Your Number: " + randomNumber);
            }
        });
        buttonD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = (int)((Math.random() * ((10 - 1) + 1)) + 1);
                textViewNumber.setText("Your Number: " + randomNumber);
            }
        });
        buttonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = (int)((Math.random() * ((20 - 1) + 1)) + 1);
                textViewNumber.setText("Your Number: " + randomNumber);
            }
        });
    }
    public void wireWidgets(View rootView){
        textViewNumber = rootView.findViewById(R.id.textview_numgen_num);
        editTextMin = rootView.findViewById(R.id.edittext_numgen_min);
        editTextMax = rootView.findViewById(R.id.edittext_numgen_max);
        buttonGenerate = rootView.findViewById(R.id.button_numgen_gen);
        buttonD4 = rootView.findViewById(R.id.button_numgen_d4);
        buttonD6 = rootView.findViewById(R.id.button_numgen_d6);
        buttonD10 = rootView.findViewById(R.id.button_numgen_d10);
        buttonD20 =rootView.findViewById(R.id.button_numgen_d20);
    }
}
