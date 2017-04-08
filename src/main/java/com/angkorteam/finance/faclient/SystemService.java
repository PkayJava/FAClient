package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.system.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Created by socheatkhauv on 3/31/17.
 */
public interface SystemService {

    /**
     * List Global Configuration
     *
     * @return
     */
    @GET("api/v1/configurations")
    Call<Map<String, List<Configuration>>> configurationList();

    /**
     * Retrieve a Global Configuration
     *
     * @param id
     * @return
     */
    @GET("api/v1/configurations/{id}")
    Call<Configuration> configurationRetrieve(@Path("id") long id);

    /**
     * Update a Global Configuration
     *
     * @param id
     * @param configuration
     * @return
     */
    @PUT("api/v1/configurations/{id}")
    Call<ConfigurationUpdateResponse> configurationUpdate(@Path("id") long id, @Body ConfigurationUpdate configuration);

    /**
     * List Hook
     *
     * @return
     */
    @GET("api/v1/hooks")
    Call<List<Hook>> hookList();

    /**
     * Retrieve a Hook
     *
     * @param id
     * @return
     */
    @GET("api/v1/hooks/{id}")
    Call<Hook> hookRetrieve(@Path("id") long id);

    /**
     * Create a Hook
     *
     * @param hook
     * @return
     */
    @POST("api/v1/hooks")
    Call<HookCreateResponse> hookCreate(@Body HookCreate hook);

    /**
     * Update a Hook
     *
     * @param id
     * @param hook
     * @return
     */
    @PUT("api/v1/hooks/{id}")
    Call<HookUpdateResponse> hookUpdate(@Path("id") long id, @Body HookUpdate hook);

    /**
     * Delete a Hook
     *
     * @param id
     * @return
     */
    @DELETE("api/v1/hooks/{id}")
    Call<HookDeleteResponse> hookDelete(@Path("id") long id);

    /**
     * List AccountNumberFormat
     *
     * @return
     */
    @GET("api/v1/accountnumberformats")
    Call<List<AccountNumberFormat>> accountNumberFormatList();

    /**
     * Retrieve an AccountNumberFormat
     *
     * @param id
     * @return
     */
    @GET("api/v1/accountnumberformats/{id}")
    Call<AccountNumberFormat> accountNumberFormatRetrieve(@Path("id") long id);

    /**
     * Create an AccountNumberFormat
     *
     * @param accountNumberFormat
     * @return
     */
    @POST("api/v1/accountnumberformats")
    Call<AccountNumberFormatCreateResponse> accountNumberFormatCreate(@Body AccountNumberFormatCreate accountNumberFormat);

    /**
     * Update an AccountNumberFormat
     *
     * @param id
     * @param accountNumberFormat
     * @return
     */
    @PUT("api/v1/accountnumberformats/{id}")
    Call<AccountNumberFormatUpdateResponse> accountNumberFormatUpdate(@Path("id") long id, @Body AccountNumberFormatUpdate accountNumberFormat);

    /**
     * Delete an AccountNumberFormat
     *
     * @param id
     * @return
     */
    @DELETE("api/v1/accountnumberformats/{id}")
    Call<AccountNumberFormatDeleteResponse> accountNumberFormatDelete(@Path("id") long id);

    /**
     * List Code
     *
     * @return
     */
    @GET("api/v1/codes")
    Call<List<Code>> codeList();

    /**
     * Create a Code
     *
     * @param code
     * @return
     */
    @POST("api/v1/codes")
    Call<CodeCreateResponse> codeCreate(@Body CodeCreate code);

    /**
     * Retrieve a Code
     *
     * @param id
     * @return
     */
    @GET("api/v1/codes/{id}")
    Call<Code> codeRetrieve(@Path("id") long id);

    /**
     * Update a Code
     *
     * @param id
     * @param code
     * @return
     */
    @PUT("api/v1/codes/{id}")
    Call<CodeUpdateResponse> codeUpdate(@Path("id") long id, @Body CodeUpdate code);

    /**
     * Delete a Code
     *
     * @param id
     * @return
     */
    @DELETE("api/v1/codes/{id}")
    Call<CodeDeleteResponse> codeDelete(@Path("id") long id);

    /**
     * List CodeValue
     *
     * @param codeId
     * @return
     */
    @GET("api/v1/codes/{codeId}/codevalues")
    Call<List<CodeValue>> codeValueList(@Path("codeId") long codeId);

    /**
     * Retrieve a CodeValue
     *
     * @param codeId
     * @param valueId
     * @return
     */
    @GET("api/v1/codes/{codeId}/codevalues/{valueId}")
    Call<CodeValue> codeValueRetrieve(@Path("codeId") long codeId, @Path("valueId") long valueId);

    /**
     * Create a CodeValue
     *
     * @param codeId
     * @param codeValue
     * @return
     */
    @POST("api/v1/codes/{codeId}/codevalues")
    Call<CodeValueCreateResponse> codeValueCreate(@Path("codeId") long codeId, @Body CodeValueCreate codeValue);

    /**
     * Update a CodeValue
     *
     * @param codeId
     * @param valueId
     * @param codeValue
     * @return
     */
    @PUT("api/v1/codes/{codeId}/codevalues/{valueId}")
    Call<CodeValueUpdateResponse> codeValueUpdate(@Path("codeId") long codeId, @Path("valueId") long valueId, @Body CodeValueUpdate codeValue);

    /**
     * Delete a CodeValue
     *
     * @param codeId
     * @param valueId
     * @return
     */
    @DELETE("api/v1/codes/{codeId}/codevalues/{valueId}")
    Call<CodeValueDeleteResponse> codeValueDelete(@Path("codeId") long codeId, @Path("valueId") long valueId);

    /**
     * List Audit
     *
     * @return
     */
    @GET("api/v1/audits")
    Call<List<Audit>> auditList();

    /**
     * Retrieve an Audit
     *
     * @param id
     * @return
     */
    @GET("api/v1/audits/{id}")
    Call<Audit> auditRetrieve(@Path("id") long id);

    /**
     * List MakerChecker
     *
     * @return
     */
    @GET("api/v1/makercheckers")
    Call<List<MakerChecker>> makerCheckerList();
}
