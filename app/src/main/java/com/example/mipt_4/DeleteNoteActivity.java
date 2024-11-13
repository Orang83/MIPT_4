package com.example.mipt_4;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DeleteNoteActivity extends AppCompatActivity {

    private NotesManager notesManager;
    private Spinner notesSpinner;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        notesManager = new NotesManager(this);
        notesSpinner = findViewById(R.id.notesSpinner);
        deleteButton=findViewById(R.id.deleteButton);

        loadNotes();

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String selectedNote = (String) notesSpinner.getSelectedItem();
                if (selectedNote != null) {
                    notesManager.deleteNoteByTitle(selectedNote);
                    Toast.makeText(DeleteNoteActivity.this, "Note deleted", Toast.LENGTH_SHORT).show();
                    loadNotes();
                }
            }
        });
    }

    private void loadNotes(){
        List<String> titles = notesManager.getAllNoteTitles();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,titles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        notesSpinner.setAdapter(adapter);
    }
}




















