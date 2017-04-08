package com.angkorteam.finance.faclient.interceptor;

import com.angkorteam.finance.faclient.dto.common.Feedback;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class DebugInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Request request = builder.build();
        Response response = chain.proceed(request);
        if (!response.isSuccessful()) {
            Gson gson = new Gson();
            String string = response.body().string();
            Response.Builder cached = new Response.Builder();
            cached.body(ResponseBody.create(MediaType.parse("application/json"), string.getBytes()));
            cached.protocol(response.protocol());
            cached.code(response.code());
            cached.request(response.request());
            response = cached.build();
            Feedback feedback = gson.fromJson(string, Feedback.class);
            for (Feedback.Error error : feedback.getErrors()) {
                System.out.println(error.getDefaultUserMessage());
            }
        }

        return response;
    }

}
