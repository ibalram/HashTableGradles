package DSHashTable;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyHashMapTest {
	@Test
	public void givenASentenceWhenWordsAreAddedToListShouldreturnWordFrequency() {
		String sentence = "To be or not to be";
		String[] words = sentence.toLowerCase().split(" ");
		MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
		for (String word : words) {
			Integer value = myHashMap.get(word);
			value = (value == null) ? 1 : value + 1;
			myHashMap.add(word, value);
		}
		System.out.println(myHashMap);
		int frequency = myHashMap.get("to");
		assertEquals(2,frequency);
	}

}
