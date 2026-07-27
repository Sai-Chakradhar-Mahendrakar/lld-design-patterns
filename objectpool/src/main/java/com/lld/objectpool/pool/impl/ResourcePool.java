package com.lld.objectpool.pool.impl;

import com.lld.objectpool.exception.PoolExhaustedException;
import com.lld.objectpool.model.ExpensiveResource;
import com.lld.objectpool.pool.ObjectPool;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Component
public class ResourcePool implements ObjectPool<ExpensiveResource> {
    private final BlockingQueue<ExpensiveResource> pool;
    private static final int POOL_SIZE = 5;
    private static final long BORROW_TIMEOUT_SECONDS = 3;

    public ResourcePool() {
        pool = new LinkedBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.offer(new ExpensiveResource());
        }
    }

    @Override
    public ExpensiveResource borrowObject() throws InterruptedException {
        ExpensiveResource resource = pool.poll(BORROW_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (resource == null) {
            throw new PoolExhaustedException(
                    "No resources available in pool after waiting " + BORROW_TIMEOUT_SECONDS + "s");
        }
        return resource;
    }

    @Override
    public void release(ExpensiveResource instance) {
        pool.offer(instance);
    }

    public int availableCount() {
        return pool.size();
    }
}
