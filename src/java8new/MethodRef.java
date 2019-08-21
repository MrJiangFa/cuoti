package java8new;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MethodRef {
    public static void create(MethodRef ref){
        System.out.println("create a car ... ");
    }

    public void print(){
        System.out.println("instance print ... ");
    }

    public static void main(String[] args) {
        List<MethodRef> list = Arrays.asList(new MethodRef());
        MethodRef ref = new MethodRef();

        list.forEach(MethodRef::create);
    }


}
