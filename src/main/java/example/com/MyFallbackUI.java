package example.com;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * This UI is served for browsers that don't support TouchKit.
 *
 */
@SuppressWarnings("serial")
@Theme("valo")
public class MyFallbackUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        Button button = new Button("Image icon");
        button.addStyleName("icon-align-right");
        setContent(button);

    }

}