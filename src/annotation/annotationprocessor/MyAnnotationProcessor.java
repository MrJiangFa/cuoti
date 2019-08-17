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
import java.util.logging.Logger;

//@AutoService(MyAnnotationProcessor.class)  //注册该注解处理器的方式
@SupportedAnnotationTypes({"annotation.annotationprocessor.CustomAnnotation"})
public class MyAnnotationProcessor extends AbstractProcessor {
    private Messager messager;
    private int count = 0;
    private int forCount = 0;
    private StringBuilder res = new StringBuilder();
    private static final Logger logger = Logger.getLogger("annotation.annotationprocessor.MyAnnotationProcessor");

    @Override
    public synchronized void init(ProcessingEnvironment environment) {
        super.init(environment);
        messager = environment.getMessager();
        logger.info("enter init ....");
    }

    private void printMssage(String msg) {
        messager.printMessage(Diagnostic.Kind.ERROR, msg);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        logger.info("enter process");
        HashMap<String, String> map = new HashMap<>();//calssname->输出语句
        //得到使用 @CustomAnnotation 注解的元素
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(CustomAnnotation.class);
        for (Element element : elements) {
            VariableElement ve = (VariableElement) element;
            forCount++;
            TypeElement te = (TypeElement) ve.getEnclosingElement();//得到其包裹类型，即父类型
            String className = te.getQualifiedName().toString();
            res.append("className= " + className);
            res.append("\t fieldName= " + ve.getSimpleName().toString());
            CustomAnnotation ca = ve.getAnnotation(CustomAnnotation.class);//获取被注解对象ve上被注解的@CustomAnnotation注解对象

            //通过解析注解中相关元素的值，可以依据值的提示对标注了注解的字段进行相应操作；
            res.append("field name: " + ca.name()).append("field value: " + ca.value());
        }
        return false;
    }

    /**
     * 指定支持的注解类型，也可以通过 @SupportedAnnotationTypes 注解声明本处理器要处理的注解类型全限定名
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
     * 指定支持的java版本
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
