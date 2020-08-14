
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
	private String[] myText;
	private Random myRandom;

	public MarkovWordOne() {
		myRandom = new Random();
	}

	public void setRandom(int seed) {
		myRandom = new Random(seed);
	}

	public void setTraining(String text) {
		myText = text.split("\\s+");
	}

	public String getRandomText(int numWords) {
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length - 1);
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		for (int k = 0; k < numWords - 1; k++) {
			ArrayList<String> follows = getFollows(key);
			if (follows.size() == 0) {
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = next;
		}

		return sb.toString().trim();
	}

	public int indexOf(String[] words, String target, int start) {
		for (int k = start; k < words.length; k++) { // Search through all the words
			if (words[k].equals(target)) { //if word i'm looking for is my target, i found it.
				return k;
			}
		}
		return -1;
	}

	private ArrayList<String> getFollows(String key) {
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		while (pos < myText.length) {
			int start = indexOf(myText, key, pos);
			if (start == -1) {
				break;
			}
			if (start + 1 >= myText.length - 1) {
				break;
			}
			String next = myText[start + 1];
			follows.add(next);
			pos = start + 1;
		}
		return follows;
	}

	public void testIndexOf() {
		String text = "this is just a test yes this is a simple test";
		String[] words = text.split("\\s+");
		System.out.println(indexOf(words, "this", 0));
		System.out.println(indexOf(words, "this", 3));
		System.out.println(indexOf(words, "frog", 0));
		System.out.println(indexOf(words, "frog", 5));
		System.out.println(indexOf(words, "simple", 2));
		System.out.println(indexOf(words, "test", 5));

	}

}
