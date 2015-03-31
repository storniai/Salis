package example.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import example.com.entity.BaseEvent;
import example.com.entity.GoalEvent;
import example.com.entity.Match;
import example.com.entity.PenaltyEvent;
import example.com.entity.Player;

public class MetaDataSetter {

	public static BaseEvent getEvent(ResultSet rs) throws SQLException {
		BaseEvent event;
		String type = rs.getString("type");
		if(GoalEvent.EVENT_TYPE.equals(type)) {
			event = new GoalEvent();
			String goalPlayerId = rs.getString("goal_playerid");
			String goalPlayerName = rs.getString("goal_playername");
			String assistPlayerId = rs.getString("assist_playerid");
			String assistPlayerName = rs.getString("assist_playername");
			
			((GoalEvent)event).setGoalPlayerId(goalPlayerId);
			((GoalEvent)event).setGoalPlayerName(goalPlayerName);
			((GoalEvent)event).setAssistPlayerId(assistPlayerId);
			((GoalEvent)event).setAssistPlayerName(assistPlayerName);
			
		} else if(PenaltyEvent.EVENT_TYPE.equals(type)) {
			event = new PenaltyEvent();
			String penaltyPlayerId = rs.getString("penalty_playerid");
			String penaltyPlayerName = rs.getString("penalty_playername");
			Integer penaltyTimeMinutes = rs.getInt("penalty_time_min");
			
			((PenaltyEvent)event).setPenaltyPlayerId(penaltyPlayerId);
			((PenaltyEvent)event).setPenaltyPlayerName(penaltyPlayerName);
			((PenaltyEvent)event).setPenaltyTimeMinutes(penaltyTimeMinutes);
		} else {
			event = new BaseEvent();
		}
		String id =  rs.getString("id");
		Integer matchId = rs.getInt("match_id");
		String comment = rs.getString("comment");
		Integer period = rs.getInt("period");
		Integer minutes = rs.getInt("minutes");
		Integer seconds = rs.getInt("seconds");
		boolean myEvent = rs.getBoolean("my_event");
		
		event.setType(type);
		event.setId(id);
		event.setMatchId(matchId);
		event.setComment(comment);
		event.setPeriod(period);
		event.setMinutes(minutes);
		event.setSeconds(seconds);
		event.setMyEvent(myEvent);
		return event;
	}
	
	public static Player getPlayer(ResultSet rs) throws SQLException {
		Player player = new Player();
		player.setId(rs.getInt("id"));
		player.setFirstname(rs.getString("first_name"));
		player.setLastname(rs.getString("last_name"));
		player.setPosition(rs.getString("position"));
		player.setActive(rs.getBoolean("active"));
		player.setNumber(rs.getInt("number"));
		player.setTeamid(rs.getInt("team_id"));
		return player;
	}
	
	@SuppressWarnings("deprecation")
	public static Match getMatch(ResultSet rs) throws SQLException {
		Match match = new Match();
		Integer matchId = rs.getInt("id");
		String homeTeam = rs.getString("home_team");
		String visitorTeam = rs.getString("visitor_team");
		String location = rs.getString("location");
		Date date = rs.getDate("date");
		Integer seasonId = rs.getInt("season_id");
		Integer homeGoals = rs.getInt("goals_home");
		Integer visitorGoals = rs.getInt("goals_visitor");
		System.out.println("Get match: "+matchId+","+homeTeam
				+","+visitorTeam+","+location+","+date.toLocaleString()
				+","+seasonId+","+homeGoals+","+visitorGoals);
		match.setId(matchId);
		match.setHomeTeam(homeTeam);
		match.setVisitorTeam(visitorTeam);
		match.setDate(date);
		match.setSeasonId(seasonId);
		match.setHomeGoals(homeGoals);
		match.setVisitorGoals(visitorGoals);
		return match;
	}
	
}
