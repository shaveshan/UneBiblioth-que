package com.shaveshan.fontawsomeaddtomyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void serBook(View view) {
        Intent myIntent = new Intent(this , SearchActivity.class);
        startActivity( myIntent );
    }
    public void addBook(View view) {
        Intent myIntent = new Intent(this ,AddBookActivity.class);
        startActivity( myIntent );
    }
    public void displaysBookList(View view) {
        Intent myIntent = new Intent(this ,DisplaysBookList.class);
        startActivity( myIntent );
    }
}
