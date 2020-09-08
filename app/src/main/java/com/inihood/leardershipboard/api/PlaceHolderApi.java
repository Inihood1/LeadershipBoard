package com.inihood.leardershipboard.api;

import com.inihood.leardershipboard.model.Post;
import com.inihood.leardershipboard.model.UsersIQ;
import com.inihood.leardershipboard.model.UsersLearners;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PlaceHolderApi {
    @GET("/api/hours")
    Call<List<UsersLearners>> getTopLearners();

    @GET("/api/skilliq")
    Call<List<UsersIQ>> getIQLearners();

//    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
//    Call<Post> createPost(@Body Post post);

  //  @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<Void> createPost(
            @Field("entry.1824927963") String email,
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086") String lastName,
            @Field("entry.284483984") String project
    );
//    @Headers("Content-Type: application/json")
//    @FormUrlEncoded
//    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
//    Call<Post> createPost(@FieldMap Map<String, String> fields);
}
