package com.example.choice;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class ChoiceFragment extends Fragment {

    private EditText editTextChoice;
    private Button buttonAdd;
    private ChipGroup chipGroupChoices;
    private Button buttonChoose;
    private Button buttonReset;
    private Chip chip;
    private int chipNumber = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_choice, container, false);
        wireWidgets(rootView);

        setListeners();

        return rootView;
    }

    public void wireWidgets(View rootView){
        editTextChoice = rootView.findViewById(R.id.edittext_choice_choice);
        buttonAdd = rootView.findViewById(R.id.button_choice_add);
        chipGroupChoices = rootView.findViewById(R.id.chipgroup_choice_choices);
        buttonChoose = rootView.findViewById(R.id.button_choice_choose);
        buttonReset = rootView.findViewById(R.id.button_choice_reset);
    }

    public void setListeners(){

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] tags = editTextChoice.getText().toString().split(" ");

                for (String text : tags)
                {
                    chip = (Chip)getActivity().getLayoutInflater().inflate(R.layout.chip_item,null,false);
                    chip.setText(text);
                    chip.setOnCloseIconClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            chipGroupChoices.removeView(view);
                            chipNumber -= 1;
                        }
                    });
                    chipGroupChoices.addView(chip);
                    chipNumber += 1;
                }
            }
        });
        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chipNumber != 0){
                    int randomNumber = (int)(Math.random() * ((chipNumber - 1) + 1));
                    Chip chosenChip = (Chip)chipGroupChoices.getChildAt(randomNumber);
                    chosenChip.setCheckable(true);
                    chosenChip.setChecked(true);
                    chosenChip.setCheckable(false);
                }
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chipNumber != 0){
                    for(int i = chipNumber - 1; 0 <= i; i--){
                        Chip chosenChip = (Chip)chipGroupChoices.getChildAt(i);
                        chipGroupChoices.removeView(chosenChip);
                    }
                    chipNumber = 0;
                }
            }
        });


    }
}
