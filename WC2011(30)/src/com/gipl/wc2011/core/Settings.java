package com.gipl.wc2011.core;

public class Settings {
	
	Team homeTeam = null;
	String notify;
	
	public Settings()
	{
	}
	
	public void setHomeTeam(Team homeTeam)
	{
		this.homeTeam = homeTeam;
	}
	
	public Team getHomeTeam()
	{
		return homeTeam;
	}
	
	public void setNotify(String notify)
	{
		this.notify = notify;
	}
	
	public String getNotify()
	{
		return notify;
	}

}
