package org.example.day6;

public class SingletonDemo {
    public static void main(String[] args) {

    }
}

// eager loading
class Singleton1 {
    private static final Singleton1 instnace = new Singleton1();
    private Singleton1() {

    }
    public static Singleton1 getInstance() {
        return instnace;
    }
}

// lazy loading, double check locking
class Singleton2 {
    // The CPU will do the instruction reorder to optimize the implementation
    // volatile to prevent instruction reorder
    // we make Singleton2 as a default value null, because this is a lazy loading, we don't want to initialize it
    private static volatile Singleton2 instance;
    // private constructor can prevent create object by others
    private Singleton2() {}
    // If we use synchronized keyword in method signature, it will lock whole object, not efficient
    // we only need lock when the object create the instance
    public static Singleton2 getInstance() {
        if (instance == null) {
            // use synchronized block to keep thread-safe,
            // if not use when two or more thread use this Singleton at the same time,
            // they will create two or more instance globally at the same time
            synchronized(Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                    // 1 create instance reference
                    // 2 new singleton();
                    // 3 instance reference points to instance object,
                    // 1 -> 2 ->  3
                    // 1 -> 3 ->  2
                }
            }
        }
        return instance;
    }
}
