package ing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student2 {
    String name;
    int age;
    int height;

    public Student2(String name, int age, int height) {
        this.age = age;
        this.height = height;
        this.name = name;
    }
}

class StudentComparator implements Comparator<Student2> {

    @Override
    public int compare(Student2 o1, Student2 o2) {
        if (o1.age == o2.age) {
            return Integer.compare(o1.height, o2.height);
        }
        return (o1.age > o2.age) ? 1 : -1;
    }

}

public class test {

    public static void main(String[] args) {
        Student2 s1 = new Student2("ram", 10, 170);
        Student2 s2 = new Student2("rahim", 10, 166);
        Student2 s3 = new Student2("reyaz", 15, 150);
        ArrayList<Student2> studentList = new ArrayList<Student2>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        Collections.sort(studentList, new StudentComparator());

        // sorting in reverse order
        Comparator<Student2> comp = Collections
                .reverseOrder(new StudentComparator());
        Collections.sort(studentList, comp);
        for (Student2 s : studentList) {
            System.out.println("Student isss");
            System.out.println(s.name);
            System.out.println(s.age);
            System.out.println(s.height);
        }

    }

}
