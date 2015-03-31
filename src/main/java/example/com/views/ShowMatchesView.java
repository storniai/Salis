package example.com.views;

import java.util.List;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;

import example.com.entity.Match;
import example.com.service.MySqlService;

public class ShowMatchesView extends NavigationView {
	
	private MySqlService mySqlService = new MySqlService();
	
	public ShowMatchesView() {
		super("Ottelut");
		buildLayout();
		//mssagelayout sitten taulukkoon, mistä on header disabloitu
		//http://dev.vaadin.com/browser/svn/demo/mobilemail/src/main/java/com/vaadin/demo/mobilemail/ui/MessageHierarchyView.java

		//valo theme
		// https://github.com/vaadin/vaadin/blob/master/uitest/src/com/vaadin/tests/themes/valo/TextFields.java
	}
	
	private void buildLayout() {
		TabSheet tabsheet = new TabSheet();
		tabsheet.setSizeFull();
		addComponents(tabsheet);
		
		tabsheet.addTab(new MatchList(), "Tulevat ottelut");
		tabsheet.addTab(new MatchList(), "Menneet ottelut");
	}
	
	 @SuppressWarnings("serial")
	private class MatchList extends CssLayout {
		 
		 MatchList(){
			 generateLayout();
		 }
		 
		 private void generateLayout(){
			 List<Match> matches = mySqlService.getMatches();	 
			 for(Match m : matches) {
				 Label match = new Label(m.getHomeTeam() + " vs "+m.getVisitorTeam());
				 addComponents(getMatchButton(m));
			 }
		 }
	 }
	 
	@SuppressWarnings("serial")
	private NavigationButton getMatchButton(final Match match) {
		final NavigationButton btnGoToMatch = new NavigationButton();
		btnGoToMatch.setTargetViewCaption(match.getHomeTeam() + " vs " +match.getVisitorTeam());
		
		btnGoToMatch.addClickListener(
		    new NavigationButtonClickListener() {
			@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				btnGoToMatch.getNavigationManager().navigateTo(new MatchView(match.getId()));
			}
		});
		return btnGoToMatch;
	}
	
}
