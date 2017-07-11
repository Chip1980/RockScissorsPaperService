package utility;

import org.json.JSONException;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import model.Computer;
import model.Draw;
import model.Result;
import model.Sign;
import model.User;

public class RockScissorsPaperComperator {

	public RockScissorsPaperComperator() {
	}

	public static Result compare(User user, Computer computer) {
		Result result = new Result();
		try {
			if (!user.getChoice().equals(computer.getChoice())) {
				switch ((Sign) user.getChoice()) {
				case ROCK:
					result.setResult((computer.getChoice().equals(Sign.SCISSORS)) ? user : computer);
					break;
				case SCISSORS:
					result.setResult((computer.getChoice().equals(Sign.ROCK)) ? computer : user);
					break;
				case PAPER:
					result.setResult((computer.getChoice().equals(Sign.ROCK)) ? user : computer);
					break;
				default:
					break;
				}
			} else {
				result.setResult(new Draw(computer.getChoice()));
			}
		} catch (JSONException e) {
			Notification.show("Exception: " + e, Type.ERROR_MESSAGE);
		}
		return result;
	}

}
