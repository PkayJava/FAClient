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

    @GET("api/v1/configurations")
    Call<Map<String, List<Configuration>>> configurationList();

    @GET("api/v1/configurations/{id}")
    Call<Configuration> configurationRetrieve(@Path("id") long id);

    @PUT("api/v1/configurations/{id}")
    Call<ConfigurationUpdateResponse> configurationUpdate(@Path("id") long id, @Body ConfigurationUpdate configuration);

    @GET("api/v1/hooks")
    Call<List<Hook>> hookList();

    @GET("api/v1/hooks/{id}")
    Call<Hook> hookRetrieve(@Path("id") long id);

    @POST("api/v1/hooks")
    Call<HookCreateResponse> hookCreate(@Body HookCreate hook);

    @PUT("api/v1/hooks/{id}")
    Call<HookUpdateResponse> hookUpdate(@Path("id") long id, @Body HookUpdate hook);

    @DELETE("api/v1/hooks/{id}")
    Call<HookDeleteResponse> hookDelete(@Path("id") long id);

    @GET("api/v1/accountnumberformats")
    Call<List<AccountNumberFormat>> accountNumberFormatList();

    @GET("api/v1/accountnumberformats/{id}")
    Call<AccountNumberFormat> accountNumberFormatRetrieve(@Path("id") long id);

    @POST("api/v1/accountnumberformats")
    Call<AccountNumberFormatCreateResponse> accountNumberFormatCreate(@Body AccountNumberFormatCreate accountNumberFormat);

    @PUT("api/v1/accountnumberformats/{id}")
    Call<AccountNumberFormatUpdateResponse> accountNumberFormatUpdate(@Path("id") long id, @Body AccountNumberFormatUpdate accountNumberFormat);

    @DELETE("api/v1/accountnumberformats/{id}")
    Call<AccountNumberFormatDeleteResponse> accountNumberFormatDelete(@Path("id") long id);

    @GET("api/v1/codes")
    Call<List<Code>> codeList();

    @POST("api/v1/codes")
    Call<CodeCreateResponse> codeCreate(@Body CodeCreate code);

    @GET("api/v1/codes/{id}")
    Call<Code> codeRetrieve(@Path("id") long id);

    @PUT("api/v1/codes/{id}")
    Call<CodeUpdateResponse> codeUpdate(@Path("id") long id, @Body CodeUpdate code);

    @DELETE("api/v1/codes/{id}")
    Call<CodeDeleteResponse> codeDelete(@Path("id") long id);

    @GET("api/v1/codes/{codeId}/codevalues")
    Call<List<CodeValue>> codeValueList(@Path("codeId") long codeId);

    @GET("api/v1/codes/{codeId}/codevalues/{valueId}")
    Call<CodeValue> codeValueRetrieve(@Path("codeId") long codeId, @Path("valueId") long valueId);

    @POST("api/v1/codes/{codeId}/codevalues")
    Call<CodeValueCreateResponse> codeValueCreate(@Path("codeId") long codeId, @Body CodeValueCreate codeValue);

    @PUT("api/v1/codes/{codeId}/codevalues/{valueId}")
    Call<CodeValueUpdateResponse> codeValueUpdate(@Path("codeId") long codeId, @Path("valueId") long valueId, @Body CodeValueUpdate codeValue);

    @DELETE("api/v1/codes/{codeId}/codevalues/{valueId}")
    Call<CodeValueDeleteResponse> codeValueDelete(@Path("codeId") long codeId, @Path("valueId") long valueId);

    @GET("api/v1/audits")
    Call<List<Audit>> auditList();

    @GET("api/v1/audits/{id}")
    Call<Audit> auditRetrieve(@Path("id") long id);

    @GET("api/v1/makercheckers")
    Call<List<MakerChecker>> makerCheckerList();

    @POST("api/v1/makercheckers/{id}?command=approve")
    Call<MakerCheckerApproveResponse> makerCheckerApprove(@Path("id") long commandId);

    @DELETE("api/v1/makercheckers/{id}")
    Call<MakerCheckerDeleteResponse> makerCheckerDelete(@Path("id") long commandId);

    @POST("api/v1/makercheckers/{id}?command=reject")
    Call<MakerCheckerRejectResponse> makerCheckerReject(@Path("id") long commandId);

}
