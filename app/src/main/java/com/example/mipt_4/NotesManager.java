package com.example.mipt_4;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NotesManager {
    public static final String PREFS_NAME = "NotesPrefs";
    public static final String NOTE_TITLE_PREFIX = "NoteTitle";
    public static final String NOTE_CONTENT_PREFIX = "NoteContent";

    private SharedPreferences sharedPref;

    public NotesManager(Context context){
    sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void addNote(String title, String content){
        int noteID = (int) System.currentTimeMillis();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(NOTE_TITLE_PREFIX + noteID, title);
        editor.putString(NOTE_CONTENT_PREFIX + noteID, content);
        editor.apply();
    }
    public List<String> getAllNoteTitles(){
        List<String> titles = new ArrayList<>();
        Map<String, ?> allEntries = sharedPref.getAll();
        for(Map.Entry<String, ?> entry : allEntries.entrySet()){
            if(entry.getKey().startsWith(NOTE_TITLE_PREFIX)){
                titles.add((String) entry.getValue());
            }
        }
        return titles;
    }

    public String getNoteContentByTitle(String title){
        Map<String,?> allEntries = sharedPref.getAll();
        for(Map.Entry<String, ?> entry : allEntries.entrySet()) {
        if(entry.getKey().startsWith(NOTE_TITLE_PREFIX) && entry.getValue().equals(title)){
            String id = entry.getKey().replace(NOTE_TITLE_PREFIX, "");
            return sharedPref.getString(NOTE_CONTENT_PREFIX + id, "");
        }
        }

        return null;
    }
    public void deleteNoteByTitle(String title){
        SharedPreferences.Editor editor = sharedPref.edit();
        Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()){
            if(entry.getKey().startsWith(NOTE_TITLE_PREFIX) && entry.getValue().equals(title)){
                String id = entry.getKey().replace(NOTE_TITLE_PREFIX, "");
                editor.remove(NOTE_TITLE_PREFIX + id);
                editor.remove(NOTE_CONTENT_PREFIX + id);
                break;
            }
        }
        editor.apply();
    }
}


































