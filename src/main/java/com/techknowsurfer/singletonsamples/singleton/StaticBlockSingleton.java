package com.techknowsurfer.singletonsamples.singleton;


public class StaticBlockSingleton {
    /** Static member to hold only single instance of the object */
    private static StaticBlockSingleton staticBlockSingleton;

    /** Private Constructor to prevent the initialization of the  class   */
    private StaticBlockSingleton(){ }

    /** Initializing the instance in the static block surrounded with a try-catch block */
    static {
        try {
            staticBlockSingleton = new StaticBlockSingleton();
        } catch (Exception e){
            throw e;
        }
    }

    /** Static Public method to get the instance of the class */
    public static StaticBlockSingleton getInstance(){
        return staticBlockSingleton;
    }
}
