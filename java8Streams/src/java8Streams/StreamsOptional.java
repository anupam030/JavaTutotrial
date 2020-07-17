package java8Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> results = new ArrayList<String>();
		Stream<String> uniqueWords
		= Stream.of("merrily", "merrily", "merrily", "Qgentlydgd","shsdjkdj","sffdmjdfdfj").distinct();
		
		Stream<String> uniqueWordssecond
		= Stream.of("merrily", "merrily", "merrily", "Qgentlydgd","shsdjkdj","sffdmjdfdfj").distinct();
	
		/*Stream<Character> characterStream = uniqueWords.flatMap(s->characterStream(s));*/
		Stream<Character> characterStream = uniqueWords.flatMap(StreamsOptional::characterStream);
		characterStream.forEach(System.out::println);
		
		
		Optional<String> startsWithQ
		= uniqueWords.parallel().filter(s -> s.startsWith("Q")).findAny();
		
		startsWithQ.ifPresent(s->results.add(s));
		startsWithQ.ifPresent(results::add);
		results.forEach(System.out::println);
		
		Optional<Boolean> added = startsWithQ.map(results::add);
//		Optional<Boolean> added = startsWithQ.map(s->results.add(s));
		if (added.isPresent())
			System.out.println("added is true");
		
		String result = startsWithQ.orElseGet(() -> System.getProperty("user.dir"));
		System.out.println(result);

		//String resultQ = startsWithQ.orElseThrow(NoSuchElementException::new);
		
		//Optional<Double> resultOptionalFlat = inverse(10.0).flatMap(StreamsOptional::squareRoot);
		Optional<Double> resultOptionalFlat = inverse(10.0).flatMap(d->squareRoot(d));

		if (resultOptionalFlat.isPresent())
			System.out.println(resultOptionalFlat.get());
	}

	//creating optional
	public static Optional<Double> inverse(Double x) {
		return x == 0 ? Optional.empty() : Optional.of(1 / x);
	}

	public static Optional<Double> squareRoot(Double x) {
		return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
	}

	public static Stream<Character> characterStream(String s) {
		 List<Character> result = new ArrayList<>();
		 for (char c : s.toCharArray()) result.add(c);
		 return result.stream();
		}
}
