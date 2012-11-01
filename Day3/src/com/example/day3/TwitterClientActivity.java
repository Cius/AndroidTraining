package com.example.day3;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.day3.model.TwitterModel;
import com.example.day3.model.TwitterModel.Tweet;
import com.google.gson.Gson;

public class TwitterClientActivity extends ListActivity {

	String response = "";
	List<Tweet> list = new ArrayList<Tweet>();
	
	private BaseAdapter adapter;

	String url = "@cius";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_twitter_client);

		new Task().execute(url);

		adapter = new CustomAdapter(this, list);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_twitter_client, menu);
		return true;
	}

	public String getResponseFromUrl(String url) {
		String response = null;
		HttpClient client = new DefaultHttpClient();

		HttpGet httpGet = new HttpGet(url);
		try {
			ResponseHandler<String> handler = new BasicResponseHandler();
			response = client.execute(httpGet, handler);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	class Task extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			try {
				response = getResponseFromUrl("http://search.twitter.com/search.json?q="+params[0]);
				
				Gson gson = new Gson();
				TwitterModel model = gson.fromJson(response, TwitterModel.class);
				list.addAll(model.getResults());

//				JSONObject object = new JSONObject(response);
//				JSONArray array = object.getJSONArray("results");
//				
//				for(int i = 0; i < array.length(); i++) {
//					object = array.getJSONObject(i);
//					TwitterModel model = new TwitterModel();
//					model.setFrom_user(object.getString("from_user"));
//					model.setContent(object.getString("text"));
//					
//					list.add(model);
//				}
			}catch(Exception e) {
				return "ERROR";
			}
			return null;
		}    	
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			
			if(result != "ERROR") {
				adapter.notifyDataSetChanged();
			}else {
				Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
			}
		}
	}
}
