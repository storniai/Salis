package example.com.views;

import java.util.List;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import example.com.entity.BaseEvent;
import example.com.entity.GoalEvent;
import example.com.entity.Match;
import example.com.entity.Player;
import example.com.layouts.EventLayout;
import example.com.service.MySqlService;

@SuppressWarnings("serial")
public class MatchView extends NavigationView {
	
	private Match match;
	private MySqlService mySqlService = new MySqlService();
	
	MatchView(int matchId) {
		super("Ottelu");
		match=mySqlService.getMatch(matchId);
		buildMainView();
	}
	
	private void buildMainView() {
		VerticalLayout layout = new VerticalLayout();
		layout.addComponents(getButtons(), getTopBar(),getTabSheet());
		layout.setComponentAlignment(layout.getComponent(1), Alignment.MIDDLE_CENTER);
		addComponents(layout);
	}
	
	private Label getTopBar() {
		String date = "<span class='text-center'>" + match.getDate() + " | " + match.getSeasonId() + "</span><br>";
		String score = "<h1><span class='team-name'>" + match.getHomeTeam() + "</span>" + " "
				+ "<span class='goal-box'>" + match.getHomeGoals() + "</span>" + " "
				+ "<span class='goal-box'>" + match.getVisitorGoals() + "</span>" + " "
				+ "<span class='team-name'>" + match.getVisitorTeam() + "</span></h1>";
		
		Label label = new Label(date+score,ContentMode.HTML);
		label.setSizeUndefined();
		return label;
	}
	
	private TabSheet getTabSheet() {
		TabSheet tabsheet = new TabSheet();
		tabsheet.setSizeFull();
		tabsheet.addTab(getEvents(),"Tapahtumat");
		tabsheet.addTab(getPlayerTable(),"Pelaajat");
		tabsheet.setStyleName(ValoTheme.TABSHEET_COMPACT_TABBAR);
		return tabsheet;
	}
		
	private HorizontalLayout getButtons() {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeUndefined();
		layout.setWidth("100%");
		Button btnCreateNewGoalEvent = new Button("Lisää maali");
		layout.addComponent(btnCreateNewGoalEvent);
		btnCreateNewGoalEvent.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				GoalEvent goal = new GoalEvent();
				goal.setType(GoalEvent.EVENT_TYPE);
				goal.setMatchId(match.getId());
				goal.setGoalPlayerId("1");
				goal.setGoalPlayerName("MAtti Matilainen");
				goal.setAssistPlayerId("2");
				goal.setAssistPlayerName("Timo Kiiskinen");
				goal.setComment("A great goal by "+goal.getGoalPlayerName());
				goal.setPeriod(1);
				goal.setMinutes(9);
				goal.setSeconds(56);
				mySqlService.createNewEvent(goal);
				mySqlService.addGoal(match.getId(),true);
				reload();
			}
		});
		return layout;
	}
	
	private VerticalLayout getEvents() {
		List<BaseEvent> events = mySqlService.getMatchEvents(match.getId());
		
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeUndefined();
		layout.setWidth("100%");
		if(events != null && !events.isEmpty()) {
			for(BaseEvent event : events) {
				EventLayout eLayout = new EventLayout(event);
				layout.addComponents(eLayout);
			}
		}
		return layout;
	}
		
	private Table getPlayerTable() {
		List<Player> players = mySqlService.getActivePlayers(1);
		BeanItemContainer<Player> dataSource = new BeanItemContainer<Player>(Player.class);
		dataSource.addAll(players);
		
		Table table = new Table();
		table.setContainerDataSource(dataSource);
		setCustomColumns(table);
		table.setVisibleColumns(new Object[] { "number", "name", "position", "inout"});
		String[] headers = { "#", "nimi", "rooli", "in / out"};
		table.setColumnHeaders(headers);
		return table;
	}
	
	private void setCustomColumns(Table table) {
		
		table.addGeneratedColumn("name", new ColumnGenerator() {
			@Override
			public Object generateCell(Table source, Object itemId, Object columnId) {
				final Player player = (Player) itemId;
				String name = player.getFirstname() + " " + player.getLastname();
				final Button link = new Button(name);
				link.setStyleName(ValoTheme.BUTTON_LINK);
				link.addClickListener(new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						getNavigationManager().navigateTo(new EditPlayerView(player));
					}
				});
				return link;
			}
		});
		
		table.addGeneratedColumn("position", new ColumnGenerator() {
			@Override
			public Object generateCell(Table source, Object itemId, Object columnId) {
				Player player = (Player) itemId;
				String position = player.getPosition();
				if(position.equals(Player.attacker))
					return "H";
				else if(position.equals(Player.defender))
					return "P";
				return "M";
			}
		});
		
		table.addGeneratedColumn("inout", new ColumnGenerator() {
			@Override
			public Object generateCell(Table source, Object itemId, Object columnId) {
				CheckBox cb = new CheckBox();
				cb.setValue(true);
				return cb;
			}
		});
	}
	
	public void reload() {
		match=mySqlService.getMatch(match.getId());
		buildMainView();
	}

	
}
