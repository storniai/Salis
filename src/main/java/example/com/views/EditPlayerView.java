package example.com.views;

import example.com.entity.Player;

@SuppressWarnings("serial")
public class EditPlayerView extends CreateNewPlayerView {
	
	private Player player;
	
	public EditPlayerView(Player player) {
		super("Muokkaa pelaajaa");
		this.player = player;
		setValues();
	}
	
	private void setValues() {
		firstname.setValue(player.getFirstname());
		lastname.setValue(player.getLastname());
		role.setValue(player.getPosition());
		number.setValue(""+player.getNumber());
		isActive.setValue(player.isActive());
	}

}
