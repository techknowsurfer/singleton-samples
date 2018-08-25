package com.techknowsurfer.singletonsamples.singleton;

public class LazyInnerClassSingleton {

    /** Private Constructor to prevent the initialization of the  class */
    private LazyInnerClassSingleton(){ }

    /** Static inner helper class to return the instance of the Singleton Object */
    private static class LazyInnerClassSingletonHelper{
        private static final LazyInnerClassSingleton LAZY_INNER_CLASS_SINGLETON = new LazyInnerClassSingleton();
    }

    /** Static Public method to get the instance of the class */
    public static LazyInnerClassSingleton getInstance(){
        return LazyInnerClassSingletonHelper.LAZY_INNER_CLASS_SINGLETON;
    }
}
