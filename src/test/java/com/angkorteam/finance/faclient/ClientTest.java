package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.Authentication;
import com.angkorteam.finance.faclient.interceptor.AuthenticationInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class ClientTest {

    public static void main(String[] args) throws IOException {

        AuthenticationInterceptor interceptor = new AuthenticationInterceptor("default");
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        builder.baseUrl("http://192.168.0.107:8080/fineract-provider/");
        builder.client(client);
        Retrofit retrofit = builder.build();
        FAClient service = retrofit.create(FAClient.class);
        Call<Authentication> call = service.authentication("mifos", "password");
        call.execute();

        System.out.println(gson.toJson(service.accountNumberFormatList().execute().body()));

    }

}
