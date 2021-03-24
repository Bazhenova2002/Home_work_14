package home.work14;

public class Teacher extends Student {
    private final double salaryPerWeek;

    public Teacher(String surname, String name, String dateOfBirth, String contacts, double salaryPerWeek) {
        super(surname, name, dateOfBirth, contacts);
        this.salaryPerWeek = salaryPerWeek;
    }
}
