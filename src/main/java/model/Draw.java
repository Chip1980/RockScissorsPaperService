package model;

import java.io.Serializable;

import org.json.JSONException;
import org.json.simple.JSONObject;

/*
 * Object fuer den Result(Auswahl) bei Unentschieden
 * */
public class Draw extends JSONObject implements IChoice, Serializable {
	private static final long serialVersionUID = 9040121681825043756L;

	public Draw(Sign sign) throws JSONException {
		put(CHOICE, sign);
		put(NAME, getClass().getSimpleName());
		put(DRAW, true);
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
