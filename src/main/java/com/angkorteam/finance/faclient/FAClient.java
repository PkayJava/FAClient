package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.system.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public interface FAClient {

    @GET("api/v1/caches")
    Call<List<Cache>> cacheList();

    @PUT("api/v1/caches")
    Call<CacheSwitchResponse> cacheSwitch(@Body CacheSwitch cache);

    @GET("api/v1/datatables")
    Call<List<DataTable>> dataTableList();

    @GET("api/v1/datatables/{registeredTableName}")
    Call<DataTable> dataTableRetrieve(@Path("registeredTableName") String registeredTableName);

    @POST("api/v1/datatables")
    Call<DataTableCreateResponse> dataTableCreate(@Body DataTableCreate dataTable);
}
