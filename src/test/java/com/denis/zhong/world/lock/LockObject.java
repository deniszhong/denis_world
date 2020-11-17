package com.denis.zhong.world.lock;

public class LockObject {

    public LockObject(String lockKey) {
        this.lockKey = lockKey;
    }

    private String lockKey;

    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(String lockKey) {
        this.lockKey = lockKey;
    }
}
