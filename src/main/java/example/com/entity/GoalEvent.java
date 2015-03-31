package example.com.entity;

public class GoalEvent extends BaseEvent{
	
	public final static String EVENT_TYPE = "goal";
	
	String goalPlayerId;
	String goalPlayerName;
	String assistPlayerId;
	String assistPlayerName;
	
	public String getGoalPlayerId() {
		return goalPlayerId;
	}
	public void setGoalPlayerId(String goalPlayerId) {
		this.goalPlayerId = goalPlayerId;
	}
	public String getGoalPlayerName() {
		return goalPlayerName;
	}
	public void setGoalPlayerName(String goalPlayerName) {
		this.goalPlayerName = goalPlayerName;
	}
	public String getAssistPlayerId() {
		return assistPlayerId;
	}
	public void setAssistPlayerId(String assistPlayerId) {
		this.assistPlayerId = assistPlayerId;
	}
	public String getAssistPlayerName() {
		return assistPlayerName;
	}
	public void setAssistPlayerName(String assistPlayerName) {
		this.assistPlayerName = assistPlayerName;
	}
	
}
