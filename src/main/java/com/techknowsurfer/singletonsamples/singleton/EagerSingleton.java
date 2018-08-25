package com.techknowsurfer.singletonsamples.singleton;

public class EagerSingleton {

    /** Static member to hold only single instance of the object */
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    /** Private Constructor to prevent the initialization of the  class   */
    private EagerSingleton(){}

    /** Static Public method to get the instance of the class */
    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}
