package com.example.listviewdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity3 extends ListActivity {
	String[] words = new String[2];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        
        int images[] = {R.drawable.ic_launcher, R.drawable.ic_launcher};
        words[0] = "Bandung";
        words[1] = "Jakarta";
        
        ListImageAdapter adapter = new ListImageAdapter(this, images, words);
        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_activity3, menu);
        return true;
    }
}
