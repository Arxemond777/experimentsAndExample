import java.util.concurrent.atomic.AtomicReference;

public class LinkedQueue <E> {
    private static class Node <E> {
        final E item;
        final AtomicReference<Node<E>> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(next);
        }
    }

    private AtomicReference<Node<E>> head
            = new AtomicReference<Node<E>>(new Node<E>(null, null));
    private AtomicReference<Node<E>> tail = head;

    public boolean put(E item) {
        Node<E> newNode = new Node<E>(item, null);
        while (true) {
            Node<E> curTail = tail.get();

            // residue, когда уже заполнен, но еще не сдвинут
            Node<E> residue = curTail.next.get();
            if (curTail == tail.get()) {

                // step1_thread2 находится ли очередь в промежуточном
                // состоянии перед попыткой вставки нового элемента?
                if (residue == null) /* A */ {
                    if (curTail.next.compareAndSet(null, newNode)) /* C */ {
                        // step2_thread1 тут если 1 = true
                        tail.compareAndSet(curTail, newNode) /* D */ ;
                        // Если D не удачно, то значит выполнился step3_thread2
                        // и D можно не пытаться выполнять

                        return true;
                    }
                } else {
                    // step3_thread2 помогает step2_thread1
                    tail.compareAndSet(curTail, residue) /* B */;
                }
            }
        }
    }
}