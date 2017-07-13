package model;

import java.io.Serializable;

import org.json.simple.JSONObject;

/*
 * Object fuer den Result, inklusive Auswahl des Benutzers und des Computers
 * */
public class Result extends JSONObject implements Serializable {

	private static final long serialVersionUID = 3555914162664933540L;
	public static final String WINNERNAME = "winner";
	public static final String LOSERNAME = "loser";
	public static final String WINNERCHOICE = "winnerchoice";
	public static final String LOSERCHOICE = "loserchoice";
	private static final String DRAWCHOICE = "draw";

	public Result() {
	}

	public void setWinner(IChoice winner) {
		put(WINNERNAME, winner.getName());
		put(WINNERCHOICE, winner.getChoice());
	}

	public Object getWinnerChoice() {
		Object retValue = get(WINNERCHOICE);
		return retValue;
	}

	public Object getWinnerName() throws Exception {
		Object retValue = get(WINNERNAME);
		return retValue;
	}

	public void setLoser(IChoice loser) {
		put(LOSERNAME, loser.getName());
		put(LOSERCHOICE, loser.getChoice());
	}

	public Object getLoserChoice() {
		Object retValue = get(LOSERCHOICE);
		return retValue;
	}

	public Object getLoserName() {
		Object retValue = get(LOSERNAME);
		return retValue;
	}

	public void setDrawChoice(IChoice draw) {
		put(DRAWCHOICE, draw.getChoice());
	}

	public Object getDrawChoice() throws Exception {
		Object retValue = get(DRAWCHOICE);
		return retValue;
	}

	public boolean isDraw() {
		try {
			return (getWinnerChoice() == null && getLoserChoice() == null) && getDrawChoice() != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
