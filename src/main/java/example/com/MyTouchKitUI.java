package example.com;

import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import example.com.views.MainView;

/**
 * The UI's "main" class
 */
@SuppressWarnings("serial")
@Widgetset("example.com.gwt.AppWidgetSet")
@Theme("mymobiletheme")
public class MyTouchKitUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        NavigationManager manager =
                new NavigationManager(new MainView());
        setContent(manager);
    }

}