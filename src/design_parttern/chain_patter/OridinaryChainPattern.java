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
                successor.execute();
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
        static class HandlerC extends Handler{
            @Override
            public void handle(){
                System.out.println("handle by HandlerC");
            }
        }

        public static void main(String[] args) {
            HandlerA handlerA = new HandlerA();
            HandlerB handlerB = new HandlerB();
            HandlerC handlerC = new HandlerC();
            handlerA.setSuccessor(handlerB);
            handlerB.setSuccessor(handlerC);
            handlerA.execute();
        }
    }
}
