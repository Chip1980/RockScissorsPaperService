package model;

import java.io.Serializable;

import org.json.JSONException;
import org.json.simple.JSONObject;

/*
 * Object fuer die Auswahl und Namen des Computers
 * */
public class Computer extends JSONObject implements IChoice, Serializable {

	private static final long serialVersionUID = 7279757819714242717L;

	public Computer() throws JSONException {
		put(CHOICE, Sign.randomize());
		put(NAME, getClass().getSimpleName());
		put(DRAW, false);
	}

	@Override
	public String getName() throws JSONException {
		return get(NAME).toString();
	}

	@Override
	public Sign getChoice() throws JSONException {
		return (Sign) get(CHOICE);
	}

	@Override
	public boolean isDraw() {
		return (boolean) get(DRAW);
	}

}
