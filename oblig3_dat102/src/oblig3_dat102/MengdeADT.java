package oblig3_dat102;

import oblig3_dat102.MengdeADT;

public interface MengdeADT<T> {
	   /**
     * Sjekker om mengden er tom.
     * 
     * @return true hvis mengden er tom, ellers false.
     */
    boolean erTom();

    /**
     * Sjekker om mengden inneholder et spesifikt element.
     * 
     * @param element Elementet som skal sjekkes.
     * @return true hvis elementet finnes i mengden, ellers false.
     */
    boolean inneholder(T element);

    /**
     * Sjekker om denne mengden er en delmengde av en annen mengde.
     * 
     * @param annenMengde Den andre mengden som skal sjekkes mot.
     * @return true hvis denne mengden er en delmengde av annenMengde, ellers false.
     */
    boolean erDelmengdeAv(MengdeADT<T> annenMengde);

    /**
     * Sjekker om denne mengden er lik en annen mengde.
     * 
     * @param annenMengde Den andre mengden som skal sjekkes.
     * @return true hvis mengdene er like, ellers false.
     */
    boolean erLik(MengdeADT<T> annenMengde);

    /**
     * Sjekker om denne mengden og en annen mengde er disjunkte (har ingen felles elementer).
     * 
     * @param annenMengde Den andre mengden som skal sjekkes.
     * @return true hvis mengdene er disjunkte, ellers false.
     */
    boolean erDisjunkt(MengdeADT<T> annenMengde);

    /**
     * Returnerer en ny mengde som er snittet av denne mengden og en annen mengde.
     * 
     * @param annenMengde Den andre mengden som snittet skal beregnes mot.
     * @return En ny mengde som er snittet av denne mengden og annenMengde.
     */
    MengdeADT<T> snitt(MengdeADT<T> annenMengde);

    /**
     * Returnerer en ny mengde som er unionen av denne mengden og en annen mengde.
     * 
     * @param annenMengde Den andre mengden som unionen skal beregnes mot.
     * @return En ny mengde som er unionen av denne mengden og annenMengde.
     */
    MengdeADT<T> union(MengdeADT<T> annenMengde);

    /**
     * Returnerer en ny mengde som er forskjellen (minus) mellom denne mengden og en annen mengde.
     * 
     * @param annenMengde Den andre mengden som skal trekkes fra.
     * @return En ny mengde som er resultatet av denne mengden minus annenMengde.
     */
    MengdeADT<T> minus(MengdeADT<T> annenMengde);

    /**
     * Legger til et element i mengden. Elementet legges bare til hvis det ikke allerede finnes.
     * 
     * @param element Elementet som skal legges til.
     */
    void leggTil(T element);

    /**
     * Legger alle elementer fra en annen mengde til denne mengden. Kun elementer som ikke allerede finnes, legges til.
     * 
     * @param annenMengde Den andre mengden som elementene skal hentes fra.
     */
    void leggTilAlleFra(MengdeADT<T> annenMengde);

    /**
     * Fjerner og returnerer et element fra mengden. Hvis elementet ikke finnes, returneres null.
     * 
     * @param element Elementet som skal fjernes.
     * @return Elementet som ble fjernet, eller null hvis det ikke fantes.
     */
    T fjern(T element);

    /**
     * Konverterer mengden til en tabell (array) av elementene.
     * 
     * @return En tabell (array) av elementene i mengden.
     */
    T[] tilTabell();

    /**
     * Returnerer antall elementer i mengden.
     * 
     * @return Antallet elementer i mengden.
     */
    int antallElementer();
}
