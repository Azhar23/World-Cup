package com.gipl.wc2011.datamanager;

import com.gipl.wc2011.core.Alarm;
import com.gipl.wc2011.core.Group;
import com.gipl.wc2011.core.Match;
import com.gipl.wc2011.core.Round;
import com.gipl.wc2011.core.Settings;
import com.gipl.wc2011.core.Team;
import com.gipl.wc2011.core.Tournament;
import com.gipl.wc2011.core.Venue;

import android.R.bool;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DataManager extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "dbZazu.db";
	private static final int DATABASE_VERSION = 1 ;
	
	public TournamentData tournamentData = new TournamentData(this);
	public AlarmData alarmData = new AlarmData(this);
	public GroupData groupData = new GroupData(this);
	public MatchData matchData = new MatchData(this);
	public RoundData roundData = new RoundData(this);
	public SettingsData settingsData = new SettingsData(this);
	public TeamData teamData = new TeamData(this);
	public VenueData venueData = new VenueData(this);
	
	public DataManager(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		tournamentData.createTable(db);
		alarmData.createTable(db);
		groupData.createTable(db);
		matchData.createTable(db);
		roundData.createTable(db);
		settingsData.createTable(db);
		teamData.createTable(db);
		venueData.createTable(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		// TODO Auto-generated method stub
		tournamentData.upgradeTable(db);
		alarmData.upgradeTable(db);
		groupData.upgradeTable(db);
		matchData.upgradeTable(db);
		roundData.upgradeTable(db);
		settingsData.upgradeTable(db);
		teamData.upgradeTable(db);
		venueData.upgradeTable(db);
	}
	
	public class TournamentData {


		private static final String TB_TOURNAMENT = "tbTournament";
		private SQLiteOpenHelper helper;
		private SQLiteDatabase db;	
		
		public TournamentData(SQLiteOpenHelper helper) {
			this.helper = helper;
			
		}
		
		public void createTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createTableCommand;
			createTableCommand = "CREATE TABLE " + TB_TOURNAMENT  +
								 "(" + 
								 "tournamentID INTEGER PRIMARY KEY," +
								 "tournamentName varchar(20)" +
								 ")";
				
			db.execSQL(createTableCommand) ;
		}

		public void upgradeTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TB_TOURNAMENT);
			createTable(db);
		}

		public void addTournament(String tournamentName){
			db= helper.getWritableDatabase();
			SQLiteStatement insertStmt = db.compileStatement("insert into "
					+ TB_TOURNAMENT + " (tournamentName) values ('" + tournamentName + "')");
			insertStmt.executeInsert();
		}

		public Tournament getTournament()
		{
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_TOURNAMENT, null, null, null, null, null, null);
			Tournament tournament;
			
			if(cursor.moveToFirst())
			{
					tournament = new Tournament(cursor.getString(cursor.getColumnIndex("tournamentName")));
					tournament.setTournamentID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("tournamentID"))));
	    	}
			else
			{
				return null;
			}
				
			if (cursor != null && !cursor.isClosed())
			{
				cursor.close();
			}
			
			return tournament;
		}
		
		public Tournament getTournament(int tournamentID)
		{
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_TOURNAMENT, null, "tournamentID = " + tournamentID, null, null, null, null);
			Tournament tournament;
			
			if(cursor.moveToFirst())
			{
					tournament = new Tournament(cursor.getString(cursor.getColumnIndex("tournamentName")));
					tournament.setTournamentID(tournamentID);
	    	}
			else
			{
				return null;
			}
				
			if (cursor != null && !cursor.isClosed())
			{
				cursor.close();
			}
			
			return tournament;
		}
			
		public void deleteTournament()
		{
			db= helper.getWritableDatabase();
			db.delete(TB_TOURNAMENT, null, null);
		}
	}
	
	public class GroupData {
		
		private static final String TB_GROUP = "tbGroup";
		private SQLiteOpenHelper helper;
		private SQLiteDatabase db;	
		
		public GroupData(SQLiteOpenHelper helper) {
			this.helper = helper;
			
		}
		
		public void createTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createTableCommand;
			createTableCommand = "CREATE TABLE " + TB_GROUP  +
								 "(" + 
								 "GroupID INTEGER PRIMARY KEY," +
								 "groupName varchar(20)," +
								 "roundID INTEGER REFERENCES tbRound(roundID)" +
								 ")";
				
			db.execSQL(createTableCommand) ;
		}

		public void upgradeTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TB_GROUP);
			createTable(db);
		}

		public void addGroup(String groupName, int roundID){
			db= helper.getWritableDatabase();
			SQLiteStatement insertStmt = db.compileStatement("insert into "
					+ TB_GROUP + " (groupName, roundID) values ('" + groupName + "', " +
							roundID + ")");
			insertStmt.executeInsert();
		}
		
		@SuppressWarnings("null")
		public Group[] getGroups()
		{
			Group[] groups = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_GROUP, null, null, null, null, null, "groupName asc");
			
			if(cursor.moveToFirst())
			{
				int index = 0;
				do
				{
					groups[index] = new Group(cursor.getString(cursor.getColumnIndex("groupName")));
					groups[index].setGroupID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("groupID"))));
					int roundID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("roundID")));
					RoundData round = new RoundData(helper);
					groups[index].setRound(round.getRound(roundID));
					index++;
				}while(cursor.moveToNext());
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return groups;
		}
		
		public Group getGroup(int groupID)
		{
			Group group = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_GROUP, null, "groupID = " + groupID, null, null, null, null);
			
			if(cursor.moveToFirst())
			{
					group = new Group(cursor.getString(cursor.getColumnIndex("groupName")));
					group.setGroupID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("groupID"))));
					int roundID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("roundID")));
					RoundData round = new RoundData(helper);
					group.setRound(round.getRound(roundID));		
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return group;
		}
			
		public void deleteGroup()
		{
			db= helper.getWritableDatabase();
			db.delete(TB_GROUP, null, null);
		}
	}
	
	public class RoundData {
		
		private static final String TB_ROUND = "tbRound";
		private SQLiteOpenHelper helper;
		private SQLiteDatabase db;	
		
		public RoundData(SQLiteOpenHelper helper) {
			this.helper = helper;	
		}
		
		public void createTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createTableCommand;
			createTableCommand = "CREATE TABLE " + TB_ROUND  +
								 "(" + 
								 "roundID INTEGER PRIMARY KEY," +
								 "roundName varchar(20)," +
								 "tournamentID INTEGER REFERENCES tbTournament(tournamentID)" +
								 ")";
				
			db.execSQL(createTableCommand) ;
		}

		public void upgradeTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TB_ROUND);
			createTable(db);
		}

		public void addRound(String roundName, int tournamentID){
			db= helper.getWritableDatabase();
			SQLiteStatement insertStmt = db.compileStatement("insert into "
					+ TB_ROUND + " (roundName, tournamentID) values ('" + roundName + "', " +
							tournamentID + ")");
			insertStmt.executeInsert();
		}
		
		@SuppressWarnings("null")
		public Round[] getRounds()
		{
			Round[] rounds = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_ROUND, null, null, null, null, null, "roundName asc");
			
			if(cursor.moveToFirst())
			{
				int index = 0;
				do
				{
					rounds[index] = new Round(cursor.getString(cursor.getColumnIndex("roundName")));
					rounds[index].setRoundID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("roundID"))));
					int tournamentID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("tournamentID")));
					TournamentData tournament = new TournamentData(helper);
					rounds[index].setTournament(tournament.getTournament(tournamentID));
					index++;
				}while(cursor.moveToNext());
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return rounds;
		}
		
		
		public Round getRound(int roundID)
		{
			Round round = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_ROUND, null, "roundID = " + roundID, null, null, null, null);
			
			if(cursor.moveToFirst())
			{
				
					round = new Round(cursor.getString(cursor.getColumnIndex("roundName")));
					round.setRoundID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("roundID"))));
					int tournamentID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("tournamentID")));
					TournamentData tournament = new TournamentData(helper);
					round.setTournament(tournament.getTournament(tournamentID));
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return round;
		}
			
		public void deleteRound()
		{
			db= helper.getWritableDatabase();
			db.delete(TB_ROUND, null, null);
		}
	}
	
	public class VenueData {


		private static final String TB_VENUE = "tbVenue";
		private SQLiteOpenHelper helper;
		private SQLiteDatabase db;	
		
		public VenueData(SQLiteOpenHelper helper) {
			this.helper = helper;
			
		}
		
		public void createTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createTableCommand;
			createTableCommand = "CREATE TABLE " + TB_VENUE  +
								 "(" + 
								 "venueID INTEGER PRIMARY KEY," +
								 "venueName varchar(20)" +
								 ")";
				
			db.execSQL(createTableCommand) ;
		}

		public void upgradeTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TB_VENUE);
			createTable(db);
		}

		public void addVenue(String venueName){
			db= helper.getWritableDatabase();
			SQLiteStatement insertStmt = db.compileStatement("insert into "
					+ TB_VENUE + " (venueName) values ('" + venueName + "')");
			insertStmt.executeInsert();
		}

		@SuppressWarnings("null")
		public Venue[] getVenues()
		{
			Venue[] venues = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_VENUE, null, null, null, null, null, null);
		
			if(cursor.moveToFirst())
			{
				int index =0;
				do
				{
					venues[index] = new Venue(cursor.getString(cursor.getColumnIndex("venueName")));
					venues[index].setVenueID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("venueID"))));
				}while(cursor.moveToNext());
				
	    	}
			else
			{
				return null;
			}
				
			if (cursor != null && !cursor.isClosed())
			{
				cursor.close();
			}
			
			return venues;
		}
		
		public Venue getVenue(int venueID)
		{
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_VENUE, null, "venueID = " + venueID, null, null, null, null);
Venue venue;
			
			if(cursor.moveToFirst())
			{
					venue = new Venue(cursor.getString(cursor.getColumnIndex("venueName")));
					venue.setVenueID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("venueID"))));
	    	}
			else
			{
				return null;
			}
				
			if (cursor != null && !cursor.isClosed())
			{
				cursor.close();
			}
			
			return venue;
		}
			
		public void deleteVenue()
		{
			db= helper.getWritableDatabase();
			db.delete(TB_VENUE, null, null);
		}
	}
	
	public class TeamData {
		
		private static final String TB_TEAM = "tbTeam";
		private SQLiteOpenHelper helper;
		private SQLiteDatabase db;	
		
		public TeamData(SQLiteOpenHelper helper) {
			this.helper = helper;	
		}
		
		public void createTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createTableCommand;
			createTableCommand = "CREATE TABLE " + TB_TEAM  +
								 "(" + 
								 "teamID INTEGER PRIMARY KEY," +
								 "teamName varchar(20)," +
								 "isDummy BOOLEAN," +
								 "groupID INTEGER REFERENCES tbGroup(groupID)" +
								 ")";
				
			db.execSQL(createTableCommand) ;
		}

		public void upgradeTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TB_TEAM);
			createTable(db);
		}

		public void addTeam(String teamName, int groupID, boolean isDummy){
			db= helper.getWritableDatabase();
			SQLiteStatement insertStmt = db.compileStatement("insert into "
					+ TB_TEAM + " (teamName, groupID, isDummy) values ('" + teamName + "', " +
							groupID + ", " + isDummy + ")");
			insertStmt.executeInsert();
		}
		
		@SuppressWarnings("null")
		public Team[] getTeams()
		{
			Team[] teams = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_TEAM, null, null, null, null, null, "teamName asc");
			
			if(cursor.moveToFirst())
			{
				int index = 0;
				do
				{
					teams[index] = new Team(cursor.getString(cursor.getColumnIndex("teamName")));
					teams[index].setTeamID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("teamID"))));
					int groupID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("groupID")));
					GroupData group = new GroupData(helper);
					teams[index].setGroup(group.getGroup(groupID));
					index++;
				}while(cursor.moveToNext());
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return teams;
		}
		
		
		public Team getTeam(int teamID)
		{
			Team team = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_TEAM, null, "teamID = " + teamID, null, null, null, null);
			
			if(cursor.moveToFirst())
			{
				team = new Team(cursor.getString(cursor.getColumnIndex("teamName")));
				team.setTeamID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("teamID"))));
				int groupID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("groupID")));
				GroupData group = new GroupData(helper);
				team.setGroup(group.getGroup(groupID));
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return team;
		}
			
		public void deleteTeam()
		{
			db= helper.getWritableDatabase();
			db.delete(TB_TEAM, null, null);
		}
	}
	
	public class SettingsData {


		private static final String TB_SETTINGS = "tbSettings";
		private SQLiteOpenHelper helper;
		private SQLiteDatabase db;	
		
		public SettingsData(SQLiteOpenHelper helper) {
			this.helper = helper;
			
		}
		
		public void createTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createTableCommand;
			createTableCommand = "CREATE TABLE " + TB_SETTINGS  +
								 "(" + 
								 "homeTeamID INTEGER," +
								 "notify varchar(20)" +
								 ")";
				
			db.execSQL(createTableCommand) ;
		}

		public void upgradeTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TB_SETTINGS);
			createTable(db);
		}

		public void addSettings(int homeTeamID, String notify){
			db= helper.getWritableDatabase();
			SQLiteStatement insertStmt = db.compileStatement("insert into "
					+ TB_SETTINGS + " (homeTeamID, notify) values (" + homeTeamID + ", '" + notify + "')");
			insertStmt.executeInsert();
		}

		public Settings getSettings	()
		{
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_SETTINGS, null, null, null, null, null, null);
			Settings settings;
			
			if(cursor.moveToFirst())
			{
				settings = new Settings();
				settings.setNotify(cursor.getString(cursor.getColumnIndex("notify")));
				int homeTeamID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("homeTeamID")));
				TeamData team = new TeamData(helper);
				settings.setHomeTeam(team.getTeam(homeTeamID));
	    	}
			else
			{
				return null;
			}
				
			if (cursor != null && !cursor.isClosed())
			{
				cursor.close();
			}
			
			return settings;
		}
		
			
		public void deleteSettings()
		{
			db= helper.getWritableDatabase();
			db.delete(TB_SETTINGS, null, null);
		}
	}
	
	public class MatchData {
		
		private static final String TB_MATCH = "tbMatch";
		private SQLiteOpenHelper helper;
		private SQLiteDatabase db;	
		
		public MatchData(SQLiteOpenHelper helper) {
			this.helper = helper;	
		}
		
		public void createTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createTableCommand;
			createTableCommand = "CREATE TABLE " + TB_MATCH +
								 "(" + 
								 "matchID INTEGER PRIMARY KEY," +
								 "matchName varchar(20)," +
								 "teamAID INTEGER REFERENCES tbTeam(teamID)," +
								 "teamBID INTEGER REFERENCES tbTeam(teamID)," +
								 "time NUMERIC," +
								 "venueID INTEGER REFERENCES tbVenue(venueID)," +
								 "roundID INTEGER REFERENCES tbRound(roundID)," +
								 "groupID INTEGER REFERENCES tbGroup(groupID)," +
								 "isAlarmSet BOOLEAN" +
								 ")";
				
			db.execSQL(createTableCommand) ;
		}

		public void upgradeTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TB_MATCH);
			createTable(db);
		}

		public void addMatch(String matchName, int teamAID, int teamBID, long time,int venueID,
				int roundID, int groupID, boolean isAlarmset){
			db= helper.getWritableDatabase();
			SQLiteStatement insertStmt = db.compileStatement("insert into "
					+ TB_MATCH + " (matchName, teamAID, teamBID, time, date, venueID, " +
							"roundID, groupID, isAlarmSet) values ('" + matchName + "', " +
							teamAID + "," +
							teamBID + "," +
							time + "," +
							venueID + "," +
							roundID + "," +
							groupID + "," +
							isAlarmset + ")");
			insertStmt.executeInsert();
		}
		
//		public void updateAlarmStatus(Match match){
//			if match.isAlarmSet
//			db = helper.getWritableDatabase();
//			SQLiteStatement updateStmt = db.compileStatement(" update TB_MATCH set isAlarmSet = true where matchID = " + match.getMatchID());
//			updateStmt.execute();
//		}
		
		@SuppressWarnings("null")
		public Match[] getMatchs()
		{
			Match[] matchs = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_MATCH, null, null, null, null, null, "matchName asc");
			
			if(cursor.moveToFirst())
			{
				int index = 0;
				do
				{
					matchs[index] = new Match(cursor.getString(cursor.getColumnIndex("matchName")));
					matchs[index].setMatchID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("matchID"))));
					int teamAID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("teamAID")));
					TeamData teamA = new TeamData(helper);
					matchs[index].setTeamA(teamA.getTeam(teamAID));
					int teamBID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("teamBID")));
					TeamData teamB = new TeamData(helper);
					matchs[index].setTeamB(teamB.getTeam(teamBID));
					matchs[index].setGmtTime(Long.parseLong(cursor.getString(cursor.getColumnIndex("time"))));
					int venueID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("venueID")));
					VenueData venue = new VenueData(helper);
					matchs[index].setVenue(venue.getVenue(venueID));
					int roundID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("roundID")));
					RoundData round = new RoundData(helper);
					matchs[index].setRound(round.getRound(roundID));
					int groupID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("groupID")));
					GroupData group = new GroupData(helper);
					matchs[index].setGroup(group.getGroup(groupID));
					matchs[index].setAlarm(Boolean.getBoolean(cursor.getString(cursor.getColumnIndex("isAlarmSet"))));
					index++;
				}while(cursor.moveToNext());
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return matchs;
		}
		
		
		public Match getMatch(int matchID)
		{
			Match match = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_MATCH, null, "matchID = " + matchID, null, null, null, null);
			
			if(cursor.moveToFirst())
			{
				match = new Match(cursor.getString(cursor.getColumnIndex("matchName")));
				match.setMatchID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("matchID"))));
				int teamAID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("teamAID")));
				TeamData teamA = new TeamData(helper);
				match.setTeamA(teamA.getTeam(teamAID));
				int teamBID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("teamBID")));
				TeamData teamB = new TeamData(helper);
				match.setTeamB(teamB.getTeam(teamBID));
				match.setGmtTime(Long.parseLong(cursor.getString(cursor.getColumnIndex("time"))));
				int venueID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("venueID")));
				VenueData venue = new VenueData(helper);
				match.setVenue(venue.getVenue(venueID));
				int roundID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("roundID")));
				RoundData round = new RoundData(helper);
				match.setRound(round.getRound(roundID));
				int groupID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("groupID")));
				GroupData group = new GroupData(helper);
				match.setGroup(group.getGroup(groupID));
				match.setAlarm(Boolean.getBoolean(cursor.getString(cursor.getColumnIndex("isAlarmSet"))));
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return match;
		}
			
		public void deleteMatch()
		{
			db= helper.getWritableDatabase();
			db.delete(TB_MATCH, null, null);
		}
	}
	
public class AlarmData {
		
		private static final String TB_ALARM = "tbAlarm";
		private SQLiteOpenHelper helper;
		private SQLiteDatabase db;	
		
		public AlarmData(SQLiteOpenHelper helper) {
			this.helper = helper;	
		}
		
		public void createTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createTableCommand;
			createTableCommand = "CREATE TABLE " + TB_ALARM  +
								 "(" + 
								 "alarmID INTEGER PRIMARY KEY," +
								 "time NUMERIC," +
								 "matchID INTEGER REFERENCES tbMatch(tournamentID)" +
								 ")";
				
			db.execSQL(createTableCommand) ;
		}

		public void upgradeTable(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TB_ALARM);
			createTable(db);
		}

		public void addAlarm(long time, int matchID){
			db= helper.getWritableDatabase();
			SQLiteStatement insertStmt = db.compileStatement("insert into "
					+ TB_ALARM + " (time, matchID) values (" + time + ", " +
							matchID + ")");
			insertStmt.executeInsert();
		}
		
		@SuppressWarnings("null")
		public Alarm[] getAlarms()
		{
			Alarm[] alarms = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_ALARM, null, null, null, null, null, "time asc");
			
			if(cursor.moveToFirst())
			{
				int index = 0;
				do
				{
					alarms[index] = new Alarm();
					alarms[index].setAlarmTime(Long.parseLong(cursor.getString(cursor.getColumnIndex("time"))));
					int matchID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("matchID")));
					MatchData match = new MatchData(helper);
					alarms[index].setMatch(match.getMatch(matchID));
					index++;
				}while(cursor.moveToNext());
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return alarms;
		}
		
		
		public Alarm getAlarm(int alarmID)
		{
			Alarm alarm = null;
			db = helper.getReadableDatabase();
			Cursor cursor = db.query(TB_ALARM, null, "alarmID = " + alarmID, null, null, null, null);
			
			if(cursor.moveToFirst())
			{
				
				alarm = new Alarm();
				alarm.setAlarmTime(Long.parseLong(cursor.getString(cursor.getColumnIndex("time"))));
				int matchID = Integer.parseInt(cursor.getString(cursor.getColumnIndex("matchID")));
				MatchData match = new MatchData(helper);
				alarm.setMatch(match.getMatch(matchID));
			}
			else
			{
				return null;
			}
				if (cursor != null && !cursor.isClosed())
				{
					cursor.close();
				}
				
				return alarm;
		}
			
		public void deleteAlarm()
		{
			db= helper.getWritableDatabase();
			db.delete(TB_ALARM, null, null);
		}
	}

}
