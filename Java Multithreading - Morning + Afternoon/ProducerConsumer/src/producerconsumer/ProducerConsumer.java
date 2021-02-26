
package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

 class Producer extends Thread {
     private Queue<Integer> queue;
     private int maxSize;
     public Producer(Queue<Integer> queue, int maxSize){
         this.queue = queue;
         this.maxSize = maxSize;
     }
     int increase = 0;
     @Override
     public void run() {
         while (true) {
             synchronized (queue) {
                 while (queue.size() == maxSize) {
                     try {
                         System.out .println("Producer thread waiting " );
                         queue.wait();
                     } catch (Exception ex) {
                         ex.printStackTrace();
                     }
                 }
                 System.out.println("Producer : " + increase);
                 queue.add(increase++);
                 queue.notifyAll();

                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

             }
         }
     }
 }

 class Consumer extends Thread {
     private Queue<Integer> queue;
     private int maxSize;
     public Consumer(Queue<Integer> queue, int maxSize){
         this.queue = queue;
         this.maxSize = maxSize;
     }
     @Override
     public void run() {
         while (true) {
             synchronized (queue) {
                 while (queue.isEmpty()) {
                     System.out.println("Consumer thread is waiting" );
                     try {
                         queue.wait();
                     } catch (Exception ex) {
                         ex.printStackTrace();
                     }
                 }
                 System.out.println("Consumer : " + queue.remove());
                 queue.notifyAll();
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
 }

public class ProducerConsumer {
    public static void main(String args[]) {
        Queue<Integer> storage = new LinkedList<>();
        Thread producer = new Producer(storage, 5);
        Thread consumer = new Consumer(storage, 5);
        producer.start();
        consumer.start();
    }
}