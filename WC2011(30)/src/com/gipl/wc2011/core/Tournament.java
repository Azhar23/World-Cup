package com.gipl.wc2011.core;

public class Tournament {
	
	int tournamentID;
	String description;
	
	public Tournament(String tournamentName)
	{
		this.description = tournamentName;
	}
	
	public Tournament(int tournamentID, String tournamentName)
	{
		this.tournamentID = tournamentID;
		this.description = tournamentName;
	}
	
	public void setTournamentID(int tournamentID)
	{
		this.tournamentID = tournamentID;
	}
	
	public int getTournamentID()
	{
		return tournamentID;
	}
	
	public String getTournamentName()
	{
		return description;
	}
	
}
