package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.AsyncJokeRetrieverTask;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by steffy on 15/10/2017.
 */


@RunWith(AndroidJUnit4.class)
public class AsyncJokeRetrieverTaskTest {



    @Test
    public void testAsyncTask() throws Exception {

        AsyncJokeRetrieverTask asyncJokeRetrieverTask = new AsyncJokeRetrieverTask(InstrumentationRegistry.getTargetContext(), null);
        String joke = asyncJokeRetrieverTask.execute().get();

        Assert.assertNotNull(joke);
        Assert.assertFalse(joke.isEmpty());
    }

}
