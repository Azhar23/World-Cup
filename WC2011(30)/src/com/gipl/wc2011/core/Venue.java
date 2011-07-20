package com.gipl.wc2011.core;

public class Venue {

	int venueID;
	String description;
	
	public Venue(String venueName)
	{
		this.description = venueName;
	}
	
	public Venue(int venueID, String venueName)
	{
		this.venueID = venueID;
		this.description = venueName;
	}
	
	public void setVenueID(int venueID)
	{
		this.venueID = venueID;
	}
	
	public int getVenueID()
	{
		return venueID;
	}
	
	public String getVenueName()
	{
		return description;
	}
	
}
