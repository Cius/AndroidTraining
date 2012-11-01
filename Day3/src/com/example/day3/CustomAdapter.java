package com.example.day3;

import java.util.List;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.day3.model.TwitterModel;

public class CustomAdapter extends BaseAdapter {
	private Activity a;
	private List<TwitterModel> models;
	
	private static LayoutInflater inflater = null;
	
	public CustomAdapter(Activity a, List<TwitterModel> list) {
		this.a = a;
		models = list;
		inflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return models.size();
	}

	public Object getItem(int position) {
		return models.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		vi = inflater.inflate(R.layout.simple_list_item_2, null);
		
		TextView view = (TextView) vi.findViewById(R.id.text1);
		view.setText(models.get(position).getFrom_user());
		
		TextView view2 = (TextView) vi.findViewById(R.id.text2);
		view2.setText(models.get(position).getContent());
		
		return vi;
	}

}
