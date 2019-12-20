package com.example.choice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ChapterActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewChapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_detail);

        wireWidgets();
        Intent lastIntent = getIntent();
        textViewTitle.setText(lastIntent.getStringExtra(SelectionFragment.EXTRA_CHAPTER));

        if (lastIntent.getStringExtra(SelectionFragment.EXTRA_CHAPTER).equals("Chapter 1: Emotions")){
            InputStream XmlFileInputStream = getResources().openRawResource(R.raw.chapter1);
            String text = readTextFile(XmlFileInputStream);
            textViewChapter.setText(text);
        }
        else if (lastIntent.getStringExtra(SelectionFragment.EXTRA_CHAPTER).equals("Chapter 2: Analysis")){
            InputStream XmlFileInputStream = getResources().openRawResource(R.raw.chapter2);
            String text = readTextFile(XmlFileInputStream);
            textViewChapter.setText(text);
        }
        else if (lastIntent.getStringExtra(SelectionFragment.EXTRA_CHAPTER).equals("Chapter 3: Results")){
            InputStream XmlFileInputStream = getResources().openRawResource(R.raw.chapter3);
            String text = readTextFile(XmlFileInputStream);
            textViewChapter.setText(text);
        }
    }
    public void wireWidgets(){
        textViewTitle = findViewById(R.id.textview_title_chapter);
        textViewChapter = findViewById(R.id.textview_text_chapter);
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
