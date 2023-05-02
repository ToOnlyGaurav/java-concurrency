package org.problems.producerconsumer.compliant.customqueue;

public class Message<T> {
    private int id;
    private T data;

    public Message(int id, T data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
