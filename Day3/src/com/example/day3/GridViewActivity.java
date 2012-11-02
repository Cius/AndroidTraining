package com.example.day3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class GridViewActivity extends Activity {
	private GridView gridView;
	int[] listImages = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new GridAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_grid_view, menu);
        return true;
    }
    
    class GridAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return listImages.length;
		}

		@Override
		public Object getItem(int position) {
			return listImages[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			float scale = getResources().getDisplayMetrics().density;
			
			ImageView view = new ImageView(getApplicationContext());
			view.setScaleType(ScaleType.FIT_CENTER);
			view.setImageResource(listImages[position]);
			view.setLayoutParams(new GridView.LayoutParams((int) (50*scale), (int) (50*scale)));
			return view;
		}
    	
    }
}
