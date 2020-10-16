package com.Pannell;

import java.util.HashMap;
import java.util.Map.Entry;

import acm.program.ConsoleProgram;

public class NameCounts extends ConsoleProgram {

	private HashMap<String, Integer> map = new HashMap<>();

	public void run() {
		demonstration();
	}

	public void demonstration() {
		println("Continue to enter names or enter nothing to exit.");
		while (true) {

			String name = getStringFromUser("Enter a name: ");
			if (!isValidString(name)) {
				break;
			}

			iterateKeyValueOrMakeOne(name);
		}

		printNames();
	}

	public void printNames() {
		for (Entry<String, Integer> entry : map.entrySet()) {
			println("The name " + entry.getKey() + 
					", appears " + entry.getValue() + " times.");
		}

	}

	public void iterateKeyValueOrMakeOne(String name) {
		if (map.containsKey(name)) {
			int occurences = map.get(name);
			occurences = occurences + 1;
			map.put(name, occurences);
		} else {
			int occurences = 1;
			map.put(name, occurences);
		}
	}

	public boolean isValidString(String string) {

		if (string.isEmpty() || string == null) {
			return false;
		}
		return true;
	}

	public String getStringFromUser(String prompt) {
		return readLine(prompt);
	}

}
