
package com.gipl.wc2011.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MyTime {

    int hours;
    int minutes;
    long time;
    Calendar localCal;
    Calendar GMTCal;
    Date tempDate;
    
    public MyTime()
    {
    	
    }
    
    public MyTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        
        setGMTTime();
        setLocalTime();
    }
       
    public MyTime(int hours, int minutes, boolean isPm) {      
        if (isPm) {
		hours += 12;
	}		
        this.hours = hours;
        this.minutes = minutes;
        
        setGMTTime();
        setLocalTime();
    }
    
    public MyTime(long GMTTime)
    {
    	GMTCal.setTimeInMillis(GMTTime);
    	setLocalTime();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
    
    public long getLongLocalTime()
    {
    	return localCal.getTimeInMillis();
    }
    
    public long getLongGMTTime()
    {
    	return GMTCal.getTimeInMillis();
    }
    
    public String getLocalTime(boolean inAMPM)
    {
    	return getTimeDescription(localCal, inAMPM);
    }
    
    public String getGMTTime(boolean inAMPM)
    {
    	return getTimeDescription(GMTCal, inAMPM);
    }
    
    public String getLocalDate()
    {
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	tempDate = localCal.getTime();
    	
		return df.format(tempDate);
    }
    
    public void setLongLocalTime(long localTime)
    {
    	localCal.setTimeInMillis(localTime);
    }
    
    public void setLongGMTTime(long GMTTime)
    {
    	GMTCal.setTimeInMillis(GMTTime);
    }
    
    
    	/**
	 * @param baseAMPM
	 * @return
	 */
	public String getTimeDescription (Calendar cal, boolean baseAMPM) {
		
		hours = cal.get(Calendar.HOUR_OF_DAY);
		minutes = cal.get(Calendar.MINUTE);
		String timeDesc;
		if(minutes < 10){
			timeDesc = ":0" + minutes;
		}else{
			timeDesc = ":" + minutes;
		}
		
		if (baseAMPM) {
			if (hours >= 12) {
				timeDesc += " pm";
			} else {
				timeDesc += " am";
			}
			
			if (hours > 12) {
				if((hours - 12) < 10){
					timeDesc = "0" + (hours - 12) + timeDesc;
				}else{
						timeDesc = (hours - 12) + timeDesc;
				}
			
			} else {
				if(hours < 10){
					timeDesc = "0" + hours + timeDesc;
				}else{
					timeDesc = hours + timeDesc;
				}
			}
		} else {
			if(hours < 10){
				timeDesc = "0" + hours + timeDesc;
			}else{
				timeDesc = hours + timeDesc;
			}
		}
		
		TimeZone tz = TimeZone.getDefault();
		timeDesc = timeDesc + " " + getShortZoneName(tz);
		
		return timeDesc;
	}
	
	private void setGMTTime()
	{
        tempDate.setHours(hours);
        tempDate.setMinutes(minutes);
        GMTCal.setTime(tempDate);
	}
	
	protected void setLocalTime() {
		this.hours = GMTCal.get(Calendar.HOUR_OF_DAY);
		this.minutes = GMTCal.get(Calendar.MINUTE);
		
		
		Date date = new Date();
	    TimeZone tz = TimeZone.getDefault();
	    int rawOffset = tz.getRawOffset();
	    int hour = rawOffset / (60*60*1000);
	    int minute = Math.abs(rawOffset / (60*1000)) % 60;
	    date.setHours((hours+(hour)));
	    date.setMinutes((minutes+(minute)));
	    localCal.setTime(date);
	}
	
	public String getShortZoneName(TimeZone tz)
	{
		String shortZoneName, fullZoneName;
		
		fullZoneName = tz.getDisplayName();
		
		shortZoneName = "" + fullZoneName.charAt(0);
		for(int i=1; i<fullZoneName.length();i++)
		{
			if(("" + (fullZoneName.charAt(i))).equals(" "))
			{
				shortZoneName = shortZoneName + fullZoneName.charAt(i+1);
			}
		}
		return shortZoneName;
	}
	
	
	
}
