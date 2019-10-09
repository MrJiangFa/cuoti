package design_parttern;

/**
 * 装饰器模式：创建一个装饰器类，用来包装原来的类，保持类签名完整性的前提下，提供额外功能
 * 应用：在不想增加很多子类的时候扩展类
 */
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("rectangle");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("circle");
    }
}

/**
 * 类似于：对象适配器
 */
abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;//protected 修饰让其子类可以使用该属性；

    ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();

    }
}

class RedShapeDecorator extends ShapeDecorator {
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

public class DecoratorPattern {

}
