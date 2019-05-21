package app.yjkm.com.day_03;

public class Teacher implements Cloneable {
    public String name;
    public String id;

    @Override
    protected Teacher clone() {
        Teacher teacher = null;
        try {
            teacher = (Teacher) super.clone();
            teacher.name = this.name;
            teacher.id = this.id;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
