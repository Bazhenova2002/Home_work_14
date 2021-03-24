package home.work14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Group {
    private final String nameCurs;
    private final String dateStartCurs;
    private final int sumQuantityLessons;
    private final int sumQuantityLessonsPerWeek;
    private final List<Student> studentList = new ArrayList<>();
    private final List<Teacher> teacherList = new ArrayList<>();

    public Group(String nameCurs, String dateStartCurs, int sumQuantityLessons,
                 int sumQuantityLessonsPerWeek) {
        this.nameCurs = nameCurs;
        this.dateStartCurs = dateStartCurs;
        this.sumQuantityLessons = sumQuantityLessons;
        this.sumQuantityLessonsPerWeek = sumQuantityLessonsPerWeek;
    }

    public String getGroupName() {
        return this.nameCurs + "," + getDateStartCurs();
    }

    public String getDateOfLastClasses() throws ParseException {
        Date tmp = new SimpleDateFormat("dd.MM.yyyy").parse(getDateStartCurs());
        LocalDate StartDateOfClasses = tmp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate EndDateOfClasses = StartDateOfClasses.plusWeeks(getSumQuantityLessons() / getSumQuantityLessonsPerWeek());
        return EndDateOfClasses.toString();
    }

    public void addTeacher(String lastName, String firstName, String dateOfBirth, String contacts, double salaryPerWeek) {
        Teacher teacher = new Teacher(lastName, firstName, dateOfBirth, contacts, salaryPerWeek);
        getTeacherList().add(teacher);
        teacher.getGroup().add(getGroupName());
    }

    public void printTeacherList() {
        int id = 1;
        for (Teacher teacher : getTeacherList()) {
            System.out.println(id + ". " + teacher.getName() + " " + teacher.getSurname());
            id++;
        }
    }

    public void addStudent(String lastName, String firstName, String dateOfBirth, String contacts) {
        Student student = new Student(lastName, firstName, dateOfBirth, contacts);
        getStudentList().add(student);
        student.getGroup().add(getGroupName());
    }

    public void addStudent(Student student) {
        student.getGroup().add(getGroupName());
        getStudentList().add(student);
    }

    public void printStudentList() {
        int id = 1;
        for (Student student : getStudentList()) {
            System.out.println(id + ". " + student.getName().charAt(0) + ". " + student.getSurname());
            id++;
        }
    }

    public void checkStudent(String Surname) {
        for (Student student : getStudentList()) {
            if (student.getSurname().equals(Surname)) {
                System.out.println("Студент с такой фамилей: " + Surname + " - есть в группе.");
                break;
            } else System.out.println("Студента с такой фамилей: " + Surname + " - нет в группе.");
            break;
        }
    }

    public void deleteStudent(String lastName) {
        getStudentList().removeIf(student -> student.getSurname().equals(lastName));
    }

    public void deleteStudent(int index) {
        getStudentList().removeIf(student -> student.getSurname().equals(getStudentList().get(index).getSurname()));
    }

    public int getSumQuantityLessons() {
        return sumQuantityLessons;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getSumQuantityLessonsPerWeek() {
        return sumQuantityLessonsPerWeek;
    }

    public String getDateStartCurs() {
        return dateStartCurs;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }
}
