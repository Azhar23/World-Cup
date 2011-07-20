package com.gipl.wc2011;

//import com.gipl.wc2011.Settings.EfficientAdapter.ViewHolder;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.View.OnClickListener;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.CheckedTextView;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//public class Schedule extends Activity{
//	ListView lv;
//	ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12,iv13,iv14;
//	Button btn1,btn2;
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.schedule);
//		btn2 = (Button)findViewById(R.id.btnExit3);
//		btn2.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				finish();
//			}
//		});
//		iv1 = (ImageView) findViewById(R.id.image1);
//		iv1.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//				
//	}
//	
//	private static class EfficientAdapter extends BaseAdapter 
//	{
//		
//		 private LayoutInflater mInflater;
//		 Context context;
//		
//		 
//		 public EfficientAdapter(Context context) {
//			 this.context = context;
//			 mInflater = LayoutInflater.from(context);
//			 
//		 }
//	
//		 public int getCount() {
//			 return listItems.length;
//		 }
//				 
//		 public Object getItem(int position) {
//
//			 return position;
//
//		 }
//
//		 public long getItemId(int position) {
//
//			 return position;
//
//		 }
//
//		 public static class ViewHolder 
//		 {
//
//			 TextView txtTime, txtDays, txtalarmSound, txtreminder, txtalarmEnable, txtsave, txtdelete, txtcreate;;
//			 CheckedTextView ct;
//			 ImageView[] imageList = new ImageView[3];
//		 
//		 }
//
//		 @Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			// TODO Auto-generated method stub
//			 
//			 ViewHolder holder;
//
//			 holder = new ViewHolder();
//			 TextView textView;
//			 
//			 if(position == 0 || position == indexOfSuggestedLabel){
//				 
//				 convertView = mInflater.inflate(R.layout.listitemheader, null);	
//			 	  textView = (TextView) convertView.findViewById(R.id.tvLabel);
//			 	  textView.setText(listItems[position]);	
//			 	 textView.setSingleLine();
//			 	 
//			 }else{
//				if (position == indexOfAddFeeds){
//				 
//				 convertView = mInflater.inflate(R.layout.customlistalert, null);
//	 			 textView = (TextView) convertView.findViewById(R.id.tvLabel);
//	 			 textView.setText(listItems[position]);
//	 			 textView.setSingleLine();
//	 			 
//			 }else if(position == indexOfAddFeeds + 1 || position == indexOfAddFeeds + 2) {
//				 
//				 convertView = mInflater.inflate(R.layout.customlistviewsimpleitem, null);	
//			 	  textView = (TextView) convertView.findViewById(R.id.tvLabel);
//			 	  textView.setText(listItems[position]);	
//			 	 textView.setSingleLine();
//			 	 
//			}else{
//				
//				 convertView = mInflater.inflate(R.layout.customlistcheckbox, null);	
//	 			 CheckedTextView chkenable = (CheckedTextView) convertView.findViewById(R.id.chkMe);
//	 			 if(position <= subscribedList.size())
//	 			 {
//	 				 chkenable.setChecked(true);
//	 			 }else{
//	 				  chkenable.setChecked(false);
//	 			 }
// 				
// 				 chkenable.setOnClickListener(new OnClickListener() {
//					
//					@Override
//					public void onClick(View v) {
//						// TODO Auto-generated method stub
//						((CheckedTextView) v).toggle();
//						int position = feedListView.getPositionForView(v);
//						updateSubscribeList(position, ((CheckedTextView) v).isChecked());
//					}
//
//					
//				});
// 				 chkenable.setText(listItems[position]);
// 				chkenable.setSingleLine();
//				
// 				 textView = (TextView) convertView.findViewById(R.id.tvLabel2);
// 	 			 textView.setText(listItemsValue[position]);
// 				 textView.setWidth(200);
// 				 textView.setMaxLines(2);
//			}
//			 }
//			 		
//			 
//			 if (convertView == null) 
//			 {
//				 convertView.setTag(holder);
//			 } 
//			 else 
//			 {				 
//				 holder = (ViewHolder) convertView.getTag();
//			 }
//			 return convertView;
//		}
//	}
//}
