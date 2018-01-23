package java8Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {

	public static void main(String[] args) {
		
		
		List<String> wordList = Arrays.asList("merrily", "merrily", "merrily", "gentlydgd","shsdjkdj","sffdmjdfdfj");
		
/*		Stream<String> words
		= wordList.stream();*/

		/*int[] shortWords = new int[12];
		words.parallel().forEach(
		s -> { if (s.length() < 12) shortWords[s.length()]++; });*/
		// Error—race condition!
		/*System.out.println(Arrays.toString(shortWords));*/
/*		This is very, very bad code. The function passed to forEach runs concurrently in
		multiple threads, updating a shared array. That’s a classic race condition. If you
		run this program multiple times, you are quite likely to get a different sequence
		of counts in each run, each of them wrong.*/

/*		To be exact, since intermediate stream operations are lazy, it is possible to
		mutate the collection up to the point when the terminal operation executes.
		For example, the following is correct:
		List<String> wordList = ...;*/
		Stream<String> words = wordList.stream();
		wordList.add("END"); // Ok
		long n = words.distinct().count();
		
		/*But this code is not:*/
		Stream<String> wordsinterference = wordList.stream();
		wordsinterference.forEach(s -> {if (s.length() < 12) wordList.remove(s);});
		// Error—interference
	}

}
