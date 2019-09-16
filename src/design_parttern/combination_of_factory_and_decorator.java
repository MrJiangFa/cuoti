package design_parttern;

public class combination_of_factory_and_decorator {
    interface Human {
        void wearClothes();

        void walkToWhere();

        default void description() {
            System.out.println("父类的default方法");
        }
    }

    static abstract class Decorator implements Human {
        private Human human;

        public Decorator(Human human) {
            this.human = human;
        }

        public void wearClothes() {
            human.wearClothes();
        }

        public void walkToWhere() {
            human.walkToWhere();
        }
    }

    static class Decorator_zero extends Decorator {
        public Decorator_zero(Human human) {
            super(human);
        }

        public void wearShirt() {
            System.out.println("穿短袖");
        }

        public void findBook() {
            System.out.println("找书");
        }

        @Override
        public void wearClothes() {
            super.wearClothes();
            wearShirt();
        }

        @Override
        public void walkToWhere() {
            super.walkToWhere();
            findBook();
        }
    }

    static class Person implements Human {
        @Override
        public void wearClothes() {
            System.out.println("穿什么");
        }

        @Override
        public void walkToWhere() {
            System.out.println("去哪里");
        }

        /**
         * 方法重写的原则为：两同，两小，一大；
         * 两同：方法名和参数列表相同；
         * 两小：子类方法的返回值类型小于父类方法的返回值类型；
         * 一大：子类方法的访问权限要大于子类方法；
         */
        @Override
        public void description(){

        }
    }

    public static void main(String[] args) {
        Human person = new Person();
        Decorator decorator = new Decorator_zero(person);
        decorator.wearClothes();
        decorator.walkToWhere();
    }

}
