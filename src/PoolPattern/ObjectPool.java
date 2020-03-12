package PoolPattern;

import java.util.ArrayList;
import java.util.List;

public class ObjectPool {
    private static ObjectPool poolInstance = null;
    private Object lockObject = new Object();
    private int size;
    private int instanceCount;
    private int maxInstances;
    private List<Object> pool;
    private ObjectCreation_IF creator;

    private ObjectPool(ObjectCreation_IF c, int max) {
        maxInstances = max;
        creator = c;
        pool = new ArrayList<>();
        instanceCount = 0;
    }

    public static ObjectPool getPoolInstance(ObjectCreation_IF c, int max) {
        if (poolInstance == null) {
            poolInstance = new ObjectPool(c, max);
        }
        return poolInstance;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return maxInstances;
    }

    public int getInstanceCount() {
        return instanceCount;
    }

    public void setCapacity(int maxInstances) {
        this.maxInstances = maxInstances;
    }

    private Object createObject() {
        Object pooledObject = creator.create();
        pool.add(pooledObject);
        return pooledObject;
    }

    public void release(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        synchronized (lockObject) {
            if (getSize() < getCapacity()) {
                pool.set(size, obj);
                size++;
                lockObject.notify();
            }
        }
    }

    public Object waitForObject() throws InterruptedException {
        synchronized(lockObject) {
            if (size > 0) {
                return removeObject();
            } else if (getInstanceCount() < getCapacity()) {
                return createObject();
            } else {
                do {
                    lockObject.wait();
                } while (size <= 0);
                return removeObject();
            }
        }
    }

    public Object removeObject() {
        pool.remove(0);
        return lockObject;
    }

    public Object getObject() {
        return lockObject;
    }
}