package my.satish.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostRepeatedElement {
	
	public static void main(String arg[]) {
		int arr[]= {1,1,2,3,2,4,3,2,1,1,3,4,2,1,2,2,2,2,2,2};
		
		List<Integer> number = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(i-> i , Collectors.counting()))
				.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.map(Map.Entry::getKey)
				.limit(2)
				.collect(Collectors.toList());
		
		System.out.println(number);
		
	}
}
