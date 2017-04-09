package com.angkorteam.finance.server.factory;

import com.angkorteam.finance.faclient.ClientService;
import org.apache.wicket.WicketRuntimeException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import retrofit2.Retrofit;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class ClientServiceFactoryBean implements FactoryBean<ClientService>, InitializingBean {

    private ClientService clientService;

    private Retrofit retrofit;

    @Override
    public ClientService getObject() throws Exception {
        return this.clientService;
    }

    @Override
    public Class<?> getObjectType() {
        return ClientService.class;
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
        this.clientService = this.retrofit.create(ClientService.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

}
