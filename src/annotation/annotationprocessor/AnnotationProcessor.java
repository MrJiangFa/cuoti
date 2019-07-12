package annotation.annotationprocessor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SupportedAnnotationTypes({"annotation.annotationprocessor.CustomAnnotation"})
public class AnnotationProcessor extends AbstractProcessor {
    private Messager messager;
    private int count = 0;
    private int forCount = 0;
    private StringBuilder res = new StringBuilder();

    @Override
    public synchronized void init(ProcessingEnvironment environment) {
        super.init(environment);
        messager = environment.getMessager();
        String logStr = "enter init";

    }

    private void printMssage(String msg) {
        messager.printMessage(Diagnostic.Kind.ERROR, msg);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        String logStr = "enter process";
        HashMap<String, String> map = new HashMap<>();//calssname->输出语句
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(CustomAnnotation.class);
        for (Element element : elements) {
            VariableElement ve = (VariableElement) element;
            forCount++;
            TypeElement te = (TypeElement) ve.getEnclosingElement();
            String name = te.getQualifiedName().toString();
            res.append("className= "+name);
            res.append("\t fieldName= "+ve.getSimpleName().toString());
            CustomAnnotation ca = ve.getAnnotation(CustomAnnotation.class);

        }
        return false;
    }

    /**
     * 指定支持的注解类型
     *
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new HashSet<>();
        annotations.add(CustomAnnotation.class.getCanonicalName());//该方法返回该类的全限定名
        return annotations;
    }

    /**
     *
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
