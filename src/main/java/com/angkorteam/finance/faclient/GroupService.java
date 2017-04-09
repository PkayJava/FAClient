package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.group.*;
import com.angkorteam.finance.faclient.dto.system.Authentication;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public interface GroupService {

    @POST("api/v1/authentication")
    Call<Authentication> authentication(@Query(value = "username", encoded = true) String username, @Query(value = "password", encoded = true) String password);

    @GET("api/v1/groups?paged=true")
    Call<GroupListResponse> groupList(@Query("offset") long offset, @Query("limit") long limit);

    @POST("api/v1/groups")
    Call<GroupCreateResponse> groupCreate(@Body GroupCreate group);

    @GET("api/v1/groups/{id}")
    Call<Group> groupRetrieve(@Path("id") long id);

    @PUT("api/v1/groups/{id}")
    Call<GroupUpdateResponse> groupUpdate(@Path("id") long id, @Body GroupUpdate group);

    @POST("api/v1/centers")
    Call<CenterCreateResponse> centerCreate(@Body CenterCreate center);

    @GET("api/v1/centers?paged=true")
    Call<CenterListResponse> centerList(@Query("offset") long offset, @Query("limit") long limit);

}
