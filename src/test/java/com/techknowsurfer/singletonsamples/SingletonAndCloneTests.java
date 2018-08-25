package com.techknowsurfer.singletonsamples;

import com.techknowsurfer.singletonsamples.clone.EagerSingletonClonePrevention;
import com.techknowsurfer.singletonsamples.clone.EagerSingletonExtendsCloneable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class SingletonAndCloneTests {

    @Test
    public void testCloneAndSingleton_Success() throws CloneNotSupportedException {
        EagerSingletonExtendsCloneable eagerSingletonExtendsCloneable = EagerSingletonExtendsCloneable.getInstance();
        EagerSingletonExtendsCloneable eagerSingletonExtendsCloneable1 = (EagerSingletonExtendsCloneable) eagerSingletonExtendsCloneable.clone();

        System.out.println("eagerSingletonExtendsCloneable hash code " + eagerSingletonExtendsCloneable.hashCode());
        System.out.println("eagerSingletonExtendsCloneable1 hash code " + eagerSingletonExtendsCloneable1.hashCode());

        Assert.assertNotEquals(eagerSingletonExtendsCloneable.hashCode(),eagerSingletonExtendsCloneable1.hashCode());
    }

    @Test
    public void testCloneAndSingleton_Failure() throws CloneNotSupportedException {
        EagerSingletonClonePrevention eagerSingletonClonePrevention = EagerSingletonClonePrevention.getInstance();
        EagerSingletonClonePrevention eagerSingletonClonePrevention1 = (EagerSingletonClonePrevention) eagerSingletonClonePrevention.clone();

        System.out.println("eagerSingletonExtendsCloneable hash code " + eagerSingletonClonePrevention.hashCode());
        System.out.println("eagerSingletonExtendsCloneable1 hash code " + eagerSingletonClonePrevention1.hashCode());

        Assert.assertEquals(eagerSingletonClonePrevention.hashCode(),eagerSingletonClonePrevention1.hashCode());

    }

}
