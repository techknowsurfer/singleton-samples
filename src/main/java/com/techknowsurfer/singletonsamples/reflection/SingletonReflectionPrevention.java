package com.techknowsurfer.singletonsamples.reflection;

public class SingletonReflectionPrevention {

    private static SingletonReflectionPrevention singletonReflectionPrevention;
    /** Private Constructor to prevent the initialization of the  class */
    private SingletonReflectionPrevention() {

        /** Prevention against the reflection*/
        if (singletonReflectionPrevention != null) {
            throw new IllegalStateException("Class already initialized ");
        }
    }
    public static synchronized SingletonReflectionPrevention getInstance(){
        /** Checking if the instance is already created, if yes return the same instance or else create a new one  */
        if(null == singletonReflectionPrevention){
            singletonReflectionPrevention =  new SingletonReflectionPrevention();
        }
        return singletonReflectionPrevention;
    }
}
