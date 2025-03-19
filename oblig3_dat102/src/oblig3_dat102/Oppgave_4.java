package oblig3_dat102;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Oppgave_4 {
	
	public static void main(String[]args) {
	
	final int antallElement = 100000;
	final int maksElement = 1000000;
	final int antallSok = 10000;
	
	HashSet<Integer> hashSet = new HashSet<>();
	int[]tabell = new int[antallElement];
	
	int tall = 376;
	for(int i = 0; i < antallElement; i ++) {
		hashSet.add(tall);
		tabell[i] = tall;
		tall= (tall + 45713) % maksElement;
	}
	
	Arrays.sort(tabell);
	
	Random tilfeldig = new Random();
	int[] soketall = new int[antallSok];
	for(int i = 0; i < antallSok; i++) {
		soketall[i] = tilfeldig.nextInt(maksElement);
	}
	long startHashSet = System.nanoTime();
	int funnetIHashSet = 0; 
	for (int tallSok : soketall) {
		if(hashSet.contains(tallSok)) { // sjekker om tallet finnes
			funnetIHashSet++;
		}
	}
	long sluttHashSet = System.nanoTime();
	long hashSetTid = sluttHashSet - startHashSet;
	
	long startBinarySok = System.nanoTime();
	long funnetIBinarySok = 0;
	for(int tallSok : soketall) {
		if(Arrays.binarySearch(tabell, tallSok) >= 0) {
			funnetIBinarySok++;
		}
	}
	long sluttBinarySok = System.nanoTime();
	long binarySokTid = sluttBinarySok - startBinarySok;
	
	System.out.println("HashSet treff : " + funnetIHashSet);
	System.out.println("HashSet tid: " + hashSetTid / 1_000_000.0 + "ms");
	
	System.out.println("Binærsøk treff : " + funnetIBinarySok);
	System.out.println("Binær tid: " + binarySokTid / 1_000_000.0 + "ms");
	}
}

// ser at hashset er raskere, noe som gir mening siden søking i hashset skjer i O(1), mens binærsøk bruker O(log n)