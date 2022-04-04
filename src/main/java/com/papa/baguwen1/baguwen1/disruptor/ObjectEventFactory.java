package com.papa.baguwen1.baguwen1.disruptor;

import com.lmax.disruptor.EventFactory;

public class ObjectEventFactory<T> implements EventFactory<ObjectEvent<T>> {
    @Override
    public ObjectEvent<T> newInstance() {
        return new ObjectEvent();
    }
}
