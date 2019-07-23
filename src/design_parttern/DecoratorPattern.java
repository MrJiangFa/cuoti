package design_parttern;

/**
 * 装饰器模式：创建一个装饰器类，用来包装原来的类，保持类签名完整性的前提下，提供额外功能
 * 应用：在不想增加很多子类的时候扩展类
 */
public class DecoratorPattern {
    interface Shape {
        void draw();
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("rectangle");
        }
    }

    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("circle");
        }
    }

    static abstract class ShapeDecorator implements Shape {
        protected Shape decoratedShape;

        ShapeDecorator(Shape decoratedShape) {
            this.decoratedShape = decoratedShape;
        }

        @Override
        public void draw() {
            decoratedShape.draw();
        }
    }

    static class RedShapeDecorator extends ShapeDecorator {
        RedShapeDecorator(Shape decoratedShape) {
            super(decoratedShape);
        }

        @Override
        public void draw() {
            decoratedShape.draw();
            setRedBorder(decoratedShape);
        }

        private void setRedBorder(Shape shape) {
            System.out.println("Border clolor: red");
        }
    }
}
