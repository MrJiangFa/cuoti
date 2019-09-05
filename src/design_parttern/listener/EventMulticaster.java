//package design_parttern.listener;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//public class EventMulticaster {
//    private Map<ListenerCacheKey,>;
//
//    protected Collection<Listener> getListeners(Event event, ResovableType eventType) {
//        Object source = event.getSource();
//        Class<?> sourceType = source != null ? source.getClass() : null;
//        ListenerCacheKey cacheKey = new ListenerCacheKey();
//
//    }
//
//    private static final class ListenerCacheKey implements Comparable<ListenerCacheKey> {
//        private final ResolvableType eventType;
//        private final Class<?> sourceType;
//
//        ListenerCacheKey(ResolvableType eventType, Class<?> sourceType) {
//            this.eventType = eventType;
//            this.sourceType = sourceType;
//        }
//
//        @Override
//        public boolean equals(Object other) {
//            if (this == other) {
//                return true;
//            }
//            ListenerCacheKey otherKey = (ListenerCacheKey) other;
//            return this.eventType.equals(otherKey.eventType) && nullSafeEquals(this, otherKey);
//        }
//
//
//        @Override
//        public String toString() {
//            return "ListenerCacheKey [eventType = " + this.eventType + ", sourceType = " + this.sourceType + "]";
//        }
//
//
//        @Override
//        public int compareTo(ListenerCacheKey o) {
//            int result = this.eventType.toString().compareTo(o.eventType.toString());
//            if (result < 0) {
//
//            }
//        }
//    }
//
//    private static boolean nullSafeEquals(Object o1, Object o2) {
//        if (o1 == o2) {
//            return true;
//        }
//        if (o1 == null || o2 == null) {
//            return false;
//        }
//        if (o1.equals(o2)) {
//            return true;
//        }
//        if (o1.getClass().isArray() && o2.getClass().isArray()) {
//            return arrayEquals(o1, o2);
//        }
//        return false;
//    }
//
//    private static boolean arrayEquals(Object o1, Object o2) {
//        if (o1 instanceof Object[] && o2 instanceof Object[]) {
//            return Arrays.equals((Object[]) o1, (Object[]) o2);
//        }
//        if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
//            return Arrays.equals((boolean[]) o1, (boolean[]) o2);
//        }
//        if (o1 instanceof byte[] && o2 instanceof byte[]) {
//            return Arrays.equals((byte[]) o1, (byte[]) o2);
//        }
//        if (o1 instanceof char[] && o2 instanceof char[]) {
//            return Arrays.equals((char[]) o1, (char[]) o2);
//        }
//        if (o1 instanceof double[] && o2 instanceof double[]) {
//            return Arrays.equals((double[]) o1, (double[]) o2);
//        }
//        if (o1 instanceof float[] && o2 instanceof float[]) {
//            return Arrays.equals((float[]) o1, (float[]) o2);
//        }
//        if (o1 instanceof int[] && o2 instanceof int[]) {
//            return Arrays.equals((int[]) o1, (int[]) o2);
//        }
//        if (o1 instanceof long[] && o2 instanceof long[]) {
//            return Arrays.equals((long[]) o1, (long[]) o2);
//        }
//        if (o1 instanceof short[] && o2 instanceof short[]) {
//            return Arrays.equals((short[]) o1, (short[]) o2);
//        }
//        return false;
//    }
//}
