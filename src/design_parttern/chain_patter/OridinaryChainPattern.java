package design_parttern.chain_patter;

public class OridinaryChainPattern {
    static abstract class Handler {
        private Handler successor;
        public Handler getSuccessor() {
            return successor;
        }
        public void setSuccessor(Handler successor) {
            this.successor = successor;
        }
        public void execute() {
            handle();
            if (successor != null) {
                successor.handle();
            }
        }
        protected abstract void handle();
    }

    static class Client{
        static class HandlerA extends Handler{
            @Override
            public void handle(){
                System.out.println("handle by HandlerA");
            }
        }
        static class HandlerB extends Handler{
            @Override
            public void handle(){
                System.out.println("handle by HandlerB");
            }
        }

        public static void main(String[] args) {
            HandlerA handlerA = new HandlerA();
            HandlerB handlerB = new HandlerB();
            handlerA.setSuccessor(handlerB);
            handlerA.execute();
        }
    }
}
