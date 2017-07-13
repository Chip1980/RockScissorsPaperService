package model;

import java.io.Serializable;

import org.json.simple.JSONObject;

/*
 * Object fuer die Auswahl und Namen des Computers
 * */
public class Computer extends JSONObject implements IChoice, Serializable {

	private static final long serialVersionUID = 7279757819714242717L;

	public Computer() {
		put(CHOICE, Sign.randomize());
		put(NAME, getClass().getSimpleName());
	}

	@Override
	public String getName() {
		return get(NAME).toString();
	}

	@Override
	public Sign getChoice() {
		return (Sign) get(CHOICE);
	}

}
