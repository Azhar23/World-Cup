package com.gipl.wc2011.concrete;

import java.util.Date;
import java.util.Vector;

import android.content.Context;

import com.gipl.wc2011.core.Group;
import com.gipl.wc2011.core.Match;
import com.gipl.wc2011.core.Team;
import com.gipl.wc2011.datamanager.DataManager;
import com.gipl.wc2011.producer.MatchProducer;

public class ConcreteMatchProducer extends MatchProducer{

	Match[] matchSchedule;
	DataManager dataManager;

    public ConcreteMatchProducer(Context applicationContext) {
        dataManager = new DataManager(applicationContext);
        matchSchedule = dataManager.matchData.getMatchs();
    }

	@Override
	public Match[] getMatchSchedule() {
		// TODO Auto-generated method stub

	        return matchSchedule;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Match[] getMatchSchedule(Group group) {
		// TODO Auto-generated method stub
		Vector vector = new Vector();
		
        for (int i = 0; i < matchSchedule.length; i++) {
           if(matchSchedule[i].getGroup().getGroupID()== group.getGroupID()){
               vector.addElement(matchSchedule[i]);
           }
        }
        Match[] tempMatchSchedules = new Match[vector.size()];
        vector.copyInto(tempMatchSchedules);
        return tempMatchSchedules;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Match[] getMatchSchedule(Team team) {
		// TODO Auto-generated method stub
		Vector vector = new Vector();        
        for (int i = 0; i < matchSchedule.length; i++) {
           if(matchSchedule[i].getTeamA().getTeamID() == team.getTeamID()){
        	   vector.addElement(matchSchedule[i]);
           }
           else if(matchSchedule[i].getTeamB().getTeamID() == team.getTeamID()){
               vector.addElement(matchSchedule[i]);
           }
        }
        
        Match[] tempMatchSchedules = new Match[vector.size()];
        vector.copyInto(tempMatchSchedules);

        return tempMatchSchedules;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Match[] getMatchSchedule(Date date) {
		// TODO Auto-generated method stub
		Vector vector = new Vector();        
        for (int i = 0; i < matchSchedule.length; i++) {
//           if(date.equals(matchSchedule[i].getDate())){
//               vector.addElement(matchSchedule[i]);
//           }
        }
        
        Match[] tempMatchSchedules = new Match[vector.size()];
        vector.copyInto(tempMatchSchedules);

        return tempMatchSchedules;
	}

}
