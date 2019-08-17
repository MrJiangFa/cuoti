package annotation.annotationprocessor;

public class TestMyAnnotationProcessor {
    @CustomAnnotation(name = "jj", value = 2)
    String field1;
    @CustomAnnotation(name = "fafa", value = 3)
    String field2;

    TestMyAnnotationProcessor(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public static void main(String[] args) {
        TestMyAnnotationProcessor tm = new TestMyAnnotationProcessor("jj", "fafa");
        System.out.println("hello" + tm.field1 + tm.field2);
    }
}
