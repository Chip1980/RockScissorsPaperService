package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Menge der Auswahlmoeglichkeiten und Randomizer fur den Computer */
public enum Sign {
	ROCK, SCISSORS, PAPER;

	public static Sign randomize() {
		List<Sign> letters = Arrays.asList(Sign.values());
		Collections.shuffle(letters);
		return letters.stream().findFirst().get();
	}

	@Override
	public String toString() {
		return name();
	}
}
