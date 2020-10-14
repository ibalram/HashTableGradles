package com.cg;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.MyLinkedHashMap;

public class MyLinkedHashMapTest {
	@Test
	public void givenASentenceWhenWordsAreAddedToListShouldreturnWordFrequency() {
		String sentence = "Paranoids are not paranoid because they are paranoid but "
				+ "because they keep putting themselves deliberately into " + "paranoid avoidable situations";
		String[] words = sentence.toLowerCase().split(" ");
		MyLinkedHashMap<String, Integer> myHashMap = new MyLinkedHashMap<>();
		for (String word : words) {
			Integer value = myHashMap.get(word);
			value = (value == null) ? 1 : value + 1;
			myHashMap.add(word, value);
		}
		System.out.println(myHashMap);
		int frequency = myHashMap.get("paranoid");
		assertEquals(3, frequency);
	}
	
	@Test
	public void givenASentenceWhenWordsAreAddedToListThenAfterDeletingWordShouldreturnNull() {
		String sentence = "Paranoids are not paranoid because they are paranoid but "
				+ "because they keep putting themselves deliberately into " + "paranoid avoidable situations";
		String[] words = sentence.toLowerCase().split(" ");
		MyLinkedHashMap<String, Integer> myHashMap = new MyLinkedHashMap<>();
		for (String word : words) {
			Integer value = myHashMap.get(word);
			value = (value == null) ? 1 : value + 1;
			myHashMap.add(word, value);
		}
		System.out.println(myHashMap);
		myHashMap.remove("avoidable");
		assertEquals(null, myHashMap.get("avoidable"));
	}

}
