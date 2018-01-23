package java8Streams;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamsReduceOperation {

	public static void main(String[] args) {
		Stream<Integer> values = Stream.of(1,2,3,4,5);
		
		//Optional<Integer> sum = values.reduce((x, y) -> x + y);
		//Optional<Integer> sum = values.reduce(Integer::sum);
		
		//System.out.println(sum.orElse(1));
		
		Integer sum = values.reduce(0, (x, y) -> x + y);
		
		System.out.println(sum);
	}
}
