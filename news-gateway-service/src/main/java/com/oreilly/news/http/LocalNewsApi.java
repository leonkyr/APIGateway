package com.distributedleo.news.http;

import com.distributedleo.news.model.LocalNews;
import retrofit.http.GET;
import retrofit.http.Path;

public interface LocalNewsApi {

    @GET("/news/{city}")
    LocalNews getLocalNewsForCity(@Path("city") String city);
}
