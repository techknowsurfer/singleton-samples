package com.techknowsurfer.singletonsamples.singleton;

import java.io.Serializable;

public class LazySingleton implements Serializable{

    /** Static member to hold only single instance of the object */
    private static LazySingleton lazySingleton;

    /** Private Constructor to prevent the initialization of the  class   */
    private LazySingleton(){}

    /** Static Public method to get the instance of the class
     *  Adding synchronized for the thread safety
     * */
    public static synchronized LazySingleton getInstance(){
        /** Checking if the instance is already created, if yes return the same instance or else create a new one  */
        if(null == lazySingleton){
            lazySingleton =  new LazySingleton();
        }
        return lazySingleton;
    }
}
