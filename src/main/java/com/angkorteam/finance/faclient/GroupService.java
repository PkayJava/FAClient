package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.group.*;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public interface GroupService {

    @GET("api/v1/groups")
    Call<GroupResponse> groupList();

    @POST("api/v1/groups")
    Call<GroupCreateResponse> groupCreate(@Body GroupCreate group);

    @GET("api/v1/groups/{id}")
    Call<Group> groupRetrieve(@Path("id") long id);

    @PUT("api/v1/groups/{id}")
    Call<GroupUpdateResponse> groupUpdate(@Path("id") long id, @Body GroupUpdate group);

    @POST("api/v1/centers")
    Call<CenterCreateResponse> centerCreate(@Body CenterCreate center);

}
