package example.com.views;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.server.Responsive;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import example.com.service.MySqlService;

@SuppressWarnings("serial")
public class CreateNewMatchView extends NavigationView {
	
	private MySqlService mySqlService = new MySqlService();
	
	public CreateNewMatchView() {
		super("Uusi ottelu");
		buildMainLayout();
	}

	public void buildMainLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeUndefined();
		layout.setWidth("100%");
		layout.setSpacing(true);
		
		OptionGroup options = new OptionGroup();
        options.addItem("Kotipeli");
        options.addItem("Vieraspeli");
		
		final TextField opponent = new TextField();
		opponent.setInputPrompt("Vastustaja");
		
		final TextField location = new TextField();
		location.setInputPrompt("Pelipaikka");
		
		PopupDateField date = new PopupDateField();
		date.setInputPrompt("Ottelu alkaa");
		date.setResolution(Resolution.MINUTE);

		Button btnSave = new Button("Tallenna");
		btnSave.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				int id = mySqlService.createNewMatch(null, "My team", opponent.getValue(), 1, location.getValue());
				MatchView match = new MatchView(id);
				match.setPreviousComponent(new MainView());
				getNavigationManager().navigateTo(match);
			}
		});
		
		layout.addComponents(options, opponent, location, date, btnSave);
		Responsive.makeResponsive(options, opponent, location, date);
		setContent(layout);
	}

//	private void buildMainLayout2() {
//		VerticalComponentGroup layout = new VerticalComponentGroup();
//        ListBox violationBox = new ListBox();
//        violationBox.addItem("Choose...", (String) null);
//        String[] positions = {"puolustaja", "hyökkääjä", "maalivahti"};
//        for (String position : positions) {
//            violationBox.addItem(position, position);
//        }
//        violationBox.setWidth("100%");
//        violationBox.setStyleName("v-select-select");
//        SimplePanel violationWrapper = new SimplePanel(violationBox);
//        violationWrapper.setStyleName("v-select");
//        layout.addComponent((Component) violationWrapper);
//        layout.setCaption("PElipaikka");
//        
////        ListBox violationBox2 = new ListBox();
////        violationBox2.addItem("Valitse pelipaikka", (String) null);
////        String[] positions2 = {"puolustaja", "hyökkääjä", "maalivahti"};
////        for (String position : positions2) {
////            violationBox2.addItem(position, position);
////        }
////        violationBox2.setWidth("100%");
////        violationBox2.setStyleName("v-select-select");
////        SimplePanel violationWrapper2 = new SimplePanel(violationBox2);
////        violationWrapper2.setStyleName("v-select");
////        layout.add(violationWrapper2);
////        layout.updateCaption(violationWrapper2, "Pelipaikka", null, "100.0%",
////                "v-caption");
//        setContent((Component) layout);
//	}
}
