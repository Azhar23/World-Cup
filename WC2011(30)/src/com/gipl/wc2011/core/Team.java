package com.gipl.wc2011.core;

public class Team {

	int teamID;
	String description;
	Group group;
	
	public boolean isDummy() {
		return isDummy;
	}

	public void setDummy(boolean isDummy) {
		this.isDummy = isDummy;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	boolean isDummy;
	
	public Team(String teamName, Group group, boolean isDummy)
	{
		this.description = teamName;
		this.group = group;
		this.isDummy = isDummy;
	}
	
	public Team()
	{
		
	}
	
	public Team(int teamID, String teamName, Group group)
	{
		this.teamID = teamID;
		this.description = teamName;
		this.group = group;
	}
	
	public Team(String teamName) {
		// TODO Auto-generated constructor stub
		this.description = teamName;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	
	public Group getGroup() {
		return group;
	}

	public String getTeamName() {
		return description;
	}


}
