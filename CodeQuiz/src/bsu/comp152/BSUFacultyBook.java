package bsu.comp152;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class BSUFacultyBook extends RecordBook {

    public BSUFacultyBook(String bookName) {
        super(bookName);
        data = new ArrayList<Contact>();
    }


    public void loadData() throws IOException {
        var fileName = "Contacts";
        var filePath = Paths.get(fileName);
        var allLines = Files.readAllLines(filePath);
        for (var line : allLines) {
            var splitLine = line.split(", ");
            var name = splitLine[0];
            var num = splitLine[1];
            var info = splitLine[2];
            Contact contact = new Contact(name, num, info);
            data.add(contact);
        }


    }

    @Override
    public Contact findContact(String name) {
        System.out.println("Enter Customer Name");
        var contact = "";
        var reader = new Scanner(System.in);
        contact = reader.nextLine();
        for (int i = 0; i < data.size(); i++) {
            if (contact.equals(contact.get(i))) {
                System.out.println(contact.get(i));
                break;
            }
            if (i == data.size() - 1) {
                System.out.println("Contact not found.");
                break;
            }
        }
    }
}