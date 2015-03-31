package example.com.views;

import java.util.List;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.Align;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

import example.com.entity.Player;
import example.com.service.MySqlService;

@SuppressWarnings("serial")
public class ManagePlayersView extends NavigationView {
	
	private MySqlService mySqlService = new MySqlService();
	
	public ManagePlayersView() {
		super();
		buildLayout();
	}
	
	private void buildLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeUndefined();
		layout.setWidth("100%");
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
		
		VerticalComponentGroup group = new VerticalComponentGroup();
		group.addComponents(getAddNewPlayerButton());
		layout.addComponents(group,getPlayerTable());
		
		Responsive.makeResponsive(group);
	}
	
	private Table getPlayerTable() {
		List<Player> players = mySqlService.getPlayers(1);
		BeanItemContainer<Player> dataSource = new BeanItemContainer<Player>(Player.class);
		dataSource.addAll(players);
		
		Table table = new Table();
		table.setCaption("Pelaajat");
		table.setSizeFull();
		table.setContainerDataSource(dataSource);
		setCustomColumns(table);
		table.setVisibleColumns(new Object[] { "number", "name", "position"});
		String[] headers = { "#", "Nimi", "Rooli"};
		table.setColumnHeaders(headers);
		table.setColumnWidth("number", 15);
		table.setColumnWidth("position", 40);
		table.setColumnExpandRatio("name", 1);
		table.setColumnAlignment("name", Align.LEFT);
		table.setColumnAlignment("position", Align.CENTER);
		table.setPageLength(players.size());
		return table;
	}
	
	private void setCustomColumns(Table table) {
		
		table.addGeneratedColumn("name", new ColumnGenerator() {
			@Override
			public Object generateCell(Table source, Object itemId, Object columnId) {
				final Player player = (Player) itemId;
				String name = player.getFirstname() + " " + player.getLastname();
				final Button link = new Button(name);
				link.setStyleName(BaseTheme.BUTTON_LINK);
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
	}
	
	@Override
	protected void onBecomingVisible() {
        setPreviousComponent(new ManageTeamView());
	}
	
	private NavigationButton getAddNewPlayerButton() {
		final NavigationButton btnAddNewPlayer = new NavigationButton();
		btnAddNewPlayer.setTargetViewCaption("Lisää uusi pelaaja");
		btnAddNewPlayer.addClickListener(
		    new NavigationButtonClickListener() {
			@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				btnAddNewPlayer.getNavigationManager().navigateTo(new CreateNewPlayerView("Lisää uusi pelaaja"));
			}
		});
		return btnAddNewPlayer;
	}

}
