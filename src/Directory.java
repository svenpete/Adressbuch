import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Directory {

    private static List<Person> dirData;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String [] args) throws IOException {

        dirData = new ArrayList<>();
        boolean state = true;


        while (state){

            System.out.println("Wählen Sie eine Operation aus:");
            System.out.println("1. Person hinzufügen");
            System.out.println("2. Person löschen");
            System.out.println("3. Person suchen");
            System.out.println("4. Alle Einträge anzeigen");
            System.out.println("5. Programm verlasssen");
            System.out.print("Bitte jetzt eine Operation auswählen: ");
            String operation  = in.readLine();

            if (operation.equals("1")){
                addPerson();
            }
            else if (operation.equals("2")){
                deletePerson();
            }
            else if (operation.equals("3")){
                searchPerson();
            }
            else if (operation.equals("4")){
                showPerson();
            }
            else if (operation.equals("5")){
                exit();
            }
            else {
                System.out.println("Keine gültige Operation!");
            }
        }


    }

    public static Person getPersonData() throws IOException {

        System.out.println("--------------------------------------------------");
        System.out.print("Geben Sie einen Vornamen ein: ");
        String firstName = in.readLine();

        System.out.print("Geben Sie einen Nachnamen ein: ");
        String surName = in.readLine();

        System.out.print("Geben Sie die Straße ein: ");
        String street = in.readLine();

        System.out.print("Geben Sie die Stadt ein: ");
        String city = in.readLine();

        System.out.print("Geben Sie die Telefonnummer ein: ");
        String number = in.readLine();

        System.out.println("--------------------------------------------------");
        return new Person(firstName,surName,street,city,number);

    }


    public static void deletePerson() throws IOException {

        Person toDelete = getPersonData();
        Integer [] pos = new Integer[dirData.size()];

        for (int i = 0; i < dirData.size(); i++) {
            if (dirData.get(i).getFirstName().equals(toDelete.getFirstName()) &&
                    dirData.get(i).getSurName().equals(toDelete.getSurName()))
            {
                pos[i] = 1;
            } else {
                pos[i] = 0;
            }

        }

        for (Integer ins :
                pos) {
            if (ins == 1) dirData.remove(ins);
        }
    }

    public static List<Person> findPerson(Person toSearch) {
        List<Person> found = new ArrayList<>();

        for (Person p : dirData)
        {
            if (p.getFirstName().equals(toSearch.getFirstName()) &&
                    p.getSurName().equals(toSearch.getSurName())) {
                found.add(p);
            }

        }
        return found;
    }


    public static void searchPerson() throws IOException {
        Person toSearch = getPersonData();

        List<Person> found= findPerson(toSearch);

        for (Person p : found) {
            System.out.println("Nachname: " + p.getSurName());
            System.out.println("Vorname: " + p.getFirstName());
        }

    }


    public static void addPerson() throws IOException {
        dirData.add(getPersonData());
    }

    public static void showPerson(){
        System.out.println("--------------------------------------------------");
        for (Person p :
                dirData) {
            System.out.printf("Vorname: %s\n",    p.getFirstName());
            System.out.printf("Nachname: %s\n",   p.getSurName());
            System.out.printf("Straße: %s\n",     p.getStreet());
            System.out.printf("Stadt: %s\n",      p.getCity());
            System.out.printf("Rufnummer: %s\n", p.getNumber());
            System.out.println("--------------------------------------------------");
        }
    }

    public static void exit(){
        System.exit(0);
    }
}
