package oblig3_dat102;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class JavaSetToMengdetest {

	@Test
	<T> void test() {
		
		MengdeADT<Integer> javaSetToMengde = new JavaSetToMengde<>();
		
		assertTrue(javaSetToMengde.erTom());
		
		javaSetToMengde.leggTil(1);
		javaSetToMengde.leggTil(2);
		javaSetToMengde.leggTil(3);
		
		assertFalse(javaSetToMengde.erTom());
		
		assertTrue(javaSetToMengde.inneholder(1));
		assertTrue(javaSetToMengde.inneholder(2));
		assertTrue(javaSetToMengde.inneholder(3));
	}

}
