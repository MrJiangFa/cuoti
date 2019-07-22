package design_parttern.chain_patter;

import java.util.Arrays;
import java.util.List;

public class EfficientChainPattern {
    static abstract class ChainHandler {
        public void execute(Chain chain) {
            handle();
            chain.proceed();
        }

        protected abstract void handle();
    }

    static class Chain {
        private List<ChainHandler> handlers;

        public Chain(List<ChainHandler> handlers) {
            this.handlers = handlers;
        }

        private int index = 0;

        public void proceed() {
            if (index >= handlers.size()) {
                return;
            }
            handlers.get(index++).execute(this);
        }
    }

    static class ChainClient {
        static class ChainHandlerA extends ChainHandler {

            @Override
            protected void handle() {
                System.out.println("handle by handlerA");
            }
        }

        static class ChainHandlerB extends ChainHandler {

            @Override
            protected void handle() {
                System.out.println("handle by handlerB");
            }
        }

        static class ChainHandlerC extends ChainHandler {

            @Override
            protected void handle() {
                System.out.println("handle by handlerC");
            }
        }

        public static void main(String[] args) {
            List<ChainHandler> handlers = Arrays.asList(new ChainHandlerA(),new ChainHandlerB(),new ChainHandlerC());
            Chain chain = new Chain(handlers);
            chain.proceed();
        }
    }
}
