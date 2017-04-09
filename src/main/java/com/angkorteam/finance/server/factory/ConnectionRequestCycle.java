package com.angkorteam.finance.server.factory;

import com.angkorteam.finance.server.Platform;
import org.apache.wicket.WicketRuntimeException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class ConnectionRequestCycle extends com.angkorteam.framework.wicket.ConnectionRequestCycle implements InitializingBean {

    private String dataSourceName;

    @Override
    protected DataSource getDataSource() {
        return Platform.getBean(this.dataSourceName, DataSource.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.dataSourceName == null) {
            throw new WicketRuntimeException("dataSourceName is null");
        }
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }
}
