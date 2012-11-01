package com.example.day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.example.day3.model.Result;
import com.example.day3.model.Result.TorestoUser;
import com.google.gson.Gson;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {
	EditText user;
	EditText pass;	
	
	String url = "http://toresto.com/restaurantlogin.php";
	
	TorestoUser torestoUser;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		user = (EditText) findViewById(R.id.editText1);
		pass = (EditText) findViewById(R.id.editText2);
		
		((Button)findViewById(R.id.buttonLogin1)).setOnClickListener(this);
		((Button)findViewById(R.id.buttonLogin2)).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.buttonLogin1:
			new LoginTask().execute(user.getText().toString(), pass.getText().toString());
			break;
		case R.id.buttonLogin2:
			user.setText("");
			pass.setText("");
			break;
		default:
			break;
		}
	}
	
	private String login(String user, String pass) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		
		List<NameValuePair> data = new ArrayList<NameValuePair>(2);
		data.add(new BasicNameValuePair("username", user));
		data.add(new BasicNameValuePair("password", pass));
		httpPost.setEntity(new UrlEncodedFormEntity(data));
		
		HttpResponse response = client.execute(httpPost);
		HttpEntity entity = response.getEntity();
		
		String res =  EntityUtils.toString(entity);
		return res;
	}
	
	private TorestoUser parseData(String json) {
		Gson gson = new Gson();
		TorestoUser user = gson.fromJson(json, Result.class).getResult();
		return user;
	}
	
	class LoginTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			try {
				torestoUser = parseData(login(params[0], params[1]));
			} catch (Exception e) {
				return "ERROR";
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			
			if(result == null) {
				String r = "";
				if(torestoUser.getValid().equals("true"))
					r = "valid";
				else
					r = "not valid";
					
				Toast.makeText(getApplicationContext(), "User is " + r, Toast.LENGTH_LONG).show();
			}else {
				Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
			}
		}
		
	}
}
