package model;

import java.io.Serializable;
import java.util.LinkedHashMap;

import org.json.JSONException;
import org.json.simple.JSONObject;

/*
 * Object fuer den Result, inklusive Auswahl des Benutzers und des Computers
 * */
public class Result extends JSONObject implements Serializable {

	private static final long serialVersionUID = 3555914162664933540L;
	public static final String NAME = "name";
	public static final String CHOICE = "choice";
	public static final String WINNER = "winner";
	private static final String COMPUTER = "computer";
	private static final String USER = "user";
	private static final String DRAW = "draw";

	public Result() {
	}

	public void setResult(IChoice winner) throws JSONException {
		put(NAME, winner.getName());
		put(CHOICE, winner.getChoice());
		put(DRAW, winner.isDraw());
	}

	public String getResultChoice() throws Exception {
		LinkedHashMap<String, String> object = (LinkedHashMap<String, String>) get(WINNER);
		String retValue = "";
		if (object == null) {
			retValue = (String) get(CHOICE);
		} else {
			retValue = object.get(CHOICE);
		}
		return retValue;
	}

	public String getResultName() throws Exception {
		LinkedHashMap<String, String> object = (LinkedHashMap<String, String>) get(WINNER);
		String retValue = "";
		if (object == null) {
			retValue = (String) get(NAME);
		} else {
			retValue = object.get(NAME);
		}
		return retValue;
	}

	public String getComputerChoice() throws Exception {
		LinkedHashMap<String, String> object = (LinkedHashMap<String, String>) get(COMPUTER);
		String retValue = "";
		if (object == null) {
			retValue = (String) get(CHOICE);
		} else {
			retValue = object.get(CHOICE);
		}
		return retValue;
	}

	public String getUserChoice() throws Exception {
		LinkedHashMap<String, String> object = (LinkedHashMap<String, String>) get(USER);
		String retValue = "";
		if (object == null) {
			retValue = (String) get(CHOICE);
		} else {
			retValue = object.get(CHOICE);
		}
		return retValue;
	}

	public boolean isDraw() {
		LinkedHashMap<String, Boolean> object = (LinkedHashMap<String, Boolean>) get(WINNER);
		boolean retValue = false;
		if (object == null) {
			retValue = (boolean) get(DRAW);
		} else {
			retValue = object.get(DRAW);
		}
		return retValue;
	}

}
