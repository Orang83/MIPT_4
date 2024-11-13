package com.example.mipt_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewNoteActivity extends AppCompatActivity {
    private TextView noteTitleTextView;
    private TextView noteContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        noteTitleTextView = findViewById(R.id.noteTitleTextView);
        noteContentTextView = findViewById(R.id.noteContentTextView);

        Intent intent = getIntent();
        String noteTitle = intent.getStringExtra("noteTitle");
        String noteContent = intent.getStringExtra("noteContent");

        noteTitleTextView.setText(noteTitle);
        noteContentTextView.setText(noteContent);
    }
}
























