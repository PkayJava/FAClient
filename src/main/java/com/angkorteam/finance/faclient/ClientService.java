package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public interface ClientService {

    /**
     * Activate a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=activate")
    Call<ClientActivateResponse> clientActivate(@Path("id") long id, @Body ClientActivate client);

    /**
     * Delete a Client
     */
    @DELETE("api/v1/clients/{id}")
    Call<ClientDeleteResponse> clientDelete(@Path("id") long id);

    /**
     * Update a Client
     */
    @PUT("api/v1/clients")
    Call<ClientUpdateResponse> clientUpdate(@Path("id") long id, @Body ClientUpdate client);

    /**
     * Create a Client
     */
    @POST("api/v1/clients")
    Call<ClientCreateResponse> clientCreate(@Body ClientCreate client);

    /**
     * Retrieve a Client
     */
    @GET("api/v1/clients/{id}")
    Call<Client> clientRetrieve(@Path("id") long id);

    /**
     * List Client
     */
    @GET("api/v1/clients")
    Call<ClientListResponse> clientList();
}
