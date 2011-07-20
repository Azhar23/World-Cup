package com.gipl.wc2011.producer;

import java.util.Date;

import com.gipl.wc2011.core.Group;
import com.gipl.wc2011.core.Match;
import com.gipl.wc2011.core.Team;

public abstract class MatchProducer {

	public abstract Match[] getMatchSchedule();
    
    public abstract Match[] getMatchSchedule(Group group);
     
    public abstract Match[] getMatchSchedule(Team team);
      
    public abstract Match[] getMatchSchedule(Date date);
}
