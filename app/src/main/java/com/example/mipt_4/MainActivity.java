package com.example.mipt_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NotesManager notesManager;
    private ListView notesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesManager = new NotesManager(this);
        notesListView = findViewById(R.id.notesListView);

        if(notesManager.getAllNoteTitles().isEmpty()){
            notesManager.addNote("Test", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        }
        loadNotes();
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }

    private void loadNotes(){
        List<String> titles = notesManager.getAllNoteTitles();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        notesListView.setAdapter(adapter);

        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String selectedNoteTitle = (String) parent.getItemAtPosition(position);

               String noteContent = notesManager.getNoteContentByTitle(selectedNoteTitle);

                Intent intent   = new Intent(MainActivity.this, ViewNoteActivity.class);
                intent.putExtra("noteTitle", selectedNoteTitle);
                intent.putExtra("noteContent", noteContent);

                startActivity(intent);
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.create_note) {
            startActivity(new Intent(this, AddNoteActivity.class));
            return true;
        } else if (item.getItemId() == R.id.delete_note) {
            startActivity(new Intent(this, DeleteNoteActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}




























