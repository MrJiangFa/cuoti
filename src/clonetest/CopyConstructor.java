package clonetest;

public class CopyConstructor {
    public static void main(String[] args) {
//        Age age = new Age(20);
//        Student s1 = new Student("student1", age);
//        Student s2 = new Student(s1);
//        System.out.println("student2 name is " + s2.name + ", age is " + s2.age.age);
//        s1.age.age = 30;
//        s1.name = "xiao ming";
//        System.out.println("student2 name is " + s2.name + ", age is " + s2.age.age);
//        //修改s1的引用变量age，s2的age也随着发生变化；而String进行了值传递没有发生变化
        Age age = new Age(20);
        Student student1 = new Student("xiao ming", age);
        Student student2 = clone(student1);
        System.out.println(student2.name + ": age " + student2.age.age);
        student1.age.age = 10;
        student1.name = "xiao hong";
        System.out.println(student2.name + ": age " + student2.age.age);
        System.out.println(student1.name + ": age " + student1.age.age);

    }

    public static Student clone(Student student) {
        if (student == null) {
            return null;
        }
        Student s = new Student(student.name, new Age(student.age.age));
        return s;
    }
}

class Student {
    public String name;
    public Age age;

    public Student(String name, Age age) {
        this.name = name;
        this.age = age;
    }

    //拷贝构造函数
    public Student(Student student) {
        this.name = student.name;
        this.age = student.age;
    }


}

class Age {
    int age;

    Age(int age) {
        this.age = age;
    }

    public Age clone() {
        return null;
    }
}

