package com.gipl.wc2011.core;

public class Round{

	int roundID;
	String description;
	Tournament tournament;
	
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Round(String roundName, Tournament tournament)
	{
		this.description = roundName;
		this.tournament = tournament;
	}
	
	public Round(int roundID, String roundName, Tournament tournament)
	{
		this.roundID = roundID;
		this.description = roundName;
		this.tournament = tournament;
	}

	public Round(String roundName) {
		// TODO Auto-generated constructor stub
		this.description = roundName;
	}

	public int getRoundID() {
		return roundID;
	}

	public void setRoundID(int roundID) {
		this.roundID = roundID;
	}

	public String getRoundName() {
		return description;
	}
	
	public Tournament getTournament()
	{
		return tournament;
	}
	
}
