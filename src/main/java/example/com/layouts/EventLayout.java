package example.com.layouts;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

import example.com.entity.BaseEvent;
import example.com.entity.GoalEvent;
import example.com.entity.PenaltyEvent;

@SuppressWarnings("serial")
public class EventLayout extends HorizontalLayout {
	
	BaseEvent event;
	
	public EventLayout(BaseEvent anEvent) {
		super();
		event = anEvent;
		buildLayout();
	}
	
	private void buildLayout() {
		setSizeFull();
		setHeight("100px");
		setMargin(true);
		
		Label lblEvent = null;
		if(event instanceof GoalEvent) {
			lblEvent = getGoalEventLabel((GoalEvent)event);
		} else if(event instanceof PenaltyEvent) {
			
		} else {
			
		}
		
		Button btnDelete = getDeleteButton(event);
		
		addComponents(lblEvent,btnDelete);
		setExpandRatio(lblEvent, 1.0f);
		setComponentAlignment(lblEvent,Alignment.TOP_LEFT);
		setComponentAlignment(btnDelete,Alignment.TOP_RIGHT);
	}

	private Label getGoalEventLabel(GoalEvent event){

		String header = "<b>Maali</b>";
		String content = "<p>Maalintekijä "+ event.getGoalPlayerName();
		if(event.getAssistPlayerName() != null && !event.getAssistPlayerName().isEmpty()) {
			content += " ja syöttäjä " + event.getAssistPlayerName();
		}
		content += "</p>";
		Label lblEvent = new Label(header + content);
		lblEvent.setContentMode(ContentMode.HTML);
		return lblEvent;
	}
	
	private Button getDeleteButton(BaseEvent event) {
		Button del = new Button();
		del.setStyleName(ValoTheme.BUTTON_LINK);
		del.setIcon(new ThemeResource("icons/delete-24.png"));
		del.setSizeUndefined();
		return del;
	}
	
}
