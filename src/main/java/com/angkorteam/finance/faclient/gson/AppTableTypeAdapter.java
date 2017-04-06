package com.angkorteam.finance.faclient.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by socheatkhauv on 3/31/17.
 */
public class AppTableTypeAdapter extends TypeAdapter<AppTable> {

    private static final String APP_TABLE_M_LOAN = "m_loan";
    private static final String APP_TABLE_M_SAVINGS_ACCOUNT = "m_savings_account";
    private static final String APP_TABLE_M_CLIENT = "m_client";
    private static final String APP_TABLE_M_GROUP = "m_group";
    private static final String APP_TABLE_M_CENTER = "m_center";
    private static final String APP_TABLE_M_OFFICE = "m_office";
    private static final String APP_TABLE_M_PRODUCT_LOAN = "m_product_loan";
    private static final String APP_TABLE_M_SAVINGS_PRODUCT = "m_savings_product";

    @Override
    public void write(JsonWriter jsonWriter, AppTable appTable) throws IOException {
        if (appTable == AppTable.Loan) {
            jsonWriter.value(APP_TABLE_M_LOAN);
        } else if (appTable == AppTable.SavingsAccount) {
            jsonWriter.value(APP_TABLE_M_SAVINGS_ACCOUNT);
        } else if (appTable == AppTable.Client) {
            jsonWriter.value(APP_TABLE_M_CLIENT);
        } else if (appTable == AppTable.Group) {
            jsonWriter.value(APP_TABLE_M_GROUP);
        } else if (appTable == AppTable.Center) {
            jsonWriter.value(APP_TABLE_M_CENTER);
        } else if (appTable == AppTable.Office) {
            jsonWriter.value(APP_TABLE_M_OFFICE);
        } else if (appTable == AppTable.SavingsProduct) {
            jsonWriter.value(APP_TABLE_M_SAVINGS_PRODUCT);
        }
    }

    @Override
    public AppTable read(JsonReader jsonReader) throws IOException {
        String string = jsonReader.nextString();
        if (APP_TABLE_M_LOAN.equals(string)) {
            return AppTable.Loan;
        } else if (APP_TABLE_M_SAVINGS_ACCOUNT.equals(string)) {
            return AppTable.SavingsAccount;
        } else if (APP_TABLE_M_CLIENT.equals(string)) {
            return AppTable.Client;
        } else if (APP_TABLE_M_GROUP.equals(string)) {
            return AppTable.Group;
        } else if (APP_TABLE_M_CENTER.equals(string)) {
            return AppTable.Center;
        } else if (APP_TABLE_M_OFFICE.equals(string)) {
            return AppTable.Office;
        } else if (APP_TABLE_M_PRODUCT_LOAN.equals(string)) {
            return AppTable.ProductLoad;
        } else if (APP_TABLE_M_SAVINGS_PRODUCT.equals(string)) {
            return AppTable.SavingsProduct;
        } else {
            throw new IOException("unknown type of " + string);
        }
    }
}
