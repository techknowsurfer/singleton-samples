package com.techknowsurfer.singletonsamples.clone;

/** Singleton class extending Cloneable super class */
public class EagerSingletonExtendsCloneable extends CloneableSuperClass {

    /** Static member to hold only single instance of the object */
    private static EagerSingletonExtendsCloneable eagerSingleton = new EagerSingletonExtendsCloneable();

    /** Private Constructor to prevent the initialization of the  class   */
    private EagerSingletonExtendsCloneable(){}

    /** Static Public method to get the instance of the class */
    public static EagerSingletonExtendsCloneable getInstance() {
        return eagerSingleton;
    }
}
