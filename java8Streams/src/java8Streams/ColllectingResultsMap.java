package java8Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class ColllectingResultsMap {
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		Stream<Person> peopleStream = people.stream();
		Map<String, String> idToName = peopleStream.collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
		
		/*In the common case that the values should be the actual elements, use Function.
		identity() for the second function.*/
		Map<String, Person> idToPerson = peopleStream.collect(Collectors.toMap(Person::getFirstName, Function.identity()));
		
/*		However, suppose we want to know all languages in a given country. Then we
		need a Map<String, Set<String>>. For example, the value for "Switzerland" is the set
		[French, German, Italian]. At first, we store a singleton set for each language.
		Whenever a new language is found for a given country, we form the union of
		the existing and the new set.*/
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

		Map<String, Set<String>> countryLanguageSets = locales.collect(
		Collectors.toMap(
		l -> l.getDisplayCountry(),
		l -> Collections.singleton(l.getDisplayLanguage()),
		(a, b) -> { // Union of a and b
		Set<String> r = new HashSet<>(a);
		r.addAll(b);
		return r; }));
		
		/*If you want a TreeMap, then you supply the constructor as the fourth argument.
		You must provide a merge function. Here is one of the examples from the
		beginning of the section, now yielding a TreeMap:*/
		Map<String, Person> idToPerson2 = peopleStream.collect(
				Collectors.toMap(Person::getFirstName,Function.identity(),(existingValue, newValue) -> { throw new IllegalStateException();},
				TreeMap::new));
	}

	
}
