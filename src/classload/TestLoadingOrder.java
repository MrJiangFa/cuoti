package classload;


public class TestLoadingOrder {

    int get(int a,int b){
        return 1;
    }
    static {
        System.out.println("静态块");
    }

    {
        System.out.println("代码块");
    }

    public TestLoadingOrder() {

        System.out.println("构造了");
    }



    public static void main(String[] args) {
        new TestLoadingOrder();
    }
}
