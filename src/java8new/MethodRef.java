package java8new;

import java.util.Arrays;

public class MethodRef {
    static class Person {
        private int age;

        public int getAge() {
            return age;
        }

        Person(int age) {
            this.age = age;
        }

        public static int compareByAge(Person a, Person b) {
            return a.getAge() - b.getAge();
        }
    }

    public static void main(String[] args) {
        testMethodRef();
    }

    public static void testMethodRef() {
        int[] ages = new int[]{1, 2, 3, 43, 345, 36, 354, 42, 34, 2, 56, 3, 74, 764};
        Person[] persons = new Person[ages.length];
        for (int i = 0; i < ages.length; i++) {
            persons[i] = new Person(ages[i]);
        }
        Arrays.stream(persons).sorted(Person::compareByAge);//静态方法引用
        //super::methodName
        //this::equals
        Arrays.stream(persons).sorted((Person a, Person b) -> OperationFactory.getSub().operation(a.getAge(), b.getAge()));

    }

    static interface Operation {
        int operation(int a, int b);
    }

    static class OperationFactory {
        private static final Operation add = (a, b) -> a + b;
        private static final Operation sub = (a, b) -> a - b;
        private static final Operation multi = (a, b) -> a * b;
        private static final Operation div = (a, b) -> a / b;

        public static Operation getSub() {
            return sub;
        }

        public static Operation getMulti() {
            return multi;
        }

        public static Operation getDiv() {
            return div;
        }

        public static Operation getAdd() {
            return add;
        }

    }
}
