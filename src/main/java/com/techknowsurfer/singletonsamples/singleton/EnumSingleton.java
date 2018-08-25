package com.techknowsurfer.singletonsamples.singleton;

/** Enum values are initialized only once at the time of class loading*/
public enum EnumSingleton {

    SINGLETON;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
