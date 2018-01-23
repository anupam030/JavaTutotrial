package java8Streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {
	
	public static void main(String[] args) {
		
		Stream<String> words
		= Stream.of("merrily", "merrily", "merrily", "gentlydgd","shsdjkdj","sffdmjdfdfj");
		//String[] result = words.toArray(String[]::new);
		// words.toArray() has type Object[]
		
		//Arrays.asList(result).forEach(System.out::println);;
		
		HashSet<String> resultHashSet = words.collect(HashSet::new, HashSet::add, HashSet::addAll);
		
		List<String> resultList = words.collect(Collectors.toList());
		
		Set<String> resultSet = words.collect(Collectors.toSet());
		
		String resultJoining = words.collect(Collectors.joining());
		
		String resultDelimeterJoining = words.collect(Collectors.joining(", "));
		
		/*If your stream contains objects other than strings, you need to first convert them
		to strings, like this:*/
		String result = words.map(Object::toString).collect(Collectors.joining(", "));
		
		IntSummaryStatistics summary = words.collect(
				Collectors.summarizingInt(String::length));
				double averageWordLength = summary.getAverage();
				double maxWordLength = summary.getMax();
	}

}
