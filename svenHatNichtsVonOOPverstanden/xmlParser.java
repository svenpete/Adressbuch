package JavaCafe;

import java.io.*;
import java.util.List;

public class xmlParser {

    public static void generateDocument (List<Person> person) throws IOException
    {
        String xml = "";
        xml += "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>";
        xml += "<Person>";
        for (Person p: person) {

            xml += "<Person>";
            xml += "<Name>  " + p.getName()+"  <Name>";
            xml += "<Vorname>  "+p.getVorname()+"  <Vorname>";
            xml += "<Telefonnummer>  "+p.getTelefonummer()+"   <Telefonnummer>";
            xml += "<Person>";
        }
        xml += "<Person>";

        FileWriter file = new FileWriter( "Adressbuch.txt");
        BufferedWriter bw = new BufferedWriter(file);
        bw.write(xml);
        bw.close();
    }



}
