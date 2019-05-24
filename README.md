# 原型模式

```

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student student = new Student();
        student.name = "我的世界";
        student.student_id = "123465";
        ArrayList<Teacher> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Teacher teacher = new Teacher();
            teacher.id = "" + i;
            teacher.name = "--" + i + "--";
            list.add(teacher);
        }
        student.teachers = list;

        clone_0(student);
//        setData(student);
    }

    /**
     * clone 模式测试
     *
     */


    /**
     * 1 赋值模式
     *
     * @param student log 结果
     *                setData: name = 我的世界
     *                onCreate: student = app.yjkm.com.day_03.Student@125b76ef
     *                onCreate: student1 = app.yjkm.com.day_03.Student@125b76ef
     *                setData: student.name = student1
     *                setData: student1.name = student1
     *                <p>
     *                可以看到student 和student1其实在堆中保存的地址是一样的
     *                说明student 和student1 持有的地址引用是一样的
     *                所以在student1 改名后student的名字也会改变
     */
    private void setData(Student student) {
        String name = student.name;
        Student student1 = student;
        student1.name = "student1";
        Log.e("text123", "setData: name = " + name);

        Log.e("text123", "onCreate: student = " + student);
        Log.e("text123", "onCreate: student1 = " + student1);

        Log.e("text123", "setData: student.name = " + student.name);
        Log.e("text123", "setData: student1.name = " + student1.name);
    }


    /**
     * 浅拷贝
     *
     * @param student clone_0: name = 我的世界
     *                clone_0: student = app.yjkm.com.day_03.Student@125b76ef
     *                clone_0: StudentClone = app.yjkm.com.day_03.Student@1b08a5fc
     *                clone_0: student.name = 我的世界
     *                clone_0: student1.name = 浅拷贝
     *                clone_0: teachers = []
     *                clone_0: teachers1 = []
     *
     *                可以看到student和studentClone 所持有引用的地址是不一样的
     *                所以 student和studentClone是两个类了 所以当studentClone的name修改的时候
     *                student的name 是没有受到影响
     *
     *                但是在student的teachers和studentClone 的 teachers 缺还是持有的同一个地址
     *                如果在复写clone函数的时候也是用的teacher的clone函数才会把student里面的
     *                teacher类也clone那就是深拷贝了
     *
     *                深拷贝
     *                clone_0: teachers = [
     *                app.yjkm.com.day_03.Teacher@229a485,
     *                app.yjkm.com.day_03.Teacher@1fb9c2da,
     *                app.yjkm.com.day_03.Teacher@2a12930b,
     *                app.yjkm.com.day_03.Teacher@183825e8,
     *                app.yjkm.com.day_03.Teacher@24e50401]
     *
     *                clone_0: teachers1 = []
     *
     */
    private void clone_0(Student student) {
        String name = student.name;
        Student StudentClone = student.clone();
        StudentClone.name = "浅拷贝";
        Log.e("text123", "clone_0: name = " + name);
        Log.e("text123", "clone_0: student = " + student);
        Log.e("text123", "clone_0: StudentClone = " + StudentClone);
        Log.e("text123", "clone_0: student.name = " + student.name);
        Log.e("text123", "clone_0: student1.name = " + StudentClone.name);

        List<Teacher> teachers = student.teachers;
        List<Teacher> teachers1 = StudentClone.teachers;
        teachers1.clear();
        Log.e("text123", "clone_0: teachers = " + teachers);
        Log.e("text123", "clone_0: teachers1 = " + teachers1);
    }


}

```


### 优点

原型模式是在内存中二进制流的拷贝,要比直接new一个对象性能要好很多
特别是要在一个循环体内产生大量对象的时候,原型模式可以更好的体现其优点

### 缺点

直接在内存中拷贝 是不会执行构造函数的,在实际开发中要注意这个潜在的问题
优点是减少约束缺点是少了约束
