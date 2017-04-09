package com.angkorteam.finance.server.factory;

import com.angkorteam.finance.faclient.GroupService;
import org.apache.wicket.WicketRuntimeException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import retrofit2.Retrofit;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class GroupServiceFactoryBean implements FactoryBean<GroupService>, InitializingBean {

    private GroupService groupService;

    private Retrofit retrofit;

    @Override
    public GroupService getObject() throws Exception {
        return this.groupService;
    }

    @Override
    public Class<?> getObjectType() {
        return GroupService.class;
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
        this.groupService = this.retrofit.create(GroupService.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

}
