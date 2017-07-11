package model;

import java.io.Serializable;

import org.json.JSONException;
import org.json.simple.JSONObject;

/*
 * Object fuer die Auswahl und Namen des Benutzers
 * */
public class User extends JSONObject implements IChoice, Serializable {

	public static final String CHOICE = "choice";
	private static final long serialVersionUID = -4362308654114446906L;

	public User(Sign choice) throws JSONException {
		put(CHOICE, choice);
		put(NAME, getClass().getSimpleName());
		put(DRAW, false);
	}

	public Sign getChoice() throws JSONException {
		return (Sign) get(CHOICE);
	}

	@Override
	public String getName() throws JSONException {
		return get(NAME).toString();
	}

	@Override
	public boolean isDraw() {
		return (boolean) get(DRAW);
	}
}
