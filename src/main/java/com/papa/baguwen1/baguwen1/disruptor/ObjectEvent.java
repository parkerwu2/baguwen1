package com.papa.baguwen1.baguwen1.disruptor;

/*事件对象*/
public class ObjectEvent<T> {
    private T obj;

    public ObjectEvent() {
    }

    public T getObj() {
        return this.obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
