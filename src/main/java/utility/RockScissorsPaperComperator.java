package utility;

import org.json.JSONException;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import model.Computer;
import model.IChoice;
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
				IChoice winner = null;
				switch (user.getChoice()) {
				case "ROCK":
					winner = (computer.getChoice().equals(Sign.SCISSORS.name())) ? user : computer;
					break;
				case "SCISSORS":
					winner = (computer.getChoice().equals(Sign.ROCK.name())) ? computer : user;
					break;
				case "PAPER":
					winner = (computer.getChoice().equals(Sign.ROCK.name())) ? user : computer;
					break;
				default:
					break;
				}
				IChoice loser;
				if (winner.equals(computer)) {
					loser = user;
				} else {
					loser = computer;
				}

				result.setWinner(winner);
				result.setLoser(loser);
			} else {
				result.setDrawChoice(user);
			}
		} catch (JSONException e) {
			Notification.show("Exception: " + e, Type.ERROR_MESSAGE);
		}
		return result;
	}

}
