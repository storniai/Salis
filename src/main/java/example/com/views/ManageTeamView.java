package example.com.views;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.addon.touchkit.ui.NavigationView;

@SuppressWarnings("serial")
public class ManageTeamView extends NavigationView {
	
	public ManageTeamView() {
		super("Joukkueen tiedot");
		buildLayout();
	}
	
	private void buildLayout() {
		final NavigationButton btnManagePlayers = new NavigationButton();
		btnManagePlayers.setTargetViewCaption("Pelaajat");
		btnManagePlayers.addClickListener(
		    new NavigationButtonClickListener() {
			@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				btnManagePlayers.getNavigationManager().navigateTo(new ManagePlayersView());
			}
		});
		addComponents(btnManagePlayers);
	}
	
	@Override
	protected void onBecomingVisible() {
        setPreviousComponent(new MainView());
	}
}
