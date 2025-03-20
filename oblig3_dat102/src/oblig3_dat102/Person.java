package oblig3_dat102;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Person {
	
	private String navn;
	private Set<String> hobby;
	
	public Person(String navn, String hobby, String string, String string2, String string3) {
		this.navn = navn;
		this.hobby = new HashSet<>(Arrays.asList(hobby));
	}
	
	public String getNavn() {
		return navn;
	}
	public Set<String> getHobby(){
		return hobby;
	}
}
