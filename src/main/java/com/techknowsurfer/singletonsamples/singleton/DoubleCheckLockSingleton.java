package com.techknowsurfer.singletonsamples.singleton;

public class DoubleCheckLockSingleton {
    /** Static member to hold only single instance of the object
     *  Adding volatile to prevent the member variable to getting cached in threads
     * */
    private static volatile DoubleCheckLockSingleton doubleCheckLockSingleton;

    /** Private Constructor to prevent the initialization of the  class   */
    private DoubleCheckLockSingleton(){}

    /** Static Public method to get the instance of the class */
    public static DoubleCheckLockSingleton getInstance(){
        /** Adding the first check */
        if(null == doubleCheckLockSingleton){
            synchronized (DoubleCheckLockSingleton.class){
                /** Adding the second check */
                if(null == doubleCheckLockSingleton){
                    doubleCheckLockSingleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return doubleCheckLockSingleton;
    }
}
