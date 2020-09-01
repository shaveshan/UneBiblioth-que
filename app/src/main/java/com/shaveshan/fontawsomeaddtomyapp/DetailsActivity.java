package com.shaveshan.fontawsomeaddtomyapp;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {


    EditText titre , author , keyWord , resume;
    AlertDialog.Builder builder;
    Books book;
    int c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        book = getIntent().getExtras().getParcelable("thisBook");

        titre = findViewById(R.id.titreD);
        titre.setText(book.getTitre());
        titre.setInputType(titre.AUTOFILL_TYPE_NONE);

        author = findViewById(R.id.editA);
        author.setText(book.getAutear());
        author.setInputType(author.AUTOFILL_TYPE_NONE);

        keyWord = findViewById(R.id.editKey);
        keyWord.setText(book.getMotCles());
        keyWord.setInputType(keyWord.AUTOFILL_TYPE_NONE);

        resume = findViewById(R.id.editAbs);
        resume.setText(book.getResume());
        resume.setInputType(resume.AUTOFILL_TYPE_NONE);

    }

    public void delete(View view ) {

        builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to delete this Book ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "the Book deleted",
                                Toast.LENGTH_SHORT).show();
                        deltedAct();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), "You choose no Action ",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Delete");
        alert.show();
    }
    private void  deltedAct()
    {
        new DBHelper(getApplicationContext()).deleteContact(book.getId());
        finish();
        startActivity( new Intent(this ,DisplaysBookList.class) );
    }


    public void editBtn(View view) {
        TextView modToSave;
        modToSave = (com.shaveshan.fontawsomeaddtomyapp.MyTextViewFontAwesome) findViewById(R.id.editBtn);

        if(c == 0){
            modToSave.setText(R.string.save);
            c++;
            titre.setInputType(InputType.TYPE_CLASS_TEXT);
            titre.setTextIsSelectable(true);
            author.setInputType(InputType.TYPE_CLASS_TEXT);
            keyWord.setInputType(InputType.TYPE_CLASS_TEXT);
            resume.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);

        }
        else{

            builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to Save this Book ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "the Book Saved",
                                    Toast.LENGTH_SHORT).show();
                            savedAct();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            dialog.cancel();
                            Toast.makeText(getApplicationContext(), "You choose no Action ",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Save");
            alert.show();




        }
    }

    private void savedAct(){

        new DBHelper(getApplicationContext()).updateBooks(
                book.getId() ,
                titre.getText().toString() ,
                author.getText().toString() ,
                keyWord.getText().toString() ,
                resume.getText().toString()
        );
        finish();
        startActivity( new Intent(this ,DisplaysBookList.class) );

    }
}