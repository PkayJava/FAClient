package com.angkorteam.finance.faclient;

import com.angkorteam.finance.faclient.dto.*;
import com.angkorteam.finance.faclient.gson.AppTable;
import com.angkorteam.finance.faclient.gson.AppTableTypeAdapter;
import com.angkorteam.finance.faclient.gson.AppType;
import com.angkorteam.finance.faclient.gson.AppTypeTypeAdapter;
import com.angkorteam.finance.faclient.interceptor.AuthenticationInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.RandomStringUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class ClientTest {

    public static final String format = "yyyyMMdd";

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat(format);

    public static final NumberFormat numberFormat = new DecimalFormat("00");

    public static Gson gson;

    public static void main(String[] args) throws IOException {

        AuthenticationInterceptor interceptor = new AuthenticationInterceptor("default");
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(AppTable.class, new AppTableTypeAdapter());
        gsonBuilder.registerTypeAdapter(AppType.class, new AppTypeTypeAdapter());
        gson = gsonBuilder.create();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create(gson));
//        https://demo.openmf.org/api-docs/apiLive.htm#makercheckers
//        builder.baseUrl("https://demo.openmf.org/fineract-provider/");
        builder.baseUrl("http://192.168.0.107:8080/fineract-provider/");
        builder.client(client);
        Retrofit retrofit = builder.build();
        FAClient faclient = retrofit.create(FAClient.class);
        Call<Authentication> call = faclient.authentication("mifos", "password");
        call.execute();

        SystemService systemService = retrofit.create(SystemService.class);
        ClientService clientService = retrofit.create(ClientService.class);

        step03PrintClient(clientService);

        System.out.println("FINISHED");
    }

    public static void step02GenerateClient(ClientService clientService) throws IOException {
        for (int i = 1; i <= 5; i++) {
            ClientCreate client = new ClientCreate();
            client.setDateFormat(format);
            client.setLocale("en");
            client.setExternalId(RandomStringUtils.randomAlphanumeric(10));
            client.setActivationDate(dateFormat.format(new Date()));
            client.setActive(true);
            client.setFirstname("FN_" + numberFormat.format(i));
            client.setLastname("LN_" + numberFormat.format(i));
            client.setOfficeId(1l);
            client.setSubmittedOnDate(dateFormat.format(new Date()));
            Call<ClientCreateResponse> call = clientService.clientCreate(client);
            Response<ClientCreateResponse> response = call.execute();
            if (response.isSuccessful()) {
                System.out.println(gson.toJson(response.body()));
            } else {
                System.out.println(response.errorBody().string());
            }
        }
    }

    public static void step03PrintClient(ClientService clientService) throws IOException {
        Call<ClientListResponse> call = clientService.clientList();
        Response<ClientListResponse> response = call.execute();
        ClientListResponse clientListResponse = response.body();
        if (clientListResponse != null && clientListResponse.getPageItems() != null && !clientListResponse.getPageItems().isEmpty()) {
            for (Client client : clientListResponse.getPageItems()) {
                System.out.println(client.getFirstname());
            }
        }

    }


    public static void step01GenerateCodeValues(SystemService systemService) throws IOException {
        Call<List<Code>> codeCall = systemService.codeList();
        Response<List<Code>> codeResponse = codeCall.execute();
        for (Code code : codeResponse.body()) {
            System.out.println("=======================");
            System.out.println(code.getName());
            Call<List<CodeValue>> codeValueCall = systemService.codeValueList(code.getId());
            Response<List<CodeValue>> codeValueResponse = codeValueCall.execute();
            List<CodeValue> codeValues = codeValueResponse.body();
            if (codeValues == null || codeValues.isEmpty()) {
                for (int j = 1; j <= 2; j++) {
                    CodeValueCreate codeValueCreate = new CodeValueCreate();
                    codeValueCreate.setName(code.getName() + " " + numberFormat.format(j));
                    codeValueCreate.setDescription(code.getName() + " " + numberFormat.format(j));
                    codeValueCreate.setPosition("" + j);
                    systemService.codeValueCreate(code.getId(), codeValueCreate).execute();
                }
            } else {
                for (CodeValue codeValue : codeValues) {
                    System.out.println(codeValue.getName() + " " + codeValue.getDescription() + " " + codeValue.getPosition() + " " + codeValue.isActive() + " " + codeValue.isMandatory());
                }
            }
        }
    }

}
