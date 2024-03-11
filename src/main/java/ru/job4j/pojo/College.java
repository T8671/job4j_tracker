package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivan Ivanov");
        student.setGroup(3);
        student.setDateOfAdmission(new Date());

        System.out.println(student.getFullName() + ", "
                + student.getGroup() + ", "
                + student.getDateOfAdmission());
    }
}
