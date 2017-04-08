package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.client.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public interface ClientService {

    @POST("api/v1/clients/{id}?command=activate")
    Call<ClientActivateResponse> clientActivate(@Path("id") long id, @Body ClientActivate client);

    @POST("api/v1/clients/{id}?command=close")
    Call<ClientCloseResponse> clientClose(@Path("id") long id, @Body ClientClose client);

    @POST("api/v1/clients/{id}?command=reject")
    Call<ClientRejectResponse> clientReject(@Path("id") long id, @Body ClientReject client);

    @POST("api/v1/clients/{id}?command=withdraw")
    Call<ClientWithdrawResponse> clientWithdraw(@Path("id") long id, @Body ClientWithdraw client);

    @POST("api/v1/clients/{id}?command=reactivate")
    Call<ClientReactivateResponse> clientReactivate(@Path("id") long id, @Body ClientReactivate client);

    @POST("api/v1/clients/{id}?command=UndoRejection")
    Call<ClientUndoRejectionResponse> clientUndoRejection(@Path("id") long id, @Body ClientUndoRejection client);

    @POST("api/v1/clients/{id}?command=UndoWithdrawal")
    Call<ClientUndoWithdrawalResponse> clientUndoWithdrawal(@Path("id") long id, @Body ClientUndoWithdrawal client);

    @POST("api/v1/clients/{id}?command=assignStaff")
    Call<ClientAssignStaffResponse> clientAssignStaff(@Path("id") long id, @Body ClientAssignStaff client);

    @POST("api/v1/clients/{id}?command=unassignStaff")
    Call<ClientUnAssignStaffResponse> clientUnAssignStaff(@Path("id") long id, @Body ClientUnAssignStaff client);

    @POST("api/v1/clients/{id}?command=proposeTransfer")
    Call<ClientUnAssignStaffResponse> clientProposeTransfer(@Path("id") long id, @Body ClientUnAssignStaff client);

    @POST("api/v1/clients/{id}?command=withdrawTransfer")
    Call<ClientWithdrawTransferResponse> clientWithdrawTransfer(@Path("id") long id, @Body ClientWithdrawTransfer client);

    @POST("api/v1/clients/{id}?command=acceptTransfer")
    Call<ClientAcceptTransferResponse> clientAcceptTransfer(@Path("id") long id, @Body ClientAcceptTransfer client);

    @POST("api/v1/clients/{id}?command=rejectTransfer")
    Call<ClientRejectTransferResponse> clientRejectTransfer(@Path("id") long id, @Body ClientRejectTransfer client);

    @POST("api/v1/clients/{id}?command=updateSavingsAccount")
    Call<ClientUpdateSavingsAccountResponse> clientUpdateSavingsAccount(@Path("id") long id, @Body ClientUpdateSavingsAccount client);

    @POST("api/v1/clients/{id}?command=proposeAndAcceptTransfer")
    Call<ClientProposeAndAcceptTransferResponse> clientProposeAndAcceptTransfer(@Path("id") long id, @Body ClientProposeAndAcceptTransfer client);

    @GET("api/v1/clients/{id}/accounts")
    Call<ClientAccountResponse> clientAccountList(@Path("id") long clientId);

    @POST("api/v1/client/{id}/addresses?type={addressTypeId}")
    Call<ClientAddressCreateResponse> clientAddressCreate(@Path("id") long clientId, @Path("addressTypeId") long addressTypeId, @Body ClientAddressCreate clientAddress);

    @GET("api/v1/client/{id}/addresses")
    Call<List<ClientAddress>> clientAddressList(@Path("id") long id);

    @PUT("api/v1/client/{id}/addresses?type={addressTypeId}")
    Call<ClientAddressUpdate> clientAddressUpdate(@Path("id") long clientId, @Path("addressTypeId") long addressTypeId, @Body ClientAddressUpdate clientAddress);

    @GET("api/v1/fieldconfiguration/{entity}")
    Call<List<FieldConfiguration>> fieldConfigurationList(@Path("entity") String entity);

    @DELETE("api/v1/clients/{id}")
    Call<ClientDeleteResponse> clientDelete(@Path("id") long id);

    @PUT("api/v1/clients")
    Call<ClientUpdateResponse> clientUpdate(@Path("id") long id, @Body ClientUpdate client);

    @POST("api/v1/clients")
    Call<ClientCreateResponse> clientCreate(@Body ClientCreate client);

    @GET("api/v1/clients/{id}")
    Call<Client> clientRetrieve(@Path("id") long id);

    @GET("api/v1/clients")
    Call<ClientListResponse> clientList(@Query("offset") long offset, @Query("limit") long limit);
}
