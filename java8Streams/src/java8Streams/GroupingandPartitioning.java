package java8Streams;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingandPartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

/*		Map<String, List<Locale>> countryToLocales = locales.collect(
				Collectors.groupingBy(Locale::getCountry));
		
		List<Locale> swissLocales = countryToLocales.get("CH");
		// Yields locales [it_CH, de_CH, fr_CH]
		
		swissLocales.forEach(System.out::println);*/
		
		/*When the classifier function is a predicate function (that is, a function returning
				a boolean value), the stream elements are partitioned into two lists: those where
				the function returns true and the complement. In this case, it is more efficient to
				use partitioningBy instead of groupingBy. For example, here we split all locales
				into those that use English, and all others:*/
		
	/*	Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
				Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
				List<Locale> englishLocales = englishAndOtherLocales.get(true);
				englishLocales.forEach(System.out::println);
				*/
				
				/*The groupingBy method yields a map whose values are lists. If you want to process
				those lists in some way, you supply a “downstream collector.” For example, if
				you want sets instead of lists, you can use the Collectors.toSet collector that you
				saw in the preceding section:*/
				Map<String, Set<Locale>> countryToLocaleSet = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
				
				countryToLocaleSet.forEach((s,l)->{System.out.println("key"+s);System.out.println("value"+l);});

	}

}
