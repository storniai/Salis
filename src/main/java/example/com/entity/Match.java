package example.com.entity;

import java.util.Date;

public class Match {
	
	Integer id;
	String homeTeam;
	String visitorTeam;
	String location;
	Date date;
	Integer seasonId;
	Integer homeGoals;
	Integer visitorGoals;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getVisitorTeam() {
		return visitorTeam;
	}
	public void setVisitorTeam(String visitorTeam) {
		this.visitorTeam = visitorTeam;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}
	public Integer getHomeTeamGoals() {
		return homeGoals;
	}
	public void setHomeTeamGoals(Integer homeTeamGoals) {
		this.homeGoals = homeTeamGoals;
	}
	public Integer getHomeGoals() {
		return homeGoals;
	}
	public void setHomeGoals(Integer homeGoals) {
		this.homeGoals = homeGoals;
	}
	public Integer getVisitorGoals() {
		return visitorGoals;
	}
	public void setVisitorGoals(Integer visitorGoals) {
		this.visitorGoals = visitorGoals;
	}

}
