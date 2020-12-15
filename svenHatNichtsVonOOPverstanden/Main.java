package JavaCafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	private static Adressbuch adressbuch = new Adressbuch();
	private static boolean running = true;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		while (running) {
			System.out.println(" Geben Sie die Buchstaben f�r einen der Befehle ein: " + " \n"
					+ " {A} - Alle Eintr�ge einzeigen " + " \n" + " {S} - Eintr�ge durchsuchen "
					+ "\n" + " {N} - Neuer Eintrag hinzuf�gen " + "\n" + " {E} - Exit " +
					"\n" + " {R} - Eintrag l�schen" + "\n");
			try {

				executeCommand(reader.readLine().toUpperCase());
			} catch (Exception e) {
				System.out.println("Falsches K�rzel.");
			}
		}

	}

	private static void executeCommand(String cmd) {
		switch (cmd) {
		case "A":
			showAllEntries();
			break;
		case "N":
			newEntry();
			break;
		case "E":
			exitApplication();
		case "R":
			removeEintrag();
		case "S":
			searchEintrag();
		default:
			break;

		}
	}

	private static void newEntry() {
		try {
			System.out.println("Geben Sie den Vornamen ein:");
			String vorname = reader.readLine();

			System.out.println("Geben Sie den Nachnamen ein:");
			String name = reader.readLine();

			System.out.println("Geben Sie die Telefonnummer ein:");
			String telefonnummer = reader.readLine();

			adressbuch.hinzufuegen(new Person(vorname, name, telefonnummer));
			System.out.println("Nutzer hinzugef�gt.");

		} catch (Exception e) {
			System.out.println("Es ist ein Fehler aufgetreten. Der Nutzer konnte nich hinzugef�gt werden!");
		}
	}

	private static void exitApplication() {
		System.out.println("Anwendung schlie�t. ");
		System.exit(0);
	}

	private static void showAllEntries() {
		List<Person> personen = adressbuch.getPersonen();
		int i = 1;
		for (Person person : personen) {
			System.out.println("Eintrag: " + i++);
			System.out.println("Vorname: " + person.getVorname());
			System.out.println("Nachname: " + person.getName());
			System.out.println("Telefonnummer: " + person.getTelefonummer());
			System.out.println();
		}
	}

	private static void removeEintrag() {}

	private static void searchEintrag() {

		List<Person> personen = adressbuch.getPersonen();
		String personZuSuchen;
		System.out.println("Welche Person m�chten Sie suchen?");
		try {
			personZuSuchen = reader.readLine();
			
			for (Person person : personen) {
				if (person.getVorname().contentEquals(personZuSuchen)) {
					System.out.println("Vorname: " + person.getVorname());
					System.out.println("Nachname: " + person.getName());
					System.out.println("Telefonnummer: " + person.getTelefonummer());
					System.out.println();
					//Ausgabe fehlt noch
				} else {
					System.out.println("Den Namen gibt es nicht.");
				}

			}

		} catch (Exception e) {

		}

	}
//	private static void eintragSortieren()
//	{
//		List<Person> personen = adressbuch.getPersonen();
//		
//		Collections.sort(personen);
//	}

}
