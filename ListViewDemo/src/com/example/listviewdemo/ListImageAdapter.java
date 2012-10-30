package com.example.listviewdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListImageAdapter extends BaseAdapter {
	private Activity a;
	private int[] images;
	private String[] words;
	private static LayoutInflater inflater = null;
	
	public ListImageAdapter(Activity a, int[] images, String[] words) {
		this.a = a;
		this.images = images;
		this.words = words;
		inflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return words.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		vi = inflater.inflate(R.layout.activity_add_image, null);
		
		ImageView image = (ImageView) vi.findViewById(R.id.image);
		TextView word = (TextView) vi.findViewById(R.id.text);
		
		image.setImageResource(images[position]);
		word.setText(words[position]);
		
		return vi;
	}
}
