package coreJava1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
// count the number of names starting with A in list
	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ahmad");
		names.add("BBody");
		names.add("Ahay");
		names.add("Dear");
		names.add("hire");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).startsWith("A")) {
				System.out.println(names.get(i));
				count++;
			}

		}
		System.out.println("regular: " + count);

	}

	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ahmad");
		names.add("BBody");
		names.add("Ahay");
		names.add("Deaer");
		names.add("hire");

		// there is no life for intermediate op if there is no terminal op
		// terminal op will execute only if inter op (filter) return true
		// we can create stream
		// how to use filter in stream api
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("Count: " + c);

		// direct stream
		Stream.of("Ahmad", "BBody", "Ahay", "Dear", "hire").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();
		// print all the name of Array list
//				names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		// limited the result set to 1
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println("Limit: " + s));

	}

	@Test
	public void StreamMap() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Ahmad");
		names.add("BBody");
		names.add("Ahay");
		names.add("Deaer");
		names.add("hire");

		// print names which have last letter as "a" with Uppercase

		Stream.of("Ahijeet", "Don", "Alekhya", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println("Last Letter:" + s));

		// print names which have first letter as a with Uppercase and sorted

		// convert array to arraylist

		List<String> names1 = Arrays.asList("Azhijeet", "Don", "Alekhya", "Rama", "Adam");

		names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println("Map: " + s));

		// merging 2 different lists name and names1

		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		System.out.println("Merge");
		newStream.forEach(s -> System.out.println(s));

		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Ad77am"));
		System.out.println("flag: " + flag);
		Assert.assertTrue(flag);

	}
	
	// process list and convert back to list for further processes
	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Ahijeet", "Don", "Alekhya", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println("ls:" + ls.get(0));
		
		// print unique number this array
		//sort the array and print index 3
		
		List<Integer> values = Arrays.asList(3,2,2,9,4,5,7,8,10);
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		List <Integer> sortedValue = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedValue.get(3));
	}

}
