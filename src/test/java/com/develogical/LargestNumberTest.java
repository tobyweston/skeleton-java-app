package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LargestNumberTest {
	
	@Test
	public void something() {
		String query = "which of the following numbers is the largest: 668, 31, 76, 421";
		LargestNumber largestNumber = new LargestNumber(query);
		assertThat(largestNumber.is(), is("668"));
	}
	
	@Test
	public void anotherExample() {
		String query = "which of the following numbers is the largest: 74, 222, 55, 657";
		LargestNumber largestNumber = new LargestNumber(query);
		assertThat(largestNumber.is(), is("657"));
	}
	
//	@Test
//	public void spamPete() throws UnsupportedEncodingException {
//		for (int i  = 0; i < 10; i++) {
//			String uuid = UUID.randomUUID().toString().substring(0, 8);
//			String url = "https://stark-waters-23164.herokuapp.com/api/?q=" + URLEncoder.encode(String.format("%s: What is 34 * 23", uuid), "UTF-8");
//			HttpResponse response = HttpClients.anApacheClient().get(Url.url(url));
//			System.out.println(response.getContent().asString());
//		}
//	}
}

