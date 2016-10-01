package com.example.imran.simpleapp.allroots;

import android.content.*;
import android.os.*;
import android.support.design.widget.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import android.app.*;
import android.widget.*;
import android.widget.AdapterView.*;
import java.util.*;
import com.example.imran.simpleapp.* ;

import com.example.imran.simpleapp.* ;

public class shrabon extends Activity implements OnItemSelectedListener {
    public static String item , TIME1, STOPPAGE1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_shrabon);

        Spinner spinner = (Spinner) findViewById(R.id.shrabon);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("7:20 AM");
        categories.add("8:15 AM");
        categories.add("9:00 AM");
        categories.add("10:00 AM");

        Spinner spinner2 = (Spinner) findViewById(R.id.shr_stoppage);
        spinner2.setOnItemSelectedListener(this);
        List<String> categories2 = new ArrayList<String>();
        categories2.add("খিলগাঁও");
        categories2.add("মুগদা");
        categories2.add("বৌদ্ধ মন্দির");
        categories2.add("বাসাবো");


        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        ImageButton myButton = (ImageButton) findViewById(R.id.Enter) ;
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MyHabizabiClass.setMySchdedule(TIME1) ;
                MyHabizabiClass.setMyStoppage(STOPPAGE1);

                Intent intent = new Intent(v.getContext(), com.example.imran.simpleapp.ResultActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getItemAtPosition(position).toString();
        if(item.equals("7:20 AM")||item.equals("8:15 AM") ||item.equals("9:00 AM") || item.equals("10:00 AM")){
            TIME1 = item ;
        }
        else{
            STOPPAGE1 = item ;
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
    }
}
