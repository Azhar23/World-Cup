package com.gipl.wc2011.core;

public class Match {

	int matchID;
	String description;
	Team teamA;
	Team teamB;
	long gmtTime;
	Venue venue;
	Round round;
	Group group;
	boolean isAlarmSet = false;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAlarmSet() {
		return isAlarmSet;
	}

	public void setAlarm(boolean isAlarmSet) {
		this.isAlarmSet = isAlarmSet;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public void setGmtTime(long gmtTime) {
		this.gmtTime = gmtTime;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public Match(String matchName)
	{
		this.description = matchName;
	}
	
	public Match()
	{
		
	}
	
	public Match(int matchID, String matchName, Team teamA, Team teamB, long gmtTime,
			Venue venue, Round round, Group group)
	{
		this.matchID = matchID;
		this.description = matchName;
		this.teamA = teamA;
		this.teamB = teamB;
		this.gmtTime = gmtTime;
		this.venue = venue;
		this.round = round;
		this.group = group;
	}
	
	public void setMatchID(int matchID)
	{
		this.matchID = matchID;
	}
	
	public int getMatchID()
	{
		return matchID;
	}
	
	public long getGmtTime()
	{
		return gmtTime;
	}
	
	public Team getTeamB()
	{
		return teamB;
	}
	
	public Team getTeamA()
	{
		return teamA;
	}
	
	public Venue getVenue()
	{
		return venue;
	}
	
	public Round getRound()
	{
		return round;
	}
	public Group getGroup()
	{
		return group;
	}
	
	public String getMatchName()
	{
		return description;
	}

}
