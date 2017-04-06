package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public interface FAClient {

    @POST("api/v1/authentication")
    Call<Authentication> authentication(@Query(value = "username", encoded = true) String username, @Query(value = "password", encoded = true) String password);

    @GET("api/v1/offices")
    Call<List<Office>> officeList();

    @GET("api/v1/offices/template")
    Call<OfficeTemplate> officeTemplate();

    @GET("api/v1/offices/{id}")
    Call<Office> officeRetrieve(@Path("id") long id);

    @POST("api/v1/offices")
    Call<OfficeCreateResponse> officeCreate(@Body OfficeCreate office);

    @PUT("api/v1/offices/{id}")
    Call<OfficeUpdateResponse> officeUpdate(@Path("id") long id, @Body OfficeUpdate office);

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
