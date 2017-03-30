package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public interface FAClient {

    @POST("api/v1/authentication")
    Call<Authentication> authentication(@Query(value = "username", encoded = true) String username, @Query(value = "password", encoded = true) String password);

    @GET("api/v1/offices")
    Call<List<Office>> officeList();

    @GET("api/v1/offices")
    Call<List<Office>> officeList(@QueryMap Map<String, Object> params);

    @GET("api/v1/offices/template")
    Call<OfficeTemplateResponse> officeTemplate();

    @GET("api/v1/offices/{id}")
    Call<Office> officeRetrieve(@Path("id") long id);

    @GET("api/v1/offices/{id}")
    Call<Office> officeRetrieve(@Path("id") long id, @QueryMap Map<String, Object> params);

    @POST("api/v1/offices")
    Call<OfficeCreateResponse> officeCreate(@Body OfficeCreate office);

    @PUT("api/v1/offices/{id}")
    Call<OfficeUpdateResponse> officeUpdate(@Path("id") long id, @Body OfficeUpdate office);

    @GET("api/v1/configurations")
    Call<GlobalConfiguration> globalConfigurationRetrieve();

    @GET("api/v1/configurations/survey")
    Call<Configuration> configurationRetrieve(@Path("id") long id);

    @GET("api/v1/configurations/{id}")
    Call<Map<String, Configuration>> globalConfigurationSurveyRetrieve();

    @PUT("api/v1/configurations/{id}")
    Call<ConfigurationUpdateResponse> configurationUpdate(@Path("id") long id, @Body ConfigurationUpdate configuration);

    @GET("api/v1/caches")
    Call<List<Cache>> cacheList();

    @PUT("api/v1/caches")
    Call<CacheSwitchResponse> cacheSwitch(@Body CacheSwitch cache);

    @POST("api/v1/hooks")
    Call<CacheSwitchResponse> hookCreate(@Body CacheSwitch cache);

    @GET("api/v1/hooks")
    Call<List<Hook>> hookList();

    @GET("api/v1/hooks/{id}")
    Call<Hook> hookRetrieve(@Path("id") long id);

    @PUT("api/v1/hooks/{id}")
    Call<HookUpdateResponse> hookUpdate(@Path("id") long id, @Body HookUpdate hook);

    @DELETE("api/v1/hooks/{id}")
    Call<HookDeleteResponse> hookDelete(@Path("id") long id);

    @GET("api/v1/hooks/template")
    Call<HookTemplateResponse> hookTemplate();

    @POST("api/v1/codes")
    Call<CodeCreateResponse> codeCreate(@Body CodeCreate code);

    @GET("api/v1/codes")
    Call<List<Code>> codeList();

    @GET("api/v1/codes/{id}")
    Call<Code> codeRetrieve(@Path("id") long id);

    @PUT("api/v1/codes/{id}")
    Call<CodeUpdate> codeUpdate(@Path("id") long id, @Body CodeUpdate code);

    @DELETE("api/v1/codes/{id}")
    Call<CodeDeleteResponse> codeDelete(@Path("id") long id);

    @POST("api/v1/codes/{codeId}/codevalues")
    Call<CodeValueCreateResponse> codeValueCreate(@Path("codeId") long codeId, @Body CodeValueCreate codeValue);

    @GET("api/v1/codes/{codeId}/codevalues")
    Call<List<CodeValue>> codeValueList(@Path("codeId") long codeId);

    @GET("api/v1/codes/{codeId}/codevalues/{valueId}")
    Call<CodeValue> codeValueRetrieve(@Path("codeId") long codeId, @Path("valueId") long valueId);

    @PUT("api/v1/codes/{codeId}/codevalues/{valueId}")
    Call<CodeValueUpdateResponse> codeValueUpdate(@Path("codeId") long codeId, @Path("valueId") long valueId, @Body CodeValueUpdate codeValue);

    @DELETE("api/v1/codes/{codeId}/codevalues/{valueId}")
    Call<CodeValueDeleteResponse> codeValueDelete(@Path("codeId") long codeId, @Path("valueId") long valueId);

    @GET("api/v1/audits")
    Call<List<Audit>> auditList();

    @GET("api/v1/audits")
    Call<List<Audit>> auditList(@QueryMap Map<String, Object> params);

    @GET("api/v1/audits/{id}")
    Call<Audit> auditRetrieve(@Path("id") long id);

    @GET("api/v1/audits/{id}")
    Call<Audit> auditRetrieve(@Path("id") long id, @QueryMap Map<String, Object> params);

    @GET("api/v1/audits")
    Call<AuditPaginationResponse> auditPagination(@Query("paged") boolean paged, @Query("limit") int limit);

    @GET("api/v1/audits")
    Call<AuditPaginationResponse> auditPagination(@Query("paged") boolean paged, @Query("limit") int limit, @QueryMap Map<String, Object> params);

    @GET("api/v1/audits/searchtemplate")
    Call<AuditSearchTemplate> auditSearchTemplate();

    @GET("api/v1/audits/searchtemplate")
    Call<AuditSearchTemplate> auditSearchTemplate(@QueryMap Map<String, Object> params);

    @GET("api/v1/accountnumberformats")
    Call<List<AccountNumberFormat>> accountNumberFormatList();

    @GET("api/v1/accountnumberformats/template")
    Call<AccountNumberFormatTemplateResponse> accountNumberFormatTemplate();

    @GET("api/v1/accountnumberformats/{id}")
    Call<AccountNumberFormat> accountNumberFormatRetrieve(@Path("id") long id);

    @POST("api/v1/accountnumberformats")
    Call<AccountNumberFormatCreateResponse> accountNumberFormatCreate(@Body AccountNumberFormatCreate accountNumberFormat);

    @PUT("api/v1/accountnumberformats/{id}")
    Call<AccountNumberFormatUpdateResponse> accountNumberFormatUpdate(@Path("id") long id, @Body AccountNumberFormatUpdate accountNumberFormat);

    @DELETE("api/v1/accountnumberformats/{id}")
    Call<AccountNumberFormatDeleteResponse> accountNumberFormatDelete(@Path("id") long id);
}
