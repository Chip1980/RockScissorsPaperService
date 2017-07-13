package view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import controller.RockSiccorsPaperController;
import model.Result;
import model.Sign;

/*
 * 
 * vaadin UI 
 * 
 * */
@SpringUI
@ComponentScan(basePackageClasses = { RockSiccorsPaperController.class })
public class RockSicissorsPaperUI extends UI {

	private static final long serialVersionUID = 2080537417361344930L;
	private static Sign choice = null;
	private static final String URL = "http://localhost:8090/RockSiccorsPaper?choice=";
	private RadioButtonGroup<Sign> userChoice = new RadioButtonGroup<>("User Selection");
	private Label computerChoice = new Label("Automatic Selection");
	private Button shuffle;

	@Autowired
	public RockSicissorsPaperUI() {
		userChoice.setItems(Sign.ROCK, Sign.SCISSORS, Sign.PAPER);
		shuffle = new Button("shuffle");
	}

	@Override
	protected void init(VaadinRequest request) {
		userChoice.setValue(choice);
		userChoice.setIcon(VaadinIcons.USER);

		userChoice.addValueChangeListener(event -> {
			choice = event.getValue();
		});

		computerChoice.setIcon(VaadinIcons.DESKTOP);

		/*
		 * play the game
		 */
		shuffle.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = -5403778192783592092L;

			@Override
			public void buttonClick(Button.ClickEvent event) {
				if (choice != null) {
					try {

						RestTemplate rt = new RestTemplate();
						rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
						rt.getMessageConverters().add(new StringHttpMessageConverter());
						String uri = new String(URL + choice);
						Result returns = rt.postForObject(uri, choice, Result.class);
						if (returns.isDraw()) {
							Notification.show("Draw ", "" + returns.getDrawChoice(), Type.TRAY_NOTIFICATION);
						} else {
							Notification.show(returns.getWinnerName() + " beats " + returns.getLoserName(),
									returns.getWinnerChoice() + " >> " + returns.getLoserChoice(),
									Type.TRAY_NOTIFICATION);
						}
					} catch (Exception e) {
						Notification.show("An exception has occurred: " + e, Type.ERROR_MESSAGE);
					}
				} else {
					Notification.show("Take a choice, please.", Type.ERROR_MESSAGE);
				}
			}
		});

		HorizontalLayout appLayout = new HorizontalLayout(userChoice, shuffle, computerChoice);
		appLayout.setMargin(true);
		appLayout.setSpacing(true);
		VerticalLayout layout = new VerticalLayout(appLayout);
		layout.setSizeFull();

		layout.setComponentAlignment(appLayout, Alignment.MIDDLE_CENTER);
		setContent(layout);

	}

}
