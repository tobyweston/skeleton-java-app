package com.develogical;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LargestNumber {
	private String query;

	public LargestNumber(String query) {
		this.query = query;
	}

	public String is() {
		String lead = "which of the following numbers is the largest: ";
		String[] numbers = query.substring(lead.length()).split(",");
		List<Integer> sorted = Arrays.stream(numbers)
			.map(s -> s.replaceAll(" ", ""))
			.map(Integer::parseInt)
//			.sorted()
			.collect(Collectors.toList());
		sorted.sort(Collections.reverseOrder());
		return sorted.get(0).toString();
	}
}
