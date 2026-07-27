package com.lld.objectpool.service;

import com.lld.objectpool.model.ExpensiveResource;
import com.lld.objectpool.pool.impl.ResourcePool;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    private final ResourcePool resourcePool;
    public ResourceService(ResourcePool resourcePool) {
        this.resourcePool = resourcePool;
    }

    public String useResource(String input) {
        ExpensiveResource resource = null;
        try {
            resource = resourcePool.borrowObject();
            return resource.process(input);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for resource", e);
        } finally {
            if (resource != null) {
                resourcePool.release(resource);
            }
        }
    }

    public int poolStatus() {
        return resourcePool.availableCount();
    }
}
