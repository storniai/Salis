package example.com.entity;

public class PenaltyEvent extends BaseEvent {
	
	public final static String EVENT_TYPE = "penalty";
	
	String penaltyPlayerId;
	String penaltyPlayerName;
	Integer penaltyTimeMinutes;
	public String getPenaltyPlayerId() {
		return penaltyPlayerId;
	}
	public void setPenaltyPlayerId(String penaltyPlayerId) {
		this.penaltyPlayerId = penaltyPlayerId;
	}
	public String getPenaltyPlayerName() {
		return penaltyPlayerName;
	}
	public void setPenaltyPlayerName(String penaltyPlayerName) {
		this.penaltyPlayerName = penaltyPlayerName;
	}
	public Integer getPenaltyTimeMinutes() {
		return penaltyTimeMinutes;
	}
	public void setPenaltyTimeMinutes(Integer penaltyTimeMinutes) {
		this.penaltyTimeMinutes = penaltyTimeMinutes;
	}
	
	
}
