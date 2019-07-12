package annotation.p623;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method method : cl.getDeclaredMethods()) {
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null){
                System.out.println("Found use case:"+ useCase.id()+" "+useCase.description());
            }
            useCases.remove(new Integer(useCase.id()));
        }
    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,47,48,49,50);
        trackUseCases(list, PasswordUtils.class);
    }
}
