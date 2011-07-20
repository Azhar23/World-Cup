/**
 * 
 */
package com.gipl.wc2011.datamanager;


import java.util.Calendar;
import java.util.TimeZone;

import com.gipl.wc2011.core.Group;
import com.gipl.wc2011.core.Round;
import com.gipl.wc2011.core.Team;
import com.gipl.wc2011.core.Tournament;
import com.gipl.wc2011.core.Venue;

import android.content.Context;





public class StaticDataStorage {

DataManager dataManager;
	
	public StaticDataStorage(Context context) {
		
		dataManager = new DataManager(context);
		
		dataManager.tournamentData.addTournament("Cricket World Cup 2011");
		
		Tournament tournament = dataManager.tournamentData.getTournament();
		
		dataManager.roundData.addRound("Group Matches", tournament.getTournamentID());
		dataManager.roundData.addRound("Quarter Final", tournament.getTournamentID());
		dataManager.roundData.addRound("Semi Final", tournament.getTournamentID());
		dataManager.roundData.addRound("Final", tournament.getTournamentID());
		
		Round[] rounds = dataManager.roundData.getRounds();
		
		dataManager.groupData.addGroup("Group A", rounds[0].getRoundID());
		dataManager.groupData.addGroup("Group B", rounds[0].getRoundID());
		dataManager.groupData.addGroup("Dummy Group", rounds[1].getRoundID());
		dataManager.groupData.addGroup("Dummy Group", rounds[2].getRoundID());
		dataManager.groupData.addGroup("Dummy Group", rounds[3].getRoundID());
		
		Group[] group = dataManager.groupData.getGroups();
		
		dataManager.teamData.addTeam("Australia", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("Canada", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("Kenya", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("NewZealand", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("Pakistan", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("SriLanka", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("Zimbabwe", group[0].getGroupID(),false);
		
		dataManager.teamData.addTeam("India", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("SouthAfrica", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("England", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("WestIndies", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("Bangladesh", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("Netherlands", group[0].getGroupID(),false);
		dataManager.teamData.addTeam("Ireland", group[0].getGroupID(),false);
		
		dataManager.teamData.addTeam("A1",  group[2].getGroupID(),true);
		dataManager.teamData.addTeam("A2",  group[2].getGroupID(),true);
		dataManager.teamData.addTeam("A3",  group[2].getGroupID(),true);
		dataManager.teamData.addTeam("A4",  group[2].getGroupID(),true);
		
		dataManager.teamData.addTeam("B1",  group[2].getGroupID(),true);
		dataManager.teamData.addTeam("B2",  group[2].getGroupID(),true);
		dataManager.teamData.addTeam("B3",  group[2].getGroupID(),true);
		dataManager.teamData.addTeam("B4",  group[2].getGroupID(),true);
		
		dataManager.teamData.addTeam("QF1winner",  group[3].getGroupID(),true);
		dataManager.teamData.addTeam("QF2winner",  group[3].getGroupID(),true);
		dataManager.teamData.addTeam("QF3winner",  group[3].getGroupID(),true);
		dataManager.teamData.addTeam("QF4winner",  group[3].getGroupID(),true);
		
		dataManager.teamData.addTeam("SF1winner",  group[4].getGroupID(),true);
		dataManager.teamData.addTeam("SF2winner",  group[4].getGroupID(),true);
		
		Team[] teams = dataManager.teamData.getTeams();
		
		dataManager.venueData.addVenue("Shere Bangla National Stadium-Mirpur");
		dataManager.venueData.addVenue("MA Chidambaram Stadium,Chepauk-Chennai");
		dataManager.venueData.addVenue("Mahinda Rajapaksa International Cricket Stadium-Hambantota");
		dataManager.venueData.addVenue("Sardar Patel Gujarat Stadium- Motera-Ahmedabad");
		dataManager.venueData.addVenue("Vidarbha Cricket Association Ground-Nagpur");
		dataManager.venueData.addVenue("Feroz Shah Kotla-Delhi");
		dataManager.venueData.addVenue("R.Premadasa Stadium-Colombo");
		dataManager.venueData.addVenue("Eden Gardens-Kolkata");
		dataManager.venueData.addVenue("M Chinnaswamy Stadium-Bangalore");
		dataManager.venueData.addVenue("Punjab Cricket Association Stadium-Mohali");
		dataManager.venueData.addVenue("Pallekele International Cricket Stadium-Kandy");
		dataManager.venueData.addVenue("Zahur Ahmed Chowdhury Stadium-Chittagong");
		dataManager.venueData.addVenue("Wankhede Stadium-Mumbai");
	
		Venue[] venues = dataManager.venueData.getVenues();
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		//Date date = new Date();
		calendar.set(Calendar.YEAR, 2011);
		
		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 19);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("IND vs BAN", teams[7].getTeamID(), teams[11].getTeamID(), calendar.getTimeInMillis(), venues[0].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);
		
		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 20);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("NZ vs KEN", teams[3].getTeamID(), teams[2].getTeamID(), calendar.getTimeInMillis(), venues[1].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 20);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("SL vs CAN", teams[5].getTeamID(), teams[1].getTeamID(), calendar.getTimeInMillis(), venues[2].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 21);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("AUS vs ZIM", teams[0].getTeamID(), teams[6].getTeamID(),calendar.getTimeInMillis(), venues[3].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 22);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("ENG vs NED", teams[9].getTeamID(), teams[12].getTeamID(), calendar.getTimeInMillis(), venues[4].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);
	
		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("PAK vs KEN", teams[4].getTeamID(), teams[2].getTeamID(), calendar.getTimeInMillis(), venues[2].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 24);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("SA vs WI", teams[8].getTeamID(), teams[10].getTeamID(), calendar.getTimeInMillis(), venues[5].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 25);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("AUS vs NZ", teams[0].getTeamID(), teams[3].getTeamID(), calendar.getTimeInMillis(),venues[4].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 25);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("BAN vs IRE", teams[11].getTeamID(), teams[13].getTeamID(), calendar.getTimeInMillis(), venues[0].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 26);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("PAK vs SL", teams[4].getTeamID(), teams[5].getTeamID(), calendar.getTimeInMillis(), venues[6].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 27);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("IND vs ENG", teams[7].getTeamID(), teams[9].getTeamID(), calendar.getTimeInMillis(), venues[7].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 28);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("ZIM vs CAN", teams[6].getTeamID(), teams[1].getTeamID(), calendar.getTimeInMillis(), venues[4].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);
	
		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 28);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("WI vs NED", teams[10].getTeamID(), teams[12].getTeamID(), calendar.getTimeInMillis(), venues[5].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);
	
		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("SL vs KEN", teams[5].getTeamID(), teams[2].getTeamID(),calendar.getTimeInMillis(), venues[6].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);
	
		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 2);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("ENG vs IRE", teams[9].getTeamID(), teams[13].getTeamID(), calendar.getTimeInMillis(), venues[8].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);
		
		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 3);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("SA vs NED", teams[8].getTeamID(), teams[12].getTeamID(), calendar.getTimeInMillis(), venues[9].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 3);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("PAK vs CAN", teams[4].getTeamID(), teams[1].getTeamID(), calendar.getTimeInMillis(), venues[6].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 4);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("NZ vs ZIM", teams[3].getTeamID(), teams[6].getTeamID(), calendar.getTimeInMillis(), venues[3].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 4);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("BAN vs WI", teams[11].getTeamID(), teams[10].getTeamID(), calendar.getTimeInMillis(), venues[0].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 5);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("AUS vs SL", teams[0].getTeamID(), teams[5].getTeamID(), calendar.getTimeInMillis(), venues[6].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 6);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("SA vs ENG", teams[8].getTeamID(), teams[9].getTeamID(), calendar.getTimeInMillis(), venues[1].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 6);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("IND vs IRE", teams[7].getTeamID(), teams[13].getTeamID(), calendar.getTimeInMillis(), venues[8].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 7);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("CAN vs KEN", teams[1].getTeamID(), teams[2].getTeamID(), calendar.getTimeInMillis(), venues[5].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("PAK vs NZ", teams[4].getTeamID(), teams[3].getTeamID(), calendar.getTimeInMillis(), venues[10].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 9);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("IND vs NED", teams[7].getTeamID(), teams[12].getTeamID(), calendar.getTimeInMillis(), venues[5].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 10);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("SL vs ZIM", teams[5].getTeamID(), teams[6].getTeamID(), calendar.getTimeInMillis(), venues[10].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);
	
		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 11);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("WI vs IRE", teams[10].getTeamID(), teams[13].getTeamID(), calendar.getTimeInMillis(), venues[9].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);
		
		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 11);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("BAN vs ENG", teams[11].getTeamID(), teams[9].getTeamID(), calendar.getTimeInMillis(), venues[11].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 12);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("IND vs SA", teams[7].getTeamID(), teams[8].getTeamID(), calendar.getTimeInMillis(), venues[4].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 13);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("NZ vs CAN", teams[3].getTeamID(), teams[1].getTeamID(), calendar.getTimeInMillis(), venues[12].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 13);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("AUS vs KEN", teams[0].getTeamID(), teams[2].getTeamID(), calendar.getTimeInMillis(), venues[8].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 14);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("BAN vs NED", teams[11].getTeamID(), teams[12].getTeamID(), calendar.getTimeInMillis(), venues[11].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 14);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("PAK vs ZIM", teams[4].getTeamID(), teams[6].getTeamID(), calendar.getTimeInMillis(), venues[10].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("SA vs IRE", teams[8].getTeamID(), teams[13].getTeamID(), calendar.getTimeInMillis(), venues[7].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 16);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("AUS vs CAN", teams[0].getTeamID(), teams[2].getTeamID(), calendar.getTimeInMillis(), venues[8].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 17);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("ENG vs WI", teams[9].getTeamID(), teams[10].getTeamID(), calendar.getTimeInMillis(), venues[1].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 18);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("NED vs IRE", teams[12].getTeamID(), teams[13].getTeamID(), calendar.getTimeInMillis(), venues[7].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 18);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("NZ vs SL", teams[3].getTeamID(), teams[5].getTeamID(), calendar.getTimeInMillis(), venues[12].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 19);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("BAN vs SA", teams[11].getTeamID(), teams[8].getTeamID(), calendar.getTimeInMillis(), venues[0].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 19);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("AUS vs PAK", teams[0].getTeamID(), teams[4].getTeamID(), calendar.getTimeInMillis(), venues[6].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 20);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("ZIM vs KEN", teams[6].getTeamID(), teams[2].getTeamID(), calendar.getTimeInMillis(), venues[7].getVenueID(), rounds[0].getRoundID(), group[0].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 21);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("IND vs WI", teams[7].getTeamID(), teams[10].getTeamID(), calendar.getTimeInMillis(), venues[1].getVenueID(), rounds[0].getRoundID(), group[1].getGroupID(), false);


		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("A1 vs B4", teams[14].getTeamID(), teams[21].getTeamID(), calendar.getTimeInMillis(), venues[0].getVenueID(), rounds[1].getRoundID(), group[2].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 24);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("A2 vs B3", teams[15].getTeamID(), teams[20].getTeamID(), calendar.getTimeInMillis(), venues[6].getVenueID(), rounds[1].getRoundID(), group[2].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 25);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("A3 vs B2", teams[16].getTeamID(), teams[19].getTeamID(), calendar.getTimeInMillis(), venues[0].getVenueID(), rounds[1].getRoundID(), group[2].getGroupID(), false);

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 26);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("A4 vs B1", teams[17].getTeamID(), teams[18].getTeamID(), calendar.getTimeInMillis(), venues[3].getVenueID(), rounds[1].getRoundID(), group[2].getGroupID(), false);


//	
//// matches with dummy data	for semi final
//	

		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 29);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("QF1winner vs QF3winner", teams[22].getTeamID(), teams[24].getTeamID(), calendar.getTimeInMillis(), venues[6].getVenueID(), rounds[2].getRoundID(), group[3].getGroupID(), false);
		
		calendar.set(Calendar.MONTH, Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("QF2winner vs QF4winner", teams[23].getTeamID(), teams[25].getTeamID(), calendar.getTimeInMillis(), venues[9].getVenueID(), rounds[2].getRoundID(), group[3].getGroupID(), false);


//	
//// matches with dummy data	for Final

	
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		calendar.set(Calendar.DAY_OF_MONTH, 2);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 30);
		dataManager.matchData.addMatch("SF1winner vs SF2winner", teams[26].getTeamID(), teams[27].getTeamID(), calendar.getTimeInMillis(), venues[12].getVenueID(), rounds[3].getRoundID(), group[4].getGroupID(), false);


//	
}

}
