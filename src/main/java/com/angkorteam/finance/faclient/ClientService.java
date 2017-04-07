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
     * Close a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=close")
    Call<ClientCloseResponse> clientClose(@Path("id") long id, @Body ClientClose client);

    /**
     * Reject a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=reject")
    Call<ClientRejectResponse> clientReject(@Path("id") long id, @Body ClientReject client);

    /**
     * Withdraw a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=withdraw")
    Call<ClientWithdrawResponse> clientWithdraw(@Path("id") long id, @Body ClientWithdraw client);

    /**
     * Reactivate a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=reactivate")
    Call<ClientReactivateResponse> clientReactivate(@Path("id") long id, @Body ClientReactivate client);

    /**
     * Undo rejection a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=UndoRejection")
    Call<ClientUndoRejectionResponse> clientUndoRejection(@Path("id") long id, @Body ClientUndoRejection client);

    /**
     * Undo withdrawal a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=UndoWithdrawal")
    Call<ClientUndoWithdrawalResponse> clientUndoWithdrawal(@Path("id") long id, @Body ClientUndoWithdrawal client);

    /**
     * Assign staff a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=assignStaff")
    Call<ClientAssignStaffResponse> clientAssignStaff(@Path("id") long id, @Body ClientAssignStaff client);

    /**
     * UnAssign staff a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=unassignStaff")
    Call<ClientUnAssignStaffResponse> clientUnAssignStaff(@Path("id") long id, @Body ClientUnAssignStaff client);

    /**
     * Propose transfer a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=proposeTransfer")
    Call<ClientUnAssignStaffResponse> clientProposeTransfer(@Path("id") long id, @Body ClientUnAssignStaff client);

    /**
     * Withdraw transfer a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=withdrawTransfer")
    Call<ClientWithdrawTransferResponse> clientWithdrawTransfer(@Path("id") long id, @Body ClientWithdrawTransfer client);

    /**
     * Accept transfer a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=acceptTransfer")
    Call<ClientAcceptTransferResponse> clientAcceptTransfer(@Path("id") long id, @Body ClientAcceptTransfer client);

    /**
     * Reject transfer a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=rejectTransfer")
    Call<ClientRejectTransferResponse> clientRejectTransfer(@Path("id") long id, @Body ClientRejectTransfer client);

    /**
     * Update savings account a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=updateSavingsAccount")
    Call<ClientUpdateSavingsAccountResponse> clientUpdateSavingsAccount(@Path("id") long id, @Body ClientUpdateSavingsAccount client);

    /**
     * Propose and accept transfer a Client
     *
     * @param id
     * @param client
     * @return
     */
    @POST("api/v1/clients/{id}?command=proposeAndAcceptTransfer")
    Call<ClientProposeAndAcceptTransferResponse> clientProposeAndAcceptTransfer(@Path("id") long id, @Body ClientProposeAndAcceptTransfer client);

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
