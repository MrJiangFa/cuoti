package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object object;
    public DynamicProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyInvocaitonHandler invoke begin");
        //获得代理对象类型的名称
        System.out.println("proxy" + proxy.getClass().getName());
        System.out.println("method" + method.getName());
        for(Object ob : args){
            System.out.println("arg"+ob);
        }
        //通过反射调用被代理类的方法
        method.invoke(object,args);
        System.out.println("MyInvocationHandler invoke end");
        return null;
    }
    public static void main(String[] args){
        Student s = new Student();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","ture");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces  = s.getClass().getInterfaces();
        DynamicProxy d = new DynamicProxy(s);
        Person proxy = (Person) Proxy.newProxyInstance(classLoader,interfaces,d);
        proxy.sayHello("jiang",20);
        proxy.sayGoodBye(true,100);
        System.out.println("end");
    }
}
