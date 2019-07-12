package annotation.mybatis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Main {
    @PassParameter({"#{age}","#{height}"})
    public void testParameter(@Parameter("age")int age,@Parameter("heigth")int height){

    }
    public static void main(String[] args){
        Class main = Main.class;
        for(Method method : main.getDeclaredMethods()){
            PassParameter pp = method.getAnnotation(PassParameter.class);
            if(pp!=null){
                String[] ss = pp.value();
                HashMap<String,Integer> hashMap = new HashMap<>();
                for(java.lang.reflect.Parameter parameter : method.getParameters()){
                    Parameter p = parameter.getAnnotation(Parameter.class);

                }
            }
        }
    }
}
