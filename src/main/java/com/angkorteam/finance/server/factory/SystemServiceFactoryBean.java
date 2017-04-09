package com.angkorteam.finance.server.factory;

import com.angkorteam.finance.faclient.SystemService;
import org.apache.wicket.WicketRuntimeException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import retrofit2.Retrofit;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class SystemServiceFactoryBean implements FactoryBean<SystemService>, InitializingBean {

    private SystemService systemService;

    private Retrofit retrofit;

    @Override
    public SystemService getObject() throws Exception {
        return this.systemService;
    }

    @Override
    public Class<?> getObjectType() {
        return SystemService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.retrofit == null) {
            throw new WicketRuntimeException("retrofit is null");
        }
        this.systemService = this.retrofit.create(SystemService.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

}
