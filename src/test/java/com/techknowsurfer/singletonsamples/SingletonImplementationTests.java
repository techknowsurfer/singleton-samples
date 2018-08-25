package com.techknowsurfer.singletonsamples;

import com.techknowsurfer.singletonsamples.singleton.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class SingletonImplementationTests {

	@Test
	public void testLazySingleton() {
		LazySingleton lazySingleton = LazySingleton.getInstance();
        log.info("lazySingleton hash code [{}]",lazySingleton.hashCode());

		LazySingleton lazySingleton1 = LazySingleton.getInstance();
        log.info("lazySingleton1 hash code [{}]",lazySingleton1.hashCode());

		Assert.assertEquals(lazySingleton.hashCode(),lazySingleton1.hashCode());
	}

    @Test
    public void testEagerSingleton() {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        log.info("eagerSingleton hash code [{}]",eagerSingleton.hashCode());

        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        log.info("eagerSingleton1 hash code [{}]",eagerSingleton1.hashCode());

        Assert.assertEquals(eagerSingleton.hashCode(),eagerSingleton1.hashCode());
    }

    @Test
    public void testStaticBlockSingleton(){
	    StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getInstance();
        log.info("staticBlockSingleton hash code [{}]",staticBlockSingleton.hashCode());

        StaticBlockSingleton staticBlockSingleton1 = StaticBlockSingleton.getInstance();
        log.info("staticBlockSingleton1 hash code [{}]",staticBlockSingleton1.hashCode());

        Assert.assertEquals(staticBlockSingleton.hashCode(),staticBlockSingleton1.hashCode());
    }

    @Test
    public void testDoubleCheckLockSingleton(){
        DoubleCheckLockSingleton doubleCheckLockSingleton = DoubleCheckLockSingleton.getInstance();
        log.info("doubleCheckLockSingleton hash code [{}]",doubleCheckLockSingleton.hashCode());

        DoubleCheckLockSingleton doubleCheckLockSingleton1 = DoubleCheckLockSingleton.getInstance();
        log.info("doubleCheckLockSingleton1 hash code [{}]",doubleCheckLockSingleton1.hashCode());

        Assert.assertEquals(doubleCheckLockSingleton.hashCode(),doubleCheckLockSingleton1.hashCode());
    }

    @Test
    public void testLazyInnerClassSingleton(){
        LazyInnerClassSingleton lazyInnerClassSingleton = LazyInnerClassSingleton.getInstance();
        log.info("lazyInnerClassSingleton hash code [{}]",lazyInnerClassSingleton.hashCode());

        LazyInnerClassSingleton lazyInnerClassSingleton1 = LazyInnerClassSingleton.getInstance();
        log.info("lazyInnerClassSingleton1 hash code [{}]",lazyInnerClassSingleton1.hashCode());

        Assert.assertEquals(lazyInnerClassSingleton.hashCode(),lazyInnerClassSingleton1.hashCode());
    }


    @Test
    public void testEnumSingleton(){
        EnumSingleton enumSingleton = EnumSingleton.SINGLETON;
        enumSingleton.setValue(1);
        log.info("enumSingleton hash code [{}]",enumSingleton.hashCode());

        EnumSingleton enumSingleton1 = EnumSingleton.SINGLETON;
        log.info("enumSingleton1 hash code [{}]",enumSingleton1.hashCode());

        Assert.assertEquals(enumSingleton.hashCode(),enumSingleton.hashCode());
    }
}
