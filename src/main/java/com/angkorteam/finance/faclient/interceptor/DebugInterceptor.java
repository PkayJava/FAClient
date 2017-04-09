package com.angkorteam.finance.faclient.interceptor;

import com.angkorteam.finance.faclient.dto.common.Feedback;
import com.google.gson.Gson;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class DebugInterceptor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugInterceptor.class);

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
            if (feedback != null && feedback.getErrors() != null && !feedback.getErrors().isEmpty()) {
                for (Feedback.Error error : feedback.getErrors()) {
                    LOGGER.info(error.getDeveloperMessage());
                }
            }
        }

        return response;
    }

}
