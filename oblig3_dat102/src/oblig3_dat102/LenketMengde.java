package oblig3_dat102;

import oblig3_dat102.LenketMengde;

public class LenketMengde<T> implements MengdeADT<T> {
	
	public class Node {
	private T data;
	private Node neste;

	public Node(T data) {
		this.data = data;
		this.neste = null;
		}
	}

	private Node forste;
	private int antall;
	private LenketMengde<T>.Node neste;
	
	public LenketMengde() {
		forste = null;
		antall = 0;
	}
	public void setNesteNode(Node node) {
		  this.neste = node;
		}
	
	public Node getNestNode() {
		  return this.neste;
		}
	
	@Override
	public boolean erTom() {
		return forste == null;
	}

	@Override
	public boolean inneholder(T element) {
		
		boolean funnet = false; 
		
		Node denneNoden = forste;
		
		while(!funnet && (denneNoden != null)) {
			if(element.equals(denneNoden.data)) {
				funnet = true;
			}
			denneNoden = denneNoden.neste;
		}
		return funnet;
	}
	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		
		Node denne = forste;
		
		while(denne != null) {
			denne = denne.neste;
			if(denne == annenMengde) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		
		if(antall != annenMengde.antallElementer()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		
		Node temp = forste;
		
		while(annenMengde != null) {
		if(annenMengde.equals(temp.data)){
			return false;
		}
		temp = temp.neste;
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		
		LenketMengde<T> svar = new LenketMengde<>();
		
		while(svar != null) {
			if(svar == annenMengde) {
			}
		}
		return svar;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		
		LenketMengde<T> svar = new LenketMengde<>();
		
		T[] nyTabell = annenMengde.tilTabell();
		for(T element : nyTabell) {
			svar.leggTil(element);
		}
		return svar;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		
		LenketMengde<T> svar = new LenketMengde<>();
		
		Node temp = forste;
		
		while(temp != null) {
			if(!annenMengde.inneholder(temp.data)) {
				svar.leggTil(temp.data);
			}
			temp = temp.neste;
		}
		return svar;
	}

	@Override
	public void leggTil(T element) {
		
		if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
		
		LenketMengde<T>.Node nyNode = new Node(element);
		
		nyNode.neste = forste;
		forste = nyNode;
		antall++;
		
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
		
		if(forste == null) {
		return null;
	}
		Node denne = forste;
		Node forrige = null;
		
		while(denne != null) {
			if(element.equals(denne.data)) {
				if(forrige == null) {
					forste = denne.neste;
				} else {
					forrige.neste = denne.neste;
				}
				antall--;
				return denne.data;
			}
			forrige = neste;
			denne = denne.neste;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public T[] tilTabell() {
		
		T[] nodeTabell = (T[]) new Object[antall];
		return nodeTabell;
	}

	@Override
	public int antallElementer() {

		return antall;
	}
}