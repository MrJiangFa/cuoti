package design_parttern;

/**
 * 通过适配器，将客户和被适配者解耦；
 *
 * 将一个类的接口转化成客户期望的另一个接口；headfirst P243
 *
 * 类适配器——在支持多继承的语言中可以使用类适配器，适配器类既继承了被适配者也继承了目标接口；
 *
 * 当一个适配器包装多个适配者时——外观模式/装饰者模式，可以以此来实现代替实现多态的功能；
 *
 * <p>
 * 类适配器模式：Adapter既实现了目标接口，也继承了源父类，暴露了源父类中的方法；
 */
class AC220V {
    public int outPut220V() {
        int output = 220;
        return output;
    }
}

interface DC5V {
    int outPut5V();
}

class Adapter extends AC220V implements DC5V {
    @Override
    public int outPut5V() {
        int output = outPut220V();
        return output / 44;
    }
}

/**
 * 对象适配器模式：Adapter类取消继承源父类，改用构造器传参的方式实现
 * <p>
 * 适配器实现目标接口，通过引入源父类的对象；
 */
class AdapterByObject implements DC5V {
    private AC220V ac220V;

    //可以利用构造器重载的方式代替实现多态的功能；
    public AdapterByObject(AC220V ac220V) {
        this.ac220V = ac220V;
    }

    @Override
    public int outPut5V() {
        int output = 0;
        if (ac220V != null)
            output = ac220V.outPut220V() / 44;
        return output;
    }
}

/**
 * 接口适配器模式：可以不单单着眼于220v-5v的适配转换，接口中可以有更多的方法，可以有
 * outPut10V();
 * outPut20V();
 * outPut30V();
 * outPut40V();.....
 */
interface Destination {
    int outPut10V();

    int outPut20V();

    int outPut30V();

}

//增加抽象类减少代码重写的工作量；
abstract class AbstractAdapter implements Destination {
    protected AC220V ac220V;

    public AbstractAdapter(AC220V ac220V) {
        this.ac220V = ac220V;
    }

    @Override
    public int outPut10V() {
        return 0;
    }

    @Override
    public int outPut20V() {
        return 0;
    }

    @Override
    public int outPut30V() {
        return 0;
    }
}

class Power10VAdapter extends AbstractAdapter {
    public Power10VAdapter(AC220V ac220V) {
        super(ac220V);
    }

    @Override
    public int outPut10V() {
        int output = 0;
        if (ac220V != null) {
            output = ac220V.outPut220V() / 22;
        }
        return output;
    }
}

public class AdapterPattern {

}
