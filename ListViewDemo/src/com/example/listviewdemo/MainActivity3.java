package com.example.listviewdemo;

import android.app.ListActivity;
import android.content.Intent;
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
    
    protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) {
    	Intent intent = new Intent(this, DetailListActivity.class);
    	intent.putExtra("COUNTRY", words[position]);
    	intent.putExtra("CAPITAL", words[position]);
    	intent.putExtra("DESC", words[position]);
    	startActivity(intent);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_activity3, menu);
        return true;
    }
}
