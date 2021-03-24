package home.work14;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String surname;
    private final String name;
    private String dateOfBirth;
    private String contacts;
    private final List<String> group = new ArrayList<>();

    public Student(String surname, String name, String dateOfBirth,
                   String contacts) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contacts = contacts;
    }

    public void printGroupList() {
        for (int i = 0; i < getGroup().size(); i++) {
            System.out.println(getGroup().get(i));
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public List<String> getGroup() {
        return group;
    }
}
