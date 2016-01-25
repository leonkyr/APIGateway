package com.distributedleo.news.compositor;

import com.google.inject.Inject;
import com.distributedleo.news.command.LocalNewsHystrixCommand;
import com.distributedleo.news.command.WeatherHystrixCommand;
import com.distributedleo.news.http.LocalNewsApi;
import com.distributedleo.news.http.WeatherApi;
import com.distributedleo.news.model.CityNews;
import com.distributedleo.news.model.LocalNews;
import com.distributedleo.news.model.Weather;

import java.util.concurrent.Future;

public class NewsCompositor {

    @Inject
    private LocalNewsApi localNewsApi;

    @Inject
    private WeatherApi weatherApi;

    public CityNews getNewsForCity(String city) throws Exception {
        Future<LocalNews> localNewsFuture =
                new LocalNewsHystrixCommand(localNewsApi, city).queue();
        Future<Weather> weatherFuture =
                new WeatherHystrixCommand(weatherApi, city).queue();

        LocalNews localNews = localNewsFuture.get();
        Weather weather = weatherFuture.get();

        return new CityNews(city, weather, localNews);
    }
}
