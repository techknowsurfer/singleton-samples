package com.techknowsurfer.singletonsamples.clone;

/** Super class implementing the Cloneable interface */
public class CloneableSuperClass implements Cloneable {

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
