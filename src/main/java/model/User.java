package model;

import java.io.Serializable;

import org.json.simple.JSONObject;

/*
 * Object fuer die Auswahl und Namen des Benutzers
 * */
public class User extends JSONObject implements IChoice, Serializable {

	public static final String CHOICE = "choice";
	private static final long serialVersionUID = -4362308654114446906L;

	public User() {

	}

	public void setUser(Sign choice) {
		put(CHOICE, choice.name());
		put(NAME, getClass().getSimpleName());
	}

	public String getChoice() {
		return (String) get(CHOICE);
	}

	@Override
	public String getName() {
		return get(NAME).toString();
	}

}
