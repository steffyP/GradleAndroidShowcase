/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.steffy.myapplication.backend;

import com.example.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.steffy.example.com",
                ownerName = "backend.myapplication.steffy.example.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    /**
     * A simple endpoint method that provides a joke
     */
    @ApiMethod(name = "getJoke")
    public JokeBean getJoke() {
      //  System.out.println("retrieving joke...");
        JokeBean response = new JokeBean();
        String joke = JokeProvider.getJoke();
      //  System.out.println("joke: " + joke);
        response.setJoke(joke);

        return response;
    }

}
