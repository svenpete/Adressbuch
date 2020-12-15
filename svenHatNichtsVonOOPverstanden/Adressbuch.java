package JavaCafe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Adressbuch implements Comparable<Adressbuch>{
	
	private List<Person> Personen = new ArrayList<Person>();
	
	public List<Person> getPersonen() {
		return Personen; }
	
	public void hinzufuegen(Person person) throws IOException {
		this.Personen.add(person);
		xmlParser.generateDocument(Personen);
	}
	
	public void loeschen (Person person) { this.Personen.remove(person); }
	
	//public void suchen (Person person) {this.Personen.(person);}

	@Override
	public int compareTo(Adressbuch o) {
		// TODO Auto-generated method stub
		return this.compareTo(this);
	}


	
	
	
	
	

}
