package com.develogical;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SquareAndCubeTest {
	
	@Test
	@Ignore
	public void whatIsSquareAndCube() {
		String query = "50c9a0c0: which of the following numbers is both a square and a cube: 729, 1681, 381, 881";
		assertThat(new SquareAndCute(query).result(), is(""));
	}
	
	@Test
	public void substring() {
		String query = "https://mysterious-reaches-24898.herokuapp.com/api/?=abc";
		assertThat(query.substring(query.indexOf('=') + 1), is("abc"));
	}
}
