package java8Streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamStatefullTransformation {
	
	public static void main(String args[]) {
		
		Stream<String> uniqueWords
		= Stream.of("merrily", "merrily", "merrily", "gentlydgd","shsdjkdj","Qsffdmjdfdfj").distinct();
		// Only one "merrily" is retained rest duplicates are supressed
		
		//uniqueWords.forEach(System.out::println);
		
		/*Stream<String> longestFirst =
				uniqueWords.sorted(Comparator.comparing(String::length));
		longestFirst.forEach(System.out::println);*/
		
/*		Optional<String> largest = uniqueWords.max(String::compareToIgnoreCase);
		if (largest.isPresent())
		System.out.println("largest: " + largest.get());*/

/*		Optional<String> startswithQ = uniqueWords.filter(s -> s.startsWith("Q")).findFirst();
	
	    System.out.println(startswithQ.orElse("Not Present"));*/

/*		Optional<String> startsWithQ
		= uniqueWords.parallel().filter(s -> s.startsWith("Q")).findAny();
		
		System.out.println(startsWithQ.orElse("Not Present"));*/
		
		boolean aWordStartsWithQ
		= uniqueWords.parallel().anyMatch(s -> s.startsWith("Q"));
		
		System.out.println(aWordStartsWithQ);
	}

}
