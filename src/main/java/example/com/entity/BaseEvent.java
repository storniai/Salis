package example.com.entity;

public class BaseEvent {
	String id;
	String type;
	Integer matchId;
	String comment;
	Integer period;
	Integer minutes;
	Integer seconds;
	boolean myEvent;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public Integer getMinutes() {
		return minutes;
	}
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
	public Integer getSeconds() {
		return seconds;
	}
	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}
	public boolean isMyEvent() {
		return myEvent;
	}
	public void setMyEvent(boolean myEvent) {
		this.myEvent = myEvent;
	}
	
}
