package example.com.views;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.NumberField;
import com.vaadin.addon.touchkit.ui.Switch;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import example.com.entity.Player;
import example.com.service.MySqlService;

@SuppressWarnings("serial")
public class CreateNewPlayerView extends NavigationView {
	
	protected TextField firstname;
	protected TextField lastname;
	protected NumberField number;
	protected ListSelect role;
	protected Switch isActive;
	private MySqlService mySqlService = new MySqlService();
	
	public CreateNewPlayerView(String caption) {
		super(caption);
		buildLayout();
	}
	
	private Player getPlayer() {
		Player player = new Player();
		player.setFirstname(firstname.getValue());
		player.setLastname(lastname.getValue());
		player.setPosition((String) role.getValue());
		player.setTeamid(1);
		player.setActive(isActive.getValue());
		
		Integer num = new Integer(number.getValue());
		if(num != null)
			player.setNumber(num);
		
		return player;
	}
	
	private void buildLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeUndefined();
		layout.setWidth("100%");
		layout.setMargin(true);
		layout.setSpacing(true);
		
		VerticalComponentGroup group = new VerticalComponentGroup("Pelaajan tiedot");
		
		FormLayout formLayout = new FormLayout();
		formLayout.setSizeFull();
		formLayout.setMargin(true);
		formLayout.setImmediate(true);
		
		firstname = new TextField("Etunimi");
		lastname = new TextField("Sukunimi");
		number = new NumberField("Pelinumero");
        
		role = new ListSelect("Rooli");
		role.addItem(Player.attacker);
		role.addItem(Player.defender);
		role.addItem(Player.goalie);
		role.setItemCaption(Player.attacker, "hyökkääjä");
		role.setItemCaption(Player.defender, "puolustaja");
		role.setItemCaption(Player.goalie, "maalivahti");
		
		isActive = new Switch("Aktiivinen", true);
		isActive.setImmediate(true);
		isActive.addValueChangeListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				if(isActive.getValue()) {
					isActive.setCaption("Aktiivinen");
				} else {
					isActive.setCaption("Poissa");
				}
				
			}
        });
		
		formLayout.addComponents(firstname,lastname,number,role,isActive);
		group.addComponents(formLayout);
		
		Button btnSave = new Button("Tallenna");
		btnSave.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				mySqlService.createNewPlayer(getPlayer());
				getNavigationManager().navigateTo(new ManagePlayersView());
			}
		});
		
		layout.addComponents(group,btnSave);
		setContent(layout);
		Responsive.makeResponsive(group,btnSave);
	}
}
