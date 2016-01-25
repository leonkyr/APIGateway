package com.distributedleo.news;

import com.google.inject.Module;
import com.distributedleo.microservices.Microservice;

public class NewsGatewayService extends Microservice {

    public static void main(String... args) {
        new NewsGatewayService().run();
    }

    @Override
    public Module[] getModules() {
        return new Module[] {
                new NewsGatewayModule()
        };
    }
}
