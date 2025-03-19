package oblig3_dat102;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TabellMengdeTest {

	@Test
	<T> void test() {
		
		MengdeADT<Integer> tabell = new TabellMengde<>();
		
		assertTrue(tabell.erTom());
	
		tabell.leggTil(1);
		tabell.leggTil(2);
		tabell.leggTil(3);
		
		assertFalse(tabell.erTom());
		
		assertTrue(tabell.inneholder(1));
		assertTrue(tabell.inneholder(2));
		assertTrue(tabell.inneholder(3));
		
		
	
	}

}
