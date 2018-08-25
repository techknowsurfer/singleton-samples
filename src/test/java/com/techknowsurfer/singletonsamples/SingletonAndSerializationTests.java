package com.techknowsurfer.singletonsamples;

import com.techknowsurfer.singletonsamples.serialization.SingletonSerializationPrevention;
import com.techknowsurfer.singletonsamples.singleton.LazySingleton;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.*;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class SingletonAndSerializationTests {

	@Test
	public void testLazySingleton_Success() {
        LazySingleton lazySingleton = LazySingleton.getInstance();

        /** Serializing the instance */
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("lazySingleton.ser"));
            out.writeObject(lazySingleton);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /** Deserializing the instance */
        LazySingleton lazySingleton1 = null;
        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream("lazySingleton.ser"));
            lazySingleton1 = (LazySingleton) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("lazySingleton hash code " + lazySingleton.hashCode());
        System.out.println("lazySingleton1 hash code " + lazySingleton1.hashCode());

        Assert.assertNotEquals(lazySingleton.hashCode(), lazySingleton1.hashCode());
    }

    @Test
    public void testLazySingleton_Failure() {
        SingletonSerializationPrevention lazySingleton = SingletonSerializationPrevention.getInstance();
        log.info("lazySingleton hash code [{}]", lazySingleton.hashCode());

        /** Serializing the instance */
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("lazySingleton.ser"));
            out.writeObject(lazySingleton);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Deserializing the instance */

        SingletonSerializationPrevention lazySingleton1 = null;
        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream("lazySingleton.ser"));
            lazySingleton1 = (SingletonSerializationPrevention) in.readObject();
            log.info("lazySingleton1 hash code [{}]", lazySingleton1.hashCode());
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(lazySingleton.hashCode(), lazySingleton1.hashCode());
    }

}
