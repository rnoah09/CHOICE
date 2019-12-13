package com.example.choice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UsernameFragment extends Fragment {

    private TextView textViewAdj;
    private TextView textViewNoun;
    private EditText editTextAdj;
    private EditText editTextNoun;
    private Button buttonGenerate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_username, container, false);
        wireWidgets(rootView);
        setListeners();

        return rootView;
    }

    public void wireWidgets(View rootView){
        textViewAdj = rootView.findViewById(R.id.textview_username_adj);
        textViewNoun = rootView.findViewById(R.id.textview_username_noun);
        editTextAdj = rootView.findViewById(R.id.edittext_username_adj);
        editTextNoun = rootView.findViewById(R.id.edittext_username_noun);
        buttonGenerate = rootView.findViewById(R.id.button_username_generate);
    }
    public void setListeners(){

    }
}
