package com.shaveshan.fontawsomeaddtomyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //got( searching("mounir") );
    }
/*
    public void got(ArrayList<Books> b){
        Intent myIntent = new Intent(this ,DisplaysBookList.class);
        myIntent.putExtra("a", b );
        startActivity( myIntent );
    }
*/
    private static ArrayList<Books> l1 = new ArrayList<>() ;
    public static ArrayList<Books> searching(String search) {
        Books b1 , b2 , b3 , b4;
        b1 = new Books("1" ,"ggg" ,"mounir,aahmed,ali,vvaa,bilale","ggg");
        b2 = new Books("2" ,"ggg" ,"ff,mou,2aacc,ddd,eaaee" ,"ggg");
        b3 = new Books("3" ,"ggg" ,"element_3,111,22,33,aa" ,"ggg");
        b4 = new Books("4" ,"ggg" ,"aa,ddd,eee,mo,mou" ,"ggg");
        ArrayList<Books> arrayList = new ArrayList<>();
        arrayList.add(b1);
        arrayList.add(b2);
        arrayList.add(b3);
        arrayList.add(b4);



        ArrayList<Books> result = new ArrayList<>() ,

                l2 = new ArrayList<>() ,
                l3 = new ArrayList<>() ,
                l4 = new ArrayList<>() ,
                l5 = new ArrayList<>() ,
                l6 = new ArrayList<>();

        for (Books keyWords : arrayList) {
            if( keyWords.getMotCles().contains(search) ){
                result.add(keyWords);
            }
        }
        for (Books r1 : result) {
            String[] m5 = r1.getMotCles().split(",");
            int i = 0;
            for(String index : m5){
                i++;
                if(index.contains(search)){

                    i = (index.length() != search.length()) ? 6 : i ;
                    switch(i){
                        case 1 : l1.add(r1);
                            break;
                        case 2 : l2.add(r1);
                            break;
                        case 3 : l3.add(r1);
                            break;
                        case 4 : l4.add(r1);
                            break;
                        case 5 : l5.add(r1);
                            break;
                        case 6 : l6.add(r1);
                            break;
                    }
                    break;
                }
            }
        }
        funAddList(l2);
        funAddList(l3);
        funAddList(l4);
        funAddList(l5);
        funAddList(l6);
        return l1;
    }

    private static void funAddList(ArrayList<Books> b){
        while(b.size()>0){
            l1.add( b.get(0) );
            b.remove(0);
        }

    }


}
