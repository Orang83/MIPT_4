package com.example.mipt_4;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    private NotesManager notesManager;
    private EditText titleEditText, contentEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        notesManager = new NotesManager(this);
        titleEditText = findViewById(R.id.titleEditText);
        contentEditText = findViewById(R.id.contentEditText);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString().trim();
            String content = contentEditText.getText().toString().trim();

            if(TextUtils.isEmpty(title) || TextUtils.isEmpty(content)){
                Toast.makeText(AddNoteActivity.this, "Enter a title and content", Toast.LENGTH_SHORT).show();

            }else{
                notesManager.addNote(title,content);
                Toast.makeText(AddNoteActivity.this,"Note added",Toast.LENGTH_SHORT).show();
                finish();
            }

        });
    }
}

























