package design_parttern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 允许开发人员使用不同的标准来过滤一组对象
 */
public class FilterPattern {
    static class Person {
        private String name;
        private String gendar;

        Person(String name, String gendar) {
            this.name = name;
            this.gendar = gendar;
        }

        public String getName() {
            return name;
        }

        public String getGendar() {
            return gendar;
        }
    }

    interface Criteria {
        List<Person> meetCriteria(List<Person> persons);
    }

    static class CriteriaMale implements Criteria {
        @Override
        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> malePersons = new ArrayList<>();
            for (Person person : persons) {
                if (person.gendar.equalsIgnoreCase("male")) {
                    malePersons.add(person);
                }
            }
            return malePersons;
        }
    }

    static class CriteriaFemale implements Criteria {
        @Override
        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> femalePersons = new ArrayList<>();
            for (Person person : persons) {
                if (person.gendar.equalsIgnoreCase("female")) {
                    femalePersons.add(person);
                }
            }
            return femalePersons;
        }
    }

    /**
     * 求两个结果集的交集
     */
    static class AndCriteria implements Criteria {
        private Criteria criteria;
        private Criteria otherCriteria;

        AndCriteria(Criteria criteria, Criteria otherCriteria) {
            this.criteria = criteria;
            this.otherCriteria = otherCriteria;
        }

        @Override
        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
            return otherCriteria.meetCriteria(firstCriteriaPersons);
        }
    }

    /**
     * 对两个标准的结果进行或运算，第一个标准的结果对比第二个标准的结果，求两个结果集的并集
     */
    static class OrCriteria implements Criteria {
        private Criteria criteria;
        private Criteria otherCriteria;

        @Override
        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
            List<Person> otherCriteriaPersons = otherCriteria.meetCriteria(persons);
            for (Person person : firstCriteriaPersons) {
                if (!otherCriteriaPersons.contains(person)) {
                    otherCriteriaPersons.add(person);
                }
            }
            return otherCriteriaPersons;
        }
    }

    /**
     * 过滤操作在java8中的典型应用就是分组操作
     */
    public static void testJava8Group() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                persons.add(new Person(String.valueOf(i), "female"));
            } else {
                persons.add(new Person(String.valueOf(i), "male"));
            }
        }
        Map<String, List<Person>> groupMap = persons.stream().collect(Collectors.groupingBy(Person::getGendar));
        groupMap.forEach((k, v) -> {
            System.out.print(k + ":");
            v.forEach(p -> System.out.print(p.getName() + ","));
        });
    }

    public static void main(String[] args) {
        testJava8Group();
    }


}
