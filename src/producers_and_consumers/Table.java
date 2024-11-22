package producers_and_consumers;

import java.util.LinkedList;
import java.util.Queue;

public class Table<ProductType> {

    private final Queue<ProductType> table;
    private final int capacity;

    public Table(int capacity) {
        this.table = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void produce(ProductType product) throws InterruptedException {
        while (table.size() == capacity) {
            wait();
        }

        table.add(product);
        System.out.println(Thread.currentThread().getName() + " produced product: " + product + ".\n" +
                "Product count - " + table.size());
        notifyAll();
    }

    public synchronized ProductType consume() throws InterruptedException {
        while (table.isEmpty()) {
            wait();
        }

        ProductType product = table.poll();
        System.out.println(Thread.currentThread().getName() + " consumed product: " + product + ".\n" +
                "Product count - " + table.size());
        notifyAll();

        return product;
    }
}
