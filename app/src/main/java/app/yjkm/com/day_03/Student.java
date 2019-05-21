package app.yjkm.com.day_03;

import java.util.ArrayList;

public class Student implements Cloneable {

    public String name;
    public String student_id;
    public ArrayList<Teacher> teachers;

    @Override
    protected Student clone() {
        Student student = null;
        try {
            student = (Student) super.clone();
            student.name = this.name;
            student.student_id = this.student_id;
            student.teachers = (ArrayList<Teacher>) this.teachers.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }
}
