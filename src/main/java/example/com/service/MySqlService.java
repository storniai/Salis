package example.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import example.com.entity.BaseEvent;
import example.com.entity.GoalEvent;
import example.com.entity.Match;
import example.com.entity.PenaltyEvent;
import example.com.entity.Player;

public class MySqlService {
	
	public int createNewMatch(Date datetime, String homeTeam, String visitorTeam, int seasonId, String location) {
		Integer retval = -1;
		PreparedStatement pstmt;
		String sql = " insert into matches (date, home_team, visitor_team, season_id, location)"
		        + " values (?, ?, ?, ?, ?)";
		Integer num;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    pstmt.setDate (1, new java.sql.Date(new Date().getTime()));
		    pstmt.setString (2, homeTeam);
		    pstmt.setString   (3, visitorTeam);
		    pstmt.setInt    (4, seasonId);
		    pstmt.setString   (5, location);
		    num = pstmt.executeUpdate();
		    System.out.println("output value =>" + num);
		    ResultSet rs = pstmt.getGeneratedKeys();
		    if(rs.next())
		    	retval=rs.getInt(1);
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	public List<Match> getMatches() {
		List<Match> retval = new ArrayList<Match>();
		PreparedStatement pstmt;
		String sql = "select * from matches";
		ResultSet rs;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				Match match = MetaDataSetter.getMatch(rs);
				retval.add(match);
			} 
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	
	public Match getMatch(int id) {
		Match match = null;
		PreparedStatement pstmt;
		String sql = "select * from matches where id = ?";
		ResultSet rs;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return new Match();
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				match = MetaDataSetter.getMatch(rs);
			} 
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return new Match();
		}
		dbConnectionPool.destroy();
		return match;
	}
	
	public void createNewEvent(BaseEvent event) {
		if(event instanceof GoalEvent) {
			createNewGoalEvent((GoalEvent) event);
		}
		else if(event instanceof PenaltyEvent){
			createNewPenaltyEvent((PenaltyEvent)event);
		} else {
			createNewBaseEvent(event);
		}
	}
	
	private int createNewPenaltyEvent(PenaltyEvent event) {
		Integer retval = -1;
		PreparedStatement pstmt;
		String sql = " insert into event (type, match_id, penalty_playerid, penalty_playername, "
				+ "penalty_time_min, comment, period, minutes, seconds, my_event)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Integer num;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, event.getType());
			pstmt.setInt(2, event.getMatchId());
			pstmt.setString(3, event.getPenaltyPlayerId());
			pstmt.setString(4, event.getPenaltyPlayerName());
			pstmt.setInt(5, event.getPenaltyTimeMinutes());
			pstmt.setString(6, event.getComment());
			pstmt.setInt(7, event.getPeriod());
			pstmt.setInt(8, event.getMinutes());
			pstmt.setInt(9, event.getSeconds());
			pstmt.setBoolean(10, event.isMyEvent());
		    num = pstmt.executeUpdate();
		    System.out.println("New penalty event created =>" + num);
		    ResultSet rs = pstmt.getGeneratedKeys();
		    if(rs.next())
		    	retval=rs.getInt(1);
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	
	private int createNewGoalEvent(GoalEvent event) {
		Integer retval = -1;
		PreparedStatement pstmt;
		String sql = " insert into event (type, match_id, goal_playerid, goal_playername, "
				+ "assist_playerid, assist_playername, comment, period, minutes, seconds, my_event)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Integer num;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, event.getType());
			pstmt.setInt(2, event.getMatchId());
			pstmt.setString(3, event.getGoalPlayerId());
			pstmt.setString(4, event.getGoalPlayerName());
			pstmt.setString(5, event.getAssistPlayerId());
			pstmt.setString(6, event.getAssistPlayerName());
			pstmt.setString(7, event.getComment());
			pstmt.setInt(8, event.getPeriod());
			pstmt.setInt(9, event.getMinutes());
			pstmt.setInt(10, event.getSeconds());
			pstmt.setBoolean(11, event.isMyEvent());
		    num = pstmt.executeUpdate();
		    System.out.println("New goal event created =>" + num);
		    ResultSet rs = pstmt.getGeneratedKeys();
		    if(rs.next())
		    	retval=rs.getInt(1);
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	
	private int createNewBaseEvent(BaseEvent event) {
		Integer retval = -1;
		PreparedStatement pstmt;
		String sql = " insert into event (type, match_id, "
				+ "comment, period, minutes, seconds, my_event)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Integer num;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, event.getType());
			pstmt.setInt(2, event.getMatchId());
			pstmt.setString(3, event.getComment());
			pstmt.setInt(4, event.getPeriod());
			pstmt.setInt(5, event.getMinutes());
			pstmt.setInt(6, event.getSeconds());
			pstmt.setBoolean(7, event.isMyEvent());
		    num = pstmt.executeUpdate();
		    System.out.println("New base event created =>" + num);
		    ResultSet rs = pstmt.getGeneratedKeys();
		    if(rs.next())
		    	retval=rs.getInt(1);
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	
	public List<BaseEvent> getMatchEvents(Integer matchId) {
		List<BaseEvent> retval = new ArrayList<BaseEvent>();
		PreparedStatement pstmt;
		String sql = "select * from event where match_id = ?";
		ResultSet rs;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, matchId);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				BaseEvent event = MetaDataSetter.getEvent(rs);
				System.out.println("Get event =>" + event.getType());
				retval.add(event);
			} 
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	
//	private BaseEvent getEvent(ResultSet rs) throws SQLException {
//		BaseEvent event;
//		String type = rs.getString("type");
//		if(GoalEvent.EVENT_TYPE.equals(type)) {
//			event = new GoalEvent();
//			String goalPlayerId = rs.getString("goal_playerid");
//			String goalPlayerName = rs.getString("goal_playername");
//			String assistPlayerId = rs.getString("assist_playerid");
//			String assistPlayerName = rs.getString("assist_playername");
//			
//			((GoalEvent)event).setGoalPlayerId(goalPlayerId);
//			((GoalEvent)event).setGoalPlayerName(goalPlayerName);
//			((GoalEvent)event).setAssistPlayerId(assistPlayerId);
//			((GoalEvent)event).setAssistPlayerName(assistPlayerName);
//			
//		} else if(PenaltyEvent.EVENT_TYPE.equals(type)) {
//			event = new PenaltyEvent();
//			String penaltyPlayerId = rs.getString("penalty_playerid");
//			String penaltyPlayerName = rs.getString("penalty_playername");
//			Integer penaltyTimeMinutes = rs.getInt("penalty_time_min");
//			
//			((PenaltyEvent)event).setPenaltyPlayerId(penaltyPlayerId);
//			((PenaltyEvent)event).setPenaltyPlayerName(penaltyPlayerName);
//			((PenaltyEvent)event).setPenaltyTimeMinutes(penaltyTimeMinutes);
//		} else {
//			event = new BaseEvent();
//		}
//		String id =  rs.getString("id");
//		Integer matchId = rs.getInt("match_id");
//		String comment = rs.getString("comment");
//		Integer period = rs.getInt("period");
//		Integer minutes = rs.getInt("minutes");
//		Integer seconds = rs.getInt("seconds");
//		boolean myEvent = rs.getBoolean("my_event");
//		
//		event.setType(type);
//		event.setId(id);
//		event.setMatchId(matchId);
//		event.setComment(comment);
//		event.setPeriod(period);
//		event.setMinutes(minutes);
//		event.setSeconds(seconds);
//		event.setMyEvent(myEvent);
//		return event;
//	}
	
	public int createNewPlayer(Player player) {
		Integer retval = -1;
		PreparedStatement pstmt;
		String sql = " insert into players (first_name, last_name, number, position, active, team_id)"
		        + " values (?, ?, ?, ?, ?, ?)";
		Integer num;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    pstmt.setString(1, player.getFirstname());
		    pstmt.setString (2, player.getLastname());
		    pstmt.setInt(3, player.getNumber());
		    pstmt.setString(4, player.getPosition());
		    pstmt.setBoolean(5, player.isActive());
		    pstmt.setInt(6, player.getTeamid());
		    num = pstmt.executeUpdate();
		    System.out.println("Create new player =>" + num);
		    ResultSet rs = pstmt.getGeneratedKeys();
		    if(rs.next())
		    	retval=rs.getInt(1);
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	
	public List<Player> getPlayers(Integer teamId) {
		List<Player> retval = new ArrayList<Player>();
		PreparedStatement pstmt;
		String sql = "select * from players where team_id = ?";
		ResultSet rs;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teamId);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				Player player = MetaDataSetter.getPlayer(rs);
				System.out.println("Get Players from team =>" + teamId);
				retval.add(player);
			} 
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	
//	private Player getPlayer(ResultSet rs) throws SQLException {
//		Player player = new Player();
//		player.setId(rs.getInt("id"));
//		player.setFirstname(rs.getString("first_name"));
//		player.setLastname(rs.getString("last_name"));
//		player.setPosition(rs.getString("position"));
//		player.setActive(rs.getBoolean("active"));
//		player.setNumber(rs.getInt("number"));
//		player.setTeamid(rs.getInt("team_id"));
//		return player;
//	}
	
	public List<Player> getActivePlayers(Integer teamId) {
		List<Player> retval = new ArrayList<Player>();
		PreparedStatement pstmt;
		String sql = "select * from players where active = true and team_id = ?";
		ResultSet rs;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teamId);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				Player player = MetaDataSetter.getPlayer(rs);
				System.out.println("Get active Players from team =>" + teamId);
				retval.add(player);
			} 
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	
//	@SuppressWarnings("deprecation")
//	private Match getMatch(ResultSet rs) throws SQLException {
//		Match match = new Match();
//		Integer matchId = rs.getInt("id");
//		String homeTeam = rs.getString("home_team");
//		String visitorTeam = rs.getString("visitor_team");
//		String location = rs.getString("location");
//		Date date = rs.getDate("date");
//		Integer seasonId = rs.getInt("season_id");
//		Integer homeGoals = rs.getInt("goals_home");
//		Integer visitorGoals = rs.getInt("goals_visitor");
//		System.out.println("Get match: "+matchId+","+homeTeam
//				+","+visitorTeam+","+location+","+date.toLocaleString()
//				+","+seasonId+","+homeGoals+","+visitorGoals);
//		match.setId(matchId);
//		match.setHomeTeam(homeTeam);
//		match.setVisitorTeam(visitorTeam);
//		match.setDate(date);
//		match.setSeasonId(seasonId);
//		match.setHomeGoals(homeGoals);
//		match.setVisitorGoals(visitorGoals);
//		return match;
//	}
	
	public int addGoal(int matchId, boolean isHomeTeamGoal) {
		Integer retval = -1;
		PreparedStatement pstmt;
		String sql;
		if(isHomeTeamGoal) {
			sql = "update matches set goals_home = goals_home +1 where id = ?";
		} else {
			sql = "update matches set goals_visitor = goals_visitor +1 where id = ?";
		}
		Integer num;
		DatabaseConnectionPool dbConnectionPool;
		// create database connection pool
		try {
			dbConnectionPool = new DatabaseConnectionPool();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		Connection conn = dbConnectionPool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    pstmt.setInt(1, matchId);
		    num = pstmt.executeUpdate();
		    System.out.println("One goal added to match (ID: "+matchId+") Output value => " + num);
		    ResultSet rs = pstmt.getGeneratedKeys();
		    if(rs.next())
		    	retval=rs.getInt(1);
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return retval;
		}
		dbConnectionPool.destroy();
		return retval;
	}
	
}
