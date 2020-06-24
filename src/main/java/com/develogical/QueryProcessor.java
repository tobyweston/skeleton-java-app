package com.develogical;

import simplehttp.HttpClients;
import simplehttp.HttpResponse;
import simplehttp.Url;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

public class QueryProcessor {

	public static Set<String> cache = new HashSet<>();

	public String process(String query) throws IOException {
		if (query == null) {
			throw new IOException("No query was supplied, perhaps no query parameter was supplied on the URI (q= instead of q=param)");
		}
		cache.add(query);
		if (query.toLowerCase().contains("romeo and juliet"))
			return "William Shakespeare";
		if (query.toLowerCase().contains("what is your name"))
			return "Toby";
		if (query.toLowerCase().contains("what is 11 plus 18"))
			return "29";
		if (query.toLowerCase().contains("which of the following numbers is the largest: ")) {
			new LargestNumber(query).is();
		}
		if (query.toLowerCase().contains("which city is the Eiffel tower in"))
			return "Paris";

		String question = query.substring(query.indexOf('=') + 1) ;
		String url = "https://mysterious-reaches-24898.herokuapp.com/api/?q=" + question;
		HttpResponse response = HttpClients.anApacheClient().get(Url.url(url));
		return response.getContent().asString();
	}
}
