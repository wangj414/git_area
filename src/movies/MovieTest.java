package movies;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {

	@Test
	public void testMovieGetName() {
		Movie m = new Movie("The Thing", 1951);
		assertEquals("The Thing", m.getName());
	}

	 @Test
	public void testMovieGetYear() {
		Movie m = new Movie("The Thing", 1951);
		assertEquals(1951, m.getYear());
	}

	@Test
	public void testActorGetName() {
		Actor a = new Actor("James Arness");
		assertEquals("James Arness", a.getName());
	}

	@Test
	public void testActorActedIn() {
		Movie m = new Movie("The Thing", 1951);
		Actor a = new Actor("James Arness");
		m.addActor(a);
		assertTrue(a.actedIn(m));
	}

	@Test
	public void testActorNotActedIn() {
		Movie m = new Movie("The Thing", 1951);
		Actor a = new Actor("James Arness");
		assertFalse(a.actedIn(m));
	}

	@Test
	public void testGetActorsOneMovieNoActor() {
		Movie m = new Movie("The Thing", 1951);
		assertTrue(m.getActors().size() == 0);
	}

	@Test
	public void testOneMovieAddActorGetActors() {
		Movie m = new Movie("The Thing", 1951);
		Actor a = new Actor("James Arness");
		m.addActor(a);
		assertTrue(m.getActors().size() == 1);
		assertTrue(m.getActors().contains(a));
	}

	@Test
	public void testOneMovieAddMovieGetActors() {
		Movie m = new Movie("The Thing", 1951);
		Actor a = new Actor("James Arness");
		a.addMovie(m);
		assertTrue(m.getActors().size() == 1);
		assertTrue(m.getActors().contains(a));
		assertTrue(a.actedIn(m));
	}

	@Test
	public void testAddActorActedWith() {
		Movie m = new Movie("The Thing", 1951);
		Actor a1 = new Actor("James Arness");
		Actor a2 = new Actor("Kevin Bacon");
		m.addActor(a1);
		m.addActor(a2);
		assertTrue(a1.actedWith(a2));
	}

	@Test
	public void testNotActedWith() {
		Actor a1 = new Actor("James Arness");
		Actor a2 = new Actor("Kevin Bacon");
		assertFalse(a1.actedWith(a2));
	}

	@Test
	    public void testOneMovieTwoActors() {
		Movie m = new Movie("The Thing", 1951);
		Actor a1 = new Actor("James Arness");
		Actor a2 = new Actor("Margaret Sheridan");
		m.addActor(a1);
		a2.addMovie(m);

		// Does m contain both actors?
		assertTrue(m.getActors().size() == 2);
		assertTrue(m.getActors().contains(a1));
		assertTrue(m.getActors().contains(a2));

		// Did each actor act in the movie?
		assertTrue(a1.actedIn(m));
		assertTrue(a2.actedIn(m));

		// Did a1 and a2 act with each other?
		assertTrue(a1.actedWith(a2));
		assertTrue(a2.actedWith(a1));
	}

	@Test
	public void testMovieEquals() {
		Movie m1 = new Movie("The Thing", 1951);
		Movie m2 = new Movie("The Thing", 1951);
		assertTrue(m1.equals(m2));
	}

	@Test
	public void testMovieEqualsDifferentActors() {
		Movie m1 = new Movie("The Thing", 1951);
		Movie m2 = new Movie("The Thing", 1951);
		Actor a = new Actor("James Arness");
		m1.addActor(a);
		assertTrue(m1.equals(m2));
	}

	@Test
	public void testMovieNotEqualsName() {
		Movie m1 = new Movie("The Thing", 1951);
		Movie m2 = new Movie("Nosferatu", 1922);
		assertFalse(m1.equals(m2));
	}

	@Test
	public void testMovieNotEqualsYear() {
		Movie m1 = new Movie("The Thing", 1951);
		Movie m2 = new Movie("A Streetcar Named Desire", 1951);
		assertFalse(m1.equals(m2));
	}

	@Test
	public void testActorEqualsNoMovies() {
		Actor a1 = new Actor("James Arness");
		Actor a2 = new Actor("James Arness");
		assertTrue(a1.equals(a2));
	}

	@Test
	public void testActorNotEqualsTwoActors() {
		Actor a1 = new Actor("James Arness");
		Actor a2 = new Actor("Margaret Sheridan");
		assertFalse(a1.equals(a2));
	}

	@Test
	public void testActorNotEqualsNonActor() {
		Actor a1 = new Actor("James Arness");
		assertFalse(a1.equals("Not an Actor"));
	}

	@Test
	public void testActorEqualsTwoMovies() {
		Actor a1 = new Actor("James Arness");
		Actor a2 = new Actor("James Arness");
		Movie m1 = new Movie("The Thing", 1951);
		Movie m2 = new Movie("Them!", 1954);
		a1.addMovie(m1);
		a1.addMovie(m2);
		a2.addMovie(m1);
		a2.addMovie(m2);
		assertTrue(a1.equals(a2));
	}

	@Test
	public void testActorEqualsTwoMoviesDifferentOrder() {
		Actor a1 = new Actor("James Arness");
		Actor a2 = new Actor("James Arness");
		Movie m1 = new Movie("The Thing", 1951);
		Movie m2 = new Movie("Them!", 1954);
		a1.addMovie(m1);
		a1.addMovie(m2);
		a2.addMovie(m2);
		a2.addMovie(m1);
		assertTrue(a1.equals(a2));
	}

	@Test
	public void testActorNotEqualsExtraMovie() {
		Actor a1 = new Actor("James Arness");
		Actor a2 = new Actor("James Arness");
		Movie m1 = new Movie("The Thing", 1951);
		Movie m2 = new Movie("Them!", 1954);
		Movie m3 = new Movie("Gunsmoke: Return to Dodge", 1987);
		a1.addMovie(m1);
		a1.addMovie(m2);
		a2.addMovie(m2);
		a2.addMovie(m1);
		a2.addMovie(m3);
		assertFalse(a1.equals(a2));
	}

	@Test
	public void testActorToStringNoMovies() {
		Actor a1 = new Actor("James Arness");
		String res = a1.toString();
		String exp = "James Arness ()";
		assertEquals(exp, res);
	}

	@Test
	public void testActorToStringOneMovie() {
		Actor a1 = new Actor("James Arness");
		Movie m1 = new Movie("The Thing", 1951);
 		a1.addMovie(m1);
		String res = a1.toString();
		String exp = "James Arness (The Thing)";
		assertEquals(exp, res);
	}

	@Test
	public void testActorToStringThreeMovies() {
		Actor a1 = new Actor("James Arness");
		Movie m1 = new Movie("The Thing", 1951);
		Movie m2 = new Movie("Them!", 1954);
		Movie m3 = new Movie("Gunsmoke: Return to Dodge", 1987);
		a1.addMovie(m1);
		a1.addMovie(m2);
		a1.addMovie(m3);
		String res = a1.toString();
		String exp = "James Arness (The Thing, Them!, Gunsmoke: Return to Dodge)";
		assertEquals(exp, res);
	}

	@Test
	public void testMovieToStringNoActors() {
		Movie m1 = new Movie("The Thing", 1951);
		String res = m1.toString();
		String exp = "The Thing, 1951";
		assertEquals(exp, res);
	}

	@Test
	public void testMovieToStringOneMovie() {
		Actor a1 = new Actor("James Arness");
		Movie m1 = new Movie("The Thing", 1951);
		m1.addActor(a1);
		String res = m1.toString();
		String exp = "The Thing, 1951" + System.lineSeparator() + a1.getName();
		assertEquals(exp, res);
	}

	@Test
	public void testMovieToStringFourActors() {
		Actor a1 = new Actor("James Arness");
		Actor a2 = new Actor("Margaret Sheridan");
		Actor a3 = new Actor("Kenneth Tobey");
		Actor a4 = new Actor("Robert Cornthwaite");
		Movie m1 = new Movie("The Thing", 1951);
		m1.addActor(a1);
		m1.addActor(a2);
		m1.addActor(a3);
		m1.addActor(a4);
		String res = m1.toString();
		String exp = "The Thing, 1951" + System.lineSeparator() + a1.getName() + System.lineSeparator() + a2.getName()
				+ System.lineSeparator() + a3.getName() + System.lineSeparator() + a4.getName();
		assertEquals(exp, res);
	}

}
