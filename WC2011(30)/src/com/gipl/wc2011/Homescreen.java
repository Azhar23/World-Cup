package com.gipl.wc2011;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Homescreen extends Activity{
	EditText et1;
	Button bt1,bt2,bt3,bt4,bt5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);
		et1 = (EditText)findViewById(R.id.editNextMatch);
		bt1 = (Button)findViewById(R.id.btnSchedule);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showScheduleActivity();
			}
		});
		bt2 = (Button)findViewById(R.id.btnAlarms);
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showAlarmActivity();
			}
		});
		bt3 = (Button)findViewById(R.id.btnSettings);
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showSettingsActivity();
			}
		});
		bt4 = (Button) findViewById(R.id.btnExit2);
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	 public void showScheduleActivity()
	    {	
//	 startActivity(new Intent(this,Schedule.class));
	    }
	 public void showAlarmActivity()
	    {	startActivity(new Intent(this,Alarm.class));
	    }
	 public void showSettingsActivity()
	    {	startActivity(new Intent(this,Settings.class));
	    }
}
