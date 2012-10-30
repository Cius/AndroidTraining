package com.example.listviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity2 extends Activity implements OnItemClickListener {
	List<Map<String, String>> items = new ArrayList<Map<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        
        for(int i = 0; i < 5; i++) {
        	Map<String, String> map = new HashMap<String, String>();
            
            map.put("COUNTRY", "Country" + i);
            map.put("CAPITAL", "Capital" + i);
            map.put("DESC", "Description" + i);
            items.add(map);
        }
        
        ListView listView = (ListView) findViewById(R.id.list2);
        String[] from = new String[]{"COUNTRY", "CAPITAL"};
        int[] to = new int[]{android.R.id.text2, android.R.id.text1};
        
        SimpleAdapter adapter = new SimpleAdapter(this, items, android.R.layout.simple_list_item_2, from, to);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
//        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_activity2, menu);
        return true;
    }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Toast.makeText(getApplicationContext(), "Kamu pasti pilih " + items.get(arg2).get("COUNTRY") + " yang ibukotanya di "
				+ items.get(arg2).get("CAPITAL") + " ya", Toast.LENGTH_LONG).show();
		
		Intent intent = new Intent(getApplicationContext(), DetailListActivity.class);
		intent.putExtra("CAPITAL", ((Map<String, String>) arg0.getItemAtPosition(arg2)).get("CAPITAL"));
		intent.putExtra("COUNTRY", ((Map<String, String>) arg0.getItemAtPosition(arg2)).get("COUNTRY"));
		intent.putExtra("DESC", ((Map<String, String>) arg0.getItemAtPosition(arg2)).get("DESC"));
		startActivity(intent);
	}
}
