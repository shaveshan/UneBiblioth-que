package com.shaveshan.fontawsomeaddtomyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class DisplaysBookList extends AppCompatActivity {
    private ListView myList;
    private TextView isEmpty;
    private boolean test;
    private static ArrayList <Books> booksList = new ArrayList<Books>();
    private static DBHelper call ;
    private Context c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displays_book_list);




        c = getApplicationContext();
        call = new DBHelper(c);
        myList = findViewById(R.id.thisList);
        isEmpty = findViewById(R.id.vide);
        test =  (call.numberOfRows() == 0) ;
        isEmpty.setVisibility( test ? isEmpty.VISIBLE : isEmpty.INVISIBLE );
        myList.setVisibility(! test ? myList.VISIBLE :myList.INVISIBLE);


        (isEmpty).setLayoutParams(
                new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        test ? TableLayout.LayoutParams.MATCH_PARENT : 0,
                        test ? 1f : 0f
                )
        );

        myList.setLayoutParams(
                new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        !test ? TableLayout.LayoutParams.MATCH_PARENT : 0,
                        !test ? 1f : 0f
                )
        );

        if (!test) {

            booksList =  SearchActivity.searching("mou");//call.ListerTousRDV();
            myList.setAdapter(new CustomAdapter(c,booksList));
            myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Books b = booksList.get(position);
                    details(b);

                }
            });
        }

    }

    public void details(  Books b  ) {
        Intent myIntent = new Intent(this ,DetailsActivity.class);
        myIntent.putExtra("thisBook",  b );
        finish();
        startActivity( myIntent );
    }

}
