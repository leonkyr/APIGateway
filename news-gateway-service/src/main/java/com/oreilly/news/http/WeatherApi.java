package com.distributedleo.news.http;

import com.distributedleo.news.model.Weather;
import retrofit.http.GET;
import retrofit.http.Path;

public interface WeatherApi {

    @GET("/weather/{city}")
    Weather getWeatherForCity(@Path("city") String city);
}
