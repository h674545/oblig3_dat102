package oblig3_dat102;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {
	
	Set<T> nyttSett = new HashSet<>();
	private int antall;
	
	public JavaSetToMengde() {
		
		this.antall = 0; 
	}

	@Override
	public boolean erTom() {
		
		return nyttSett.isEmpty();
	}

	@Override
	public boolean inneholder(T element) {
		
		return nyttSett.contains(element);
}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		
		for(T s : nyttSett) {
		if(antall == antallElementer()) {
			while(s == annenMengde);
			return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		
		return nyttSett.equals(annenMengde);
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		
		for(T s : nyttSett) {
			if(s.equals(annenMengde)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		
		JavaSetToMengde<T> snittMengde = new JavaSetToMengde<>();
		
		for(T element : nyttSett) {
			if(annenMengde.inneholder(element)) {
				snittMengde.leggTil(element);
			}
		}
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		
		JavaSetToMengde<T> unionMengde = new JavaSetToMengde<>();
		
		for(T element : nyttSett) {
			unionMengde.leggTil(element);
		}
		T[] tabell = annenMengde.tilTabell();
		for(T element : tabell) {
			unionMengde.leggTil(element);
		}
		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		
		JavaSetToMengde<T> minusMengde = new JavaSetToMengde<>();
		
		minusMengde.nyttSett.addAll(this.nyttSett);
		
		for(T m : annenMengde.tilTabell()) {
				minusMengde.nyttSett.remove(m);
		}
		return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		
		nyttSett.add(element);
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		
		for(T l : annenMengde.tilTabell()) {
			nyttSett.add(l);
		}
	}

	@Override
	public T fjern(T element) {
		
		return nyttSett.remove(element) ? element : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] tilTabell() {
		
		return (T[]) nyttSett.toArray(new Object[0]);
	}

	@Override
	public int antallElementer() {
		
		return nyttSett.size();
	}

}
