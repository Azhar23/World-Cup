package com.gipl.wc2011.core;

public class Alarm {

	public Alarm() {
		// TODO Auto-generated constructor stub
	}

	int alarmID;
	long alarmTime;
	Match match;
	
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public int getAlarmID() {
		return alarmID;
	}

	public void setAlarmTime(long alarmTime) {
		this.alarmTime = alarmTime;
	}

	
	
	public Alarm(long alarmTime, Match match)
	{
		this.alarmTime = alarmTime;
		this.match = match;
	}
	
	public Alarm(int alarmID, long alarmTime, Match match)
	{
		this.alarmID = alarmID;
		this.alarmTime = alarmTime;
		this.match = match;
	}
	
	public void setAlarmID(int alarmID)
	{
		this.alarmID = alarmID;
	}
	
	public long getAlarmTime()
	{
		return alarmTime;
	}
	
}
