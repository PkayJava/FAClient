package com.angkorteam.finance.server.factory;

import com.angkorteam.finance.faclient.gson.AppTable;
import com.angkorteam.finance.faclient.gson.AppTableTypeAdapter;
import com.angkorteam.finance.faclient.gson.AppType;
import com.angkorteam.finance.faclient.gson.AppTypeTypeAdapter;
import com.angkorteam.finance.faclient.interceptor.AuthenticationInterceptor;
import com.angkorteam.finance.faclient.interceptor.DebugInterceptor;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import org.apache.wicket.WicketRuntimeException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class RetrofitFactoryBean implements FactoryBean<Retrofit>, InitializingBean {

    private Retrofit retrofit;

    private String baseUrl;

    private boolean debug;

    private String tenant;

    @Override
    public Retrofit getObject() throws Exception {
        return this.retrofit;
    }

    @Override
    public Class<?> getObjectType() {
        return Retrofit.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        if (Strings.isNullOrEmpty(this.tenant)) {
            throw new WicketRuntimeException("tenant is null");
        }

        if (Strings.isNullOrEmpty(this.baseUrl)) {
            throw new WicketRuntimeException("baseUrl is null");
        }

        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(this.tenant);
        OkHttpClient client;
        if (this.debug) {
            client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(new DebugInterceptor())
                    .build();
        } else {
            client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(AppTable.class, new AppTableTypeAdapter());
        gsonBuilder.registerTypeAdapter(AppType.class, new AppTypeTypeAdapter());
        Gson gson = gsonBuilder.create();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        builder.baseUrl(this.baseUrl);
        builder.client(client);
        this.retrofit = builder.build();
    }
}
