package com.develogical;

import simplehttp.CommonHttpClient;
import simplehttp.HttpClients;
import simplehttp.HttpResponse;
import simplehttp.Url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Forwarder {
	
	private final String forwardUrl;
	private final CommonHttpClient client = HttpClients.anApacheClient();
	private final String query;

	public Forwarder(String query, String forwardUrl) {
		this.query = query;
		this.forwardUrl = forwardUrl;
	}

	public String forward() {
		try {
			String question = query.substring(query.indexOf('=') + 1) ;
			String url = forwardUrl + "?q=" + URLEncoder.encode(question, "UTF-8");
			HttpResponse response = client.get(Url.url(url));
			return response.getContent().asString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
