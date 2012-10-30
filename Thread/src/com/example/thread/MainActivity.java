package com.example.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	TextView textView;
	ProgressDialog dialog;
	int i = 0;
	int max = 10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("0");
        
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax(max);
        dialog.setMessage("Processing...");
        dialog.show();
        
        new MyCounterTask().execute(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    class MyCounterTask extends AsyncTask<Integer, Integer, String> {

		@Override
		protected String doInBackground(Integer... params) {
			i = params[0];
			while(i < max) {
				try {
					Thread.sleep(1000);
					i++;
					publishProgress(i);
				}catch(InterruptedException e) {
				}
			}
			
			return "Selesai";
		}
    	
		protected void onPreExecute() {
			Toast.makeText(MainActivity.this, "Mulai", Toast.LENGTH_LONG).show();
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			textView.setText(values[0] + "");
			dialog.setProgress(values[0]);
		}
		
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
			dialog.dismiss();
		}
    }
}
