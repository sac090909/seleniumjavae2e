package seleniumjava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SampleStrTest {

	public static void main(String[] args) {

		// Remove duplicate char in a word

		String testWord = "apple";
		Set<Character> set = new LinkedHashSet<Character>();
		for (char c : testWord.toCharArray()) {
			set.add(c);
		}
		StringBuilder testWordWithOutRepeat = new StringBuilder();
		for (char c : set) {
			testWordWithOutRepeat.append(c);
		}
		System.out.println(testWordWithOutRepeat);

		// Remove duplicate work in a sent
		
		String sen = "This is is a line of line";
		String [] senArray = sen.split(" ");
		Set <String> set1 = new LinkedHashSet();
		
		for (String arr : senArray) {
			
			set1.add(arr);
		}
		
		System.out.println(set1);
		StringBuilder sb = new StringBuilder();
		
		for (String s : set1) {
		sb.append(s + " ");}
		
		System.out.println(sb);
		
		
	}

}
