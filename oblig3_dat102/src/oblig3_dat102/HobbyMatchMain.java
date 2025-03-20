package oblig3_dat102;

import java.util.HashSet;
import java.util.Set;

public class HobbyMatchMain {
	
	public static double match(Person a, Person b) {
		Set<String> fellesHobby = new HashSet<>(a.getHobby());
		fellesHobby.retainAll(a.getHobby());
		
		int antallHobbyer = a.getHobby().size() + b.getHobby().size() - fellesHobby.size();
		return antallHobbyer== 0 ? 1.0 : (double) fellesHobby.size() / antallHobbyer;
	}
		public static void main(String[] args) {
	        Person silje = new Person("Silje", "strikking", "sykling", "venner", "data");
	        Person sondre = new Person("Sondre", "data", "sykling", "strikking", "lesing");
	        Person simon = new Person("Simon", "jakt", "fiske", "data", "trening");

	        double matchAB = match(silje, sondre);
	        double matchAC = match(sondre, simon);
	        double matchBC = match(silje, simon);

	        System.out.println("Match mellom Arne og Bente: " + matchAB);
	        System.out.println("Match mellom Arne og Carl: " + matchAC);
	        System.out.println("Match mellom Bente og Carl: " + matchBC);

	        if (matchAB >= matchAC && matchAB >= matchBC) {
	            System.out.println("Beste match: Arne og Bente");
	        } else if (matchAC >= matchAB && matchAC >= matchBC) {
	            System.out.println("Beste match: Arne og Carl");
	        } else {
	            System.out.println("Beste match: Bente og Carl");
	        }
	}

}
