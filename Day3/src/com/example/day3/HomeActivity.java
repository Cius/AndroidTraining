package com.example.day3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity implements OnClickListener {
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(this);
		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(this);
		button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(this);
		button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}

	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.button1:
			Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
			startActivity(intent);
			break;
		case R.id.button2:
			Intent intent2 = new Intent(getApplicationContext(), GPSActivity.class);
			startActivity(intent2);
			break;
		case R.id.button3:
			Intent intent3 = new Intent(getApplicationContext(), MapActivity.class);
			startActivity(intent3);
			break;
		case R.id.button4:
			Intent intent4 = new Intent(getApplicationContext(), ListViewMapActivity.class);
			startActivity(intent4);
		case R.id.button5:
			Intent intent5 = new Intent(getApplicationContext(), TwitterClientActivity.class);
			startActivity(intent5);
			break;
		default:
			break;
		}
	}
}
