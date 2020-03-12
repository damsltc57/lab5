package PoolPattern;

public interface ObjectPool_IF {
    int getSize();
    int getCapacity();
    void setCapacity(int c);
    Object getObject();
    Object waitForObject();
    void release(Object o);
}