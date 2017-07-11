package model;

import org.json.JSONException;

public interface IChoice {
	public static final String CHOICE = "choice";
	public static final String NAME = "name";
	public static final String DRAW = "draw";

	public String getName() throws JSONException;

	public Sign getChoice() throws JSONException;

	public boolean isDraw();
}
