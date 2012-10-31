package com.example.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListViewMapActivity extends Activity implements OnItemClickListener {
	List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	ListView view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_map);

		int lat = (int) (-6.197*1E6);
		int lon = (int) (106.847*1E6);
		int[] point = new int[]{lat, lon};

		Map<String, Object> item = new HashMap<String, Object>();
		item.put("ACTIVITY", "DKI Jakarta");
		item.put("DESC", "Jakarta");
		item.put("ATTR", point);
		list.add(item);

		lat = (int) (-5.424*1E6);
		lon = (int) (105.243*1E6);
		int[] point1 = new int[]{lat, lon};

		Map<String, Object> item1 = new HashMap<String, Object>();
		item1.put("ACTIVITY", "Lampung");
		item1.put("DESC", "Bandar Lampung");
		item1.put("ATTR", point1);
		list.add(item1);

		lat = (int) (-6.9116*1E6);
		lon = (int) (107.6099*1E6);
		int[] point2 = new int[]{lat, lon};

		Map<String, Object> item2 = new HashMap<String, Object>();
		item2.put("ACTIVITY", "Jawa Barat");
		item2.put("DESC", "Bandung");
		item2.put("ATTR", point2);
		list.add(item2);

		lat = (int) (-6.958*1E6);
		lon = (int) (110.417*1E6);
		int[] point3 = new int[]{lat, lon};

		Map<String, Object> item3 = new HashMap<String, Object>();
		item3.put("ACTIVITY", "Jawa Tengah");
		item3.put("DESC", "Semarang");
		item3.put("ATTR", point3);
		list.add(item3);
		
		lat = (int) (-7.7935*1E6);
		lon = (int) (110.3691*1E6);
		int[] point4 = new int[]{lat, lon};

		Map<String, Object> item4 = new HashMap<String, Object>();
		item4.put("ACTIVITY", "DI Yogyakarta");
		item4.put("DESC", "Yogyakarta");
		item4.put("ATTR", point4);
		list.add(item4);
		
		lat = (int) (-7.283*1E6);
		lon = (int) (112.733*1E6);
		int[] point5 = new int[]{lat, lon};

		Map<String, Object> item5 = new HashMap<String, Object>();
		item5.put("ACTIVITY", "Jawa Timur");
		item5.put("DESC", "Surabaya");
		item5.put("ATTR", point5);
		list.add(item5);

		view = (ListView) findViewById(R.id.listView1);
		String[] from = new String[]{"ACTIVITY", "DESC"};
		int[] to = new int[]{android.R.id.text1, android.R.id.text2};

		SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2, from, to);
		view.setAdapter(adapter);
		view.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_list_view_map, menu);
		return true;
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(getApplicationContext(), MapActivity.class);
		intent.putExtra("POINT", (int[]) ((Map<String, Object>) arg0.getItemAtPosition(arg2)).get("ATTR")); 
		startActivity(intent);
	}
}
