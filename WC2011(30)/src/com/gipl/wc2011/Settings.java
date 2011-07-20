package com.gipl.wc2011;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Settings extends Activity{
	Spinner spnr1,spnr2;
	Button btn1;
	String[] teamnames;
	String[] notifyto;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		spnr1 = (Spinner)findViewById(R.id.spinner1);
		setHomeTeams();
		spnr2 = (Spinner)findViewById(R.id.spinner2);
		setNotificationto();
		btn1 = (Button)findViewById(R.id.btnExit5);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	 public void setHomeTeams()
	    {
		 teamnames = "Australia,Bangladesh,Canada,England,India,Ireland,Kenya,Netherlands,Newzealand,Pakistan,southAfrica,Srilanka,WestIndies,Zimbabwe".split(",");
	        ArrayAdapter<String> sadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamnames);
		    spnr1.setAdapter(sadapter);
	    }
	 public void setNotificationto()
	 {
		 notifyto ="Notify All,Home Team".split(",");
		 ArrayAdapter<String> s2adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, notifyto);
		 spnr2.setAdapter(s2adapter);
	 }
	 
	
	 
}
