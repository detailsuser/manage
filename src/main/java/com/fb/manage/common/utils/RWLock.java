package com.fb.manage.common.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁类   可继承   也可作为对象
 * @createDate : 2017/11/7 9:03
 * @ceeateName : MEINANZI
 */
public class RWLock {
    private java.util.concurrent.locks.ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();
    //记录当前在使用该对象的线程
    private String currentThreadName;

    //初始化代码块
    {
        readWriteLock = new ReentrantReadWriteLock();
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
        currentThreadName = "";
    }

    //读锁
    public void readLock() { readLock.lock(); }
    public void readUnLock() { readLock.unlock(); }

    //写锁
    public void writeLock() {
        writeLock.lock();
        this.currentThreadName = Thread.currentThread().getName();
    }
    public void writeUnLock() {
        this.currentThreadName = "";
        writeLock.unlock();
    }

    //检查上锁状态   是否被当前线程上锁
    public boolean isThreadLock(){
        if(Thread.currentThread().getName().equals(currentThreadName)){
            //当前线程名与上锁时记录的一致   表示对象就是在当前线程被上锁的
            return true;
        }
        return false;
    }
}
