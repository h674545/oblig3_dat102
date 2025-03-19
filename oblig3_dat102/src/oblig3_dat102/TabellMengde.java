package oblig3_dat102;

import java.util.Arrays;

import oblig3_dat102.MengdeADT;
import oblig3_dat102.TabellMengde;

public class TabellMengde<T> implements MengdeADT<T> {
	
	private T[] tabell;
	int antall;
	
	public TabellMengde() {
		this.tabell = (T[]) new Object[10];
		this.antall = 0;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
	    for (int i = 0; i < antall; i++) {
	        if (tabell[i].equals(element)) {
	            return true; 
	        }
	    }
	    return false; 
	}

	private void utvidKapasitet() {
		tabell = Arrays.copyOf(tabell, tabell.length * 2);
		
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		
		for(int i = 0; i < antall; i++) {
			if(!annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		 
		if(antall != annenMengde.antallElementer()) {
			return false;
		}
		for(int i = 0; i < antall; i++) {
			if(!annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		
		for(int i = 0; i < antall; i++) {
			if(annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
 	}

	// finne felles mengde 
	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		
		TabellMengde <T> svar = new TabellMengde<>();
		
		for(int i = 0; i < antall; i++) {
			if(annenMengde.inneholder(tabell[i])) {
				svar.leggTil(tabell[i]);
			}
		}
		return svar;
	}

	// begge mengdene uten gjentakelser
	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		
		TabellMengde<T> svar = new TabellMengde<>();
		
		for(int i = 0; i < antall; i++) {
			svar.leggTil(tabell[i]);
		}
		
		T[] nyTabell = annenMengde.tilTabell();
		for( T element : nyTabell) {
			svar.leggTil(element);
		}
		return svar;
	}

	// tar elementene fra første, men fjerner de fra andre 
	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		
		TabellMengde<T> svar = new TabellMengde<>();
		
		for(int i = 0; i < antall; i++) {
			if(!annenMengde.inneholder(tabell[i])) {
				svar.leggTil(tabell[i]);
			}
		}
		return svar;
	}

	@Override
	public void leggTil(T element) {
		
		if(inneholder(element)) {
			return;
		}
		if(erFull()) {
			utvidKapasitet();
		}
		tabell[antall++] = element;
	}

	private boolean erFull() {
		return antall == tabell.length;
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		
	T [] nyTabell = annenMengde.tilTabell();
	
	for(T element : nyTabell) {
		this.leggTil(element);
		}
	}

	@Override
	public T fjern(T element) {
		
		for(int i = 0; i < antall; i++) {
		if(tabell[i].equals(element)) {
			T fjernet = tabell[i];
			tabell[i] = tabell[antall-1]; // erstatt med siste element
			tabell[antall-1] = null;
			antall--;
			return fjernet;
			}
		}
		return null; // finnes ikke 
	}

	@Override
	public T[] tilTabell() {
		return Arrays.copyOf(tabell, antall);
	}

	@Override
	public int antallElementer() {
		return antall;
	}

}