package com.distributedleo.news;

import com.google.inject.Module;
import com.distributedleo.microservices.Microservice;

public class LocalNewsService extends Microservice {

    public static void main(String... args) {
        new LocalNewsService().run();
    }

    @Override
    public Module[] getModules() {
        return new Module[] {
                new NewsModule()
        };
    }
}
