package annotationDemo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserCaseTest {
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCase(useCases, User1DaoImpl.class);
    }
    public static void trackUseCase(List<Integer> useCase, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCases uc = m.getAnnotation(UseCases.class);
            if (uc != null){
                System.out.println("Found use Case:" + uc.id() + " " + uc.desription());
                useCase.remove(new Integer(uc.id()));
            }
            for (int i : useCase){
                System.out.println("Warning: Missing use case-" + i);
            }
        }
    }
}
