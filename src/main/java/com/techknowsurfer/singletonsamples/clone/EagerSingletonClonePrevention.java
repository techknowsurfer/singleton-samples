package com.techknowsurfer.singletonsamples.clone;

public class EagerSingletonClonePrevention extends CloneableSuperClass {

    /** Static member to hold only single instance of the object */
    private static EagerSingletonClonePrevention eagerSingleton = new EagerSingletonClonePrevention();

    /** Return the same instance if clone method is called*/
    @Override
    public Object clone() {
        return eagerSingleton;
    }

    /** Throw the exception CloneNotSupportedException */
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }*/
    /** Private Constructor to prevent the initialization of the  class   */
    private EagerSingletonClonePrevention(){}

    /** Static Public method to get the instance of the class */
    public static EagerSingletonClonePrevention getInstance() {
        return eagerSingleton;
    }
}
