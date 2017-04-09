package com.angkorteam.finance.server.provider;

import com.angkorteam.finance.faclient.dto.system.Office;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.framework.wicket.markup.html.form.select2.Option;
import com.angkorteam.framework.wicket.markup.html.form.select2.SingleChoiceProvider;
import com.google.gson.Gson;
import org.apache.wicket.model.IModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class OfficeChoiceProvider extends SingleChoiceProvider<Option> {

    private List<Office> offices;

    public OfficeChoiceProvider(List<Office> offices) {
        this.offices = offices;
    }

    @Override
    public Option toChoice(String id) {
        Option option = null;
        for (Office office : this.offices) {
            if (String.valueOf(office.getId()).equals(id)) {
                option = new Option();
                option.setId(String.valueOf(office.getId()));
                option.setText(office.getName());
                break;
            }
        }
        return option;
    }

    @Override
    public List<Option> query(String term, int page) {
        List<Option> options = new ArrayList<>();
        for (Office office : this.offices) {
            if (office.getName().startsWith(term)) {
                Option option = new Option(String.valueOf(office.getId()), office.getName());
                options.add(option);
            }
        }
        return options;
    }

    @Override
    public Gson getGson() {
        return Platform.getBean(Gson.class);
    }

    @Override
    public boolean hasMore(String term, int page) {
        return false;
    }

    @Override
    public Object getDisplayValue(Option object) {
        return object.getText();
    }

    @Override
    public String getIdValue(Option object, int index) {
        return object.getId();
    }

    @Override
    public Option getObject(String id, IModel<? extends List<? extends Option>> choices) {
        for (Option option : choices.getObject()) {
            if (option.getId().equals(id)) {
                return option;
            }
        }
        return null;
    }

}
