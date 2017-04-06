package com.angkorteam.finance.faclient.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by socheatkhauv on 3/31/17.
 */
public class AppTypeTypeAdapter extends TypeAdapter<AppType> {

    private static final String TYPE_BOOLEAN = "Boolean";
    private static final String TYPE_DATE = "Date";
    private static final String TYPE_DATETIME = "DateTime";
    private static final String TYPE_DECIMAL = "Decimal";
    private static final String TYPE_DROPDOWN = "Dropdown";
    private static final String TYPE_NUMBER = "Number";
    private static final String TYPE_STRING = "String";
    private static final String TYPE_TEXT = "Text";

    @Override
    public void write(JsonWriter jsonWriter, AppType appType) throws IOException {
        if (appType == AppType.Boolean) {
            jsonWriter.value(TYPE_BOOLEAN);
        } else if (appType == AppType.Date) {
            jsonWriter.value(TYPE_DATE);
        } else if (appType == AppType.DateTime) {
            jsonWriter.value(TYPE_DATETIME);
        } else if (appType == AppType.Decimal) {
            jsonWriter.value(TYPE_DECIMAL);
        } else if (appType == AppType.Dropdown) {
            jsonWriter.value(TYPE_DROPDOWN);
        } else if (appType == AppType.Number) {
            jsonWriter.value(TYPE_NUMBER);
        } else if (appType == AppType.String) {
            jsonWriter.value(TYPE_STRING);
        } else if (appType == AppType.Text) {
            jsonWriter.value(TYPE_TEXT);
        }
    }

    @Override
    public AppType read(JsonReader jsonReader) throws IOException {
        String string = jsonReader.nextString();
        if (TYPE_BOOLEAN.equals(string)) {
            return AppType.Boolean;
        } else if (TYPE_DATE.equals(string)) {
            return AppType.Date;
        } else if (TYPE_DATETIME.equals(string)) {
            return AppType.DateTime;
        } else if (TYPE_DECIMAL.equals(string)) {
            return AppType.Decimal;
        } else if (TYPE_DROPDOWN.equals(string)) {
            return AppType.Dropdown;
        } else if (TYPE_NUMBER.equals(string)) {
            return AppType.Number;
        } else if (TYPE_STRING.equals(string)) {
            return AppType.String;
        } else if (TYPE_TEXT.equals(string)) {
            return AppType.Text;
        } else {
            throw new IOException("unknown type of " + string);
        }
    }
}
