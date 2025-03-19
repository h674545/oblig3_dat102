package oblig3_dat102;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LenketMengdeTest {

	@Test
	<T> void test() {
		
		MengdeADT<Integer> lenketMengde = new LenketMengde<>();
		
		assertTrue(lenketMengde.erTom());
		
		lenketMengde.leggTil(1);
		lenketMengde.leggTil(2);
		lenketMengde.leggTil(3);
		
		assertFalse(lenketMengde.erTom());
		
		assertTrue(lenketMengde.inneholder(1));
		assertTrue(lenketMengde.inneholder(2));
		assertTrue(lenketMengde.inneholder(3));
	}

}
