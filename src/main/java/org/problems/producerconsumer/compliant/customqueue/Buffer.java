package org.problems.producerconsumer.compliant.customqueue;

public class Buffer {
    private int maxSize;
    private int[] queue;
    private int front;

    private int rear;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.queue = new int[maxSize];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1) % maxSize == this.front;
    }

    public void add(int data) {
        if (!isFull()) {
            this.rear = (this.rear + 1) % maxSize;
            queue[this.rear] = data;
        }
    }

    public int remove() {
        if (!isEmpty()) {
            return queue[this.front];
        }
        return -1;
    }
}
