package clonetest;

import java.io.*;

public class CopyConstructor2 {
    public static void main(String[] args) throws IOException , ClassNotFoundException {
        Age age = new Age(20);
        Person p1 = new Person(age, "person1", 2);
//        Person p2 = (Person) p1.clone();
//        System.out.println(p2.age.age);
//        p1.age.age = 10;
//        System.out.println(p2.age.age);//通过逐层实现clone()方法实现深拷贝

        //通过对象序列化实现深拷贝
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bas);
        oos.writeObject(p1);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bas.toByteArray()));
        Person p2 = (Person)ois.readObject();
        System.out.println(p2.age.age);
        p1.age.age = 10;
        System.out.println(p2.age.age);
    }
}

class Person implements Cloneable, Serializable {
    Age age;
    String name;
    int length;

    Person(Age age, String name, int length) {
        this.age = age;
        this.name = name;
        this.length = length;
    }

    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Person person = (Person) object;
        person.age = (Age) person.age.clone();
        return object;
    }
}
