package com.techknowsurfer.singletonsamples;

import com.techknowsurfer.singletonsamples.reflection.SingletonReflectionPrevention;
import com.techknowsurfer.singletonsamples.singleton.LazyInnerClassSingleton;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class SingletonAndReflectionTests {

    @Test
    public void testSingletonAndReflection_Success(){
        LazyInnerClassSingleton lazyInnerClassSingleton = LazyInnerClassSingleton.getInstance();
        LazyInnerClassSingleton lazyInnerClassSingleton1 = null;

        Constructor[] constructors =  LazyInnerClassSingleton.class.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            constructor.setAccessible(true);
            try {
                log.info("Creating the clone");
                lazyInnerClassSingleton1 = (LazyInnerClassSingleton) constructor.newInstance();
                break;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        System.out.println("lazyInnerClassSingleton hash code " + lazyInnerClassSingleton.hashCode());
        System.out.println("lazyInnerClassSingleton1 hash code " + lazyInnerClassSingleton1.hashCode());

        Assert.assertNotEquals(lazyInnerClassSingleton.hashCode(),lazyInnerClassSingleton1.hashCode());
    }

    @Test(expected = IllegalStateException.class)
    public void testSingletonAndReflection_Failure(){
        SingletonReflectionPrevention reflectionPrevention = SingletonReflectionPrevention.getInstance();

        Constructor[] constructors =  SingletonReflectionPrevention.class.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            constructor.setAccessible(true);
            try {
                log.info("Creating the clone");
                SingletonReflectionPrevention reflectionPrevention1 = (SingletonReflectionPrevention) constructor.newInstance();
                break;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
