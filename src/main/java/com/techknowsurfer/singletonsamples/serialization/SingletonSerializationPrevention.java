package com.techknowsurfer.singletonsamples.serialization;

import java.io.Serializable;

public class SingletonSerializationPrevention implements Serializable{

    /** Static member to hold only single instance of the object */
    private static SingletonSerializationPrevention singletonSerializationPrevention;

    /** Private Constructor to prevent the initialization of the  class   */
    private SingletonSerializationPrevention(){}

    /** Static Public method to get the instance of the class
     *  Adding synchronized for the thread safety
     * */
    public static synchronized SingletonSerializationPrevention getInstance(){
        /** Checking if the instance is already created, if yes return the same instance or else create a new one  */
        if(null == singletonSerializationPrevention){
            singletonSerializationPrevention =  new SingletonSerializationPrevention();
        }
        return singletonSerializationPrevention;
    }

    /** Return the same instance*/
    protected Object readResolve() {
        return singletonSerializationPrevention;
    }
}
