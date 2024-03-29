package com.example.day3;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day3.imageloader.ImageLoader;
import com.example.day3.model.TwitterModel.Tweet;

public class CustomAdapter extends BaseAdapter {
	private Activity a;
	private List<Tweet> models;
	
	private static LayoutInflater inflater = null;
	
	public CustomAdapter(Activity a, List<Tweet> list) {
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
		vi = inflater.inflate(R.layout.row_twitter, null);
		
		TextView view = (TextView) vi.findViewById(R.id.tw_text1);
		view.setText(models.get(position).getFrom_user());
		
		TextView view2 = (TextView) vi.findViewById(R.id.tw_text2);
		view2.setText(models.get(position).getText());
		
		ImageView imageView = (ImageView) vi.findViewById(R.id.tw_logo);
		ImageLoader loader = new ImageLoader(a.getApplicationContext());
		loader.DisplayImage(models.get(position).getProfile_image_url(), imageView);
		
		return vi;
	}

}
