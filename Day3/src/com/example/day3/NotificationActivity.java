package com.example.day3;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NotificationActivity extends Activity implements OnClickListener {

	NotificationManager manager;

	String ticker;
	String title;
	String message;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		((Button) findViewById(R.id.notifButton1)).setOnClickListener(this);
	}

	private void showNotif() {
		int icon = android.R.drawable.ic_btn_speak_now;
		long when = System.currentTimeMillis() + 5000;

		Intent intent = new Intent(this, HomeActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

		Notification notification = new Notification(icon, ticker, when);
		notification.setLatestEventInfo(this, title, message, pendingIntent);
		
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
//		notification.defaults |= Notification.DEFAULT_VIBRATE;
//		notification.defaults |= Notification.DEFAULT_SOUND;
//		notification.defaults |= Notification.DEFAULT_LIGHTS;

		manager.notify(1, notification);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_notification, menu);
		return true;
	}

	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.notifButton1:
			ticker = ((EditText) findViewById(R.id.notif_edit_1)).getText().toString();
			title = ((EditText) findViewById(R.id.notif_edit_2)).getText().toString();
			message = ((EditText) findViewById(R.id.notif_edit_3)).getText().toString();
			
			showNotif();
			break;
		default: break;
		}
	}
}
