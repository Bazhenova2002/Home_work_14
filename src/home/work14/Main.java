/*
1) Написать класс "Группа", для отображения учебной группы в Hillel, который содержит поля:
- название курса
- дата старта занятий
- суммарное количество занятий
- количество занятий в неделю
- список учащихся типа Student у которого есть фамилия, имя, дата рождения и контакты.
Написать методы:
- метод который выдает название группы на основе даты старта и названия курса
- метод который выдает дату последнего занятия
- печатает список студентов по порядку в формате:
И. Иванов
П. Петров
С. Сидоров
- добавить студента
- узнать если ли студент с такой фамилией в группе
- удалить студента по фамилии или по номеру
1.1*) У студента есть список групп в которых он учится.
При добавлении студента в группу у него прописывается эта группа в списке.
В группе есть преподаватель типа Teacher, у которого есть те же поля что у Student + информация о зарплате.
 */
package home.work14;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Group group = new Group("JavaIntroduction",
                "28.01.2021", 16, 2);
        System.out.println(group.getGroupName());
        System.out.println("Дата последнего занятия: " + group.getDateOfLastClasses());
        group.addTeacher("Andrey", "Kadatsky", "someDateOfBirth",
                "ak.@mail.com", 10000);
        group.addTeacher("Mikhail", "Mikhajlov", "someDateOfBirth",
                "mm@mail.com", 10000);
        System.out.println("Преподователи группы: ");
        group.printTeacherList();
        System.out.println();
        System.out.println("Список группы:");
        group.addStudent("Padinkton", "Valli", "15.06.2002", "a@meil.com");
        group.addStudent("Vellikton", "Garri", "18.07.2002", "b@meil.com");
        group.addStudent("Parjiton", "Mari", "24.08.2002", "c@meil.com");
        group.addStudent("Millov", "Lid", "5.09.2002", "d@meil.com");
        group.addStudent("Enderson", "Billi", "8.01.2002", "f@meil.com");
        group.addStudent("Vasilkin", "Olson", "10.02.2002", "on@meil.com");
        group.addStudent("Pitryson", "Fun", "23.03.2002", "g@meil.com");
        group.addStudent("Danielov", "German", "28.04.2002", "gr@meil.com");
        group.addStudent("Excelentov", "Nadi", "19.06.2002", "na@meil.com");
        group.addStudent("Milili", "Sara", "2.06.2003", "mi@meil.com");
        group.printStudentList();
        System.out.println();
        System.out.println("Проверка, есть ли студент с такой фамилией в группе:");
        group.checkStudent("Danilov");
        group.checkStudent("Padinkton");
        System.out.println();
        System.out.println("Удаление студента по номеру:");
        group.deleteStudent(4);
        group.printStudentList();
        System.out.println();
        System.out.println("Удаление студента по по фамилии:");
        group.deleteStudent("Vasilkin");
        group.printStudentList();
        System.out.println();

        Group group1 = new Group("JavaElementary",
                "03.03.2021", 32, 2);
        System.out.println(group1.getGroupName());
        System.out.println("Добовляем студентов из группы: JavaIntroduction в группу: JavaElementary");
        group1.addStudent(group.getStudentList().get(1));
        group1.addStudent(group.getStudentList().get(2));
        group1.printStudentList();
        System.out.println();
        System.out.println("Студент: G. Vellikton, учиться в таких группах:");
        group.getStudentList().get(1).printGroupList();
        System.out.println();
        System.out.println("Студент: L. Millov, учиться в таких группах:");
        group.getStudentList().get(3).printGroupList();
    }
}
