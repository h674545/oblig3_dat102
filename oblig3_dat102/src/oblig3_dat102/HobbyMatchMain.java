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

	        System.out.println("Match mellom silje og sondre: " + matchAB);
	        System.out.println("Match mellom sondre og simon: " + matchAC);
	        System.out.println("Match mellom silje og simon: " + matchBC);

	        if (matchAB >= matchAC && matchAB >= matchBC) {
	            System.out.println("Beste match: silje og sondre");
	        } else if (matchAC >= matchAB && matchAC >= matchBC) {
	            System.out.println("Beste match: sondre og simon");
	        } else {
	            System.out.println("Beste match: silje og simon");
	        }
	}

}
