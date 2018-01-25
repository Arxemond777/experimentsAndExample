package amqp_my_test;

import java.util.*;

public class GenericWildcard
{
    public static void main(String[] args) {
        List<?> a = new ArrayList<Integer>(){
            {
                add(1);
            }
        }; //Ток на get
        System.out.println(a);
        byte[] bytes = new byte[] {127, -128};
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.asList(a));
        GenericWildcard.Ggg b = new GenericWildcard().new Ggg();
//        a.add(b);
//        a.add(new Integer(1)); //Вообще сетерить незя, тк ? означает неопределенный тип

        /*Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if( o1 > o2 ){
                    return -1;
                }
                if( o1 < o2 ){
                    return 1;
                }
                return 0;
            }
        };*/

        Queue<Integer> intQueue = new PriorityQueue<>(10, (Integer o1, Integer o2) -> {
            if( o1 > o2 ){
                return -1;
            }
            if( o1 < o2 ){
                return 1;
            }
            return 0;
        });
        intQueue.add(1);
        intQueue.add(12);
        intQueue.add(8);
        while( !intQueue.isEmpty() ){
            System.out.println( intQueue.remove() );
        }
    }

    class Ggg {
        int i = 1;
    }
}
