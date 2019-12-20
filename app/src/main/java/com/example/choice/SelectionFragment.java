package com.example.choice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class SelectionFragment extends Fragment {

    private Button buttonChapter1;
    private Button buttonChapter2;
    private Button buttonChapter3;

    public static final String EXTRA_CHAPTER = "chapter";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_select, container, false);
        wireWidgets(rootView);

        setListeners();

        return rootView;
    }
    public void wireWidgets(View rootView){
        buttonChapter1 = rootView.findViewById(R.id.button_chapter1_select);
        buttonChapter2 = rootView.findViewById(R.id.button_chapter2_select);
        buttonChapter3 = rootView.findViewById(R.id.button_chapter3_select);
    }
    public void setListeners(){
        buttonChapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent targetIntent = new Intent(getActivity(), ChapterActivity.class);
                // put a string extra with whatever the text of the current button is
                targetIntent.putExtra(EXTRA_CHAPTER,((Button)v).getText().toString());
                startActivity(targetIntent);
            }
        });
        buttonChapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent targetIntent = new Intent(getActivity(), ChapterActivity.class);
                // put a string extra with whatever the text of the current button is
                targetIntent.putExtra(EXTRA_CHAPTER,((Button)v).getText().toString());
                startActivity(targetIntent);
            }
        });
        buttonChapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent targetIntent = new Intent(getActivity(), ChapterActivity.class);
                // put a string extra with whatever the text of the current button is
                targetIntent.putExtra(EXTRA_CHAPTER,((Button)v).getText().toString());
                startActivity(targetIntent);
            }
        });
    }

}
