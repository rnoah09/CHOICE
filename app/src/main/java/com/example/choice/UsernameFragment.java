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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UsernameFragment extends Fragment {

    private TextView textViewOutput;
    private EditText editTextAdj;
    private EditText editTextNoun;
    private Button buttonGenerate;
    private List<String> nouns;
    private List<String> adjectives;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_username, container, false);
        wireWidgets(rootView);
        setListeners();

        InputStream XmlFileInputStream = getResources().openRawResource(R.raw.nouns);
        String noun = readTextFile(XmlFileInputStream);
        nouns = Arrays.asList(noun.split("\n"));

        XmlFileInputStream = getResources().openRawResource(R.raw.adjectives);
        String adjective = readTextFile(XmlFileInputStream);
        adjectives = Arrays.asList(adjective.split("\n"));

        return rootView;
    }

    public void wireWidgets(View rootView){
        textViewOutput = rootView.findViewById(R.id.textview_username_output);
        editTextAdj = rootView.findViewById(R.id.edittext_username_adj);
        editTextNoun = rootView.findViewById(R.id.edittext_username_noun);
        buttonGenerate = rootView.findViewById(R.id.button_username_generate);
    }
    public void setListeners(){
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noun;
                String adjective;

             if(editTextAdj.getText().toString().isEmpty()){
                 int randomNumber = (int)((Math.random() * ((adjectives.size() - 1) + 1)) + 0);
                 Collections.shuffle(adjectives);
                 adjective = adjectives.get(randomNumber);
             }
             else{
                 adjective = editTextAdj.getText().toString();
             }

             if(editTextNoun.getText().toString().isEmpty()){
                 int randomNumber = (int)((Math.random() * ((nouns.size() - 1) + 1)) + 0);
                 Collections.shuffle(nouns);
                 noun = nouns.get(randomNumber);
             }
             else{
                 noun = editTextNoun.getText().toString();
             }

             noun = noun.substring(0, 1).toUpperCase() + noun.substring(1);
             adjective = adjective.substring(0, 1).toUpperCase() + adjective.substring(1);
             textViewOutput.setText(adjective + noun);

            }
        });
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
}
