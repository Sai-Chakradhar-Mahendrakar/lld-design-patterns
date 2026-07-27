package com.lld.objectpool.pool;

public interface ObjectPool<T> {
    T borrowObject() throws InterruptedException;
    void release(T instance);
}
