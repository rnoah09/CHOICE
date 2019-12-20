package com.example.choice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IntroductionFragment extends Fragment {

    private Button buttonSelect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_intro, container, false);
        wireWidgets(rootView);

        setListeners();

        return rootView;
    }
    public void wireWidgets(View rootView){
        buttonSelect = rootView.findViewById(R.id.button_select_intro);
    }
    public void setListeners(){
        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
