package example.com.views;

import com.vaadin.addon.responsive.Responsive;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Toolbar;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.CssLayout;

@SuppressWarnings("serial")
public class MainView extends NavigationView {
	
	public MainView(){
		super("Etusivu");
		new Responsive(this);
		buildLayout();
	}
	
	public void buildLayout(){
		CssLayout layout = new CssLayout();
		layout.setSizeFull();
		
		final NavigationButton btnCreateNewMatch = new NavigationButton();
		btnCreateNewMatch.setTargetViewCaption("Lisää ottelu");
		btnCreateNewMatch.addClickListener(
		    new NavigationButtonClickListener() {
			@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				 btnCreateNewMatch.getNavigationManager().navigateTo(new CreateNewMatchView());
			}
		});
		layout.addComponent(btnCreateNewMatch);
		
		final NavigationButton btnShowMatches = new NavigationButton();
		btnShowMatches.setTargetViewCaption("Näytä ottelut");
		btnShowMatches.addClickListener(
		    new NavigationButtonClickListener() {
			@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				btnShowMatches.getNavigationManager().navigateTo(new ShowMatchesView());
			}
		});
		layout.addComponent(btnShowMatches);
		
		final NavigationButton btnManageTeam = new NavigationButton();
		btnManageTeam.setTargetViewCaption("Joukkueen tiedot");
		btnManageTeam.addClickListener(
		    new NavigationButtonClickListener() {
			@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				btnManageTeam.getNavigationManager().navigateTo(new ManageTeamView());
			}
		});
		layout.addComponent(btnManageTeam);
		
		this.setToolbar(getToolbar());
		
		setContent(layout);
	}
	
	public Toolbar getToolbar() {
		Toolbar toolbar = new Toolbar();
		
		final NavigationButton btnManageTeam = new NavigationButton();
		btnManageTeam.setIcon(FontAwesome.FLOPPY_O);
		btnManageTeam.setTargetViewCaption("Joukkue");
		btnManageTeam.addClickListener(
		    new NavigationButtonClickListener() {
			@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				btnManageTeam.getNavigationManager().navigateTo(new ManageTeamView());
			}
		});
		toolbar.addComponent(btnManageTeam);
		
		return toolbar;
	}
}
