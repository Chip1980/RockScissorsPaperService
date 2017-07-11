package controller;

import org.json.JSONException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Computer;
import model.Result;
import model.Sign;
import model.User;
import utility.RockScissorsPaperComperator;

@RestController
public class RockSiccorsPaperController {

	/*
	 * auffangen der Auswahl des Benutzers und Computer seine Wahl treffen
	 * lassen, danach die Zeichen mit einander vergleichen
	 */
	@RequestMapping(value = "/{choice}", method = RequestMethod.POST)
	@ResponseBody
	public Result shuffle(@PathVariable("choice") String id, @RequestBody Sign choice) {
		Result result = new Result();
		try {
			User user = new User(choice);
			Computer computer = new Computer();

			result = RockScissorsPaperComperator.compare(user, computer);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;

	}
}
