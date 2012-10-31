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
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
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
		default:
			break;
		}
	}
}
