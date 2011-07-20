package com.gipl.wc2011.core;

public class Group {

	int groupID;
	String description;
	Round round;
	
	public void setRound(Round round) {
		this.round = round;
	}

	public Group(String groupName, Round round)
	{
		this.description = groupName;
		this.round = round;
	}
	
	public Group(int groupID, String groupName, Round round)
	{
		this.groupID = groupID;
		this.description = groupName;
		this.round = round;
	}
	
	public Group() {
		// TODO Auto-generated constructor stub
	}

	public Group(String groupName) {
		// TODO Auto-generated constructor stub
		this.description = groupName;
	}

	public int getGroupID() {
		return groupID;
	}

	public Round getRound()
	{
		return round;
	}
	
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return description;
	}
	

}
