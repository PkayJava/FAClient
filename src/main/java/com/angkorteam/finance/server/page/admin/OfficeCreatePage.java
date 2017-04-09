package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.faclient.SystemService;
import com.angkorteam.finance.faclient.dto.system.Office;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.MasterPage;
import com.angkorteam.finance.server.provider.OfficeChoiceProvider;
import com.angkorteam.framework.wicket.markup.html.form.Form;
import com.angkorteam.framework.wicket.markup.html.form.select2.Option;
import com.angkorteam.framework.wicket.markup.html.form.select2.Select2SingleChoice;
import com.angkorteam.framework.wicket.markup.html.panel.TextFeedbackPanel;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.PropertyModel;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class OfficeCreatePage extends MasterPage {

    private Option parentEntity;
    private Select2SingleChoice<Option> parentField;
    private TextFeedbackPanel parentFeedback;

    private Form<Void> form;

    @Override
    protected void doInitialize(Border layout) {
        add(layout);

        SystemService systemService = Platform.getBean(SystemService.class);
        Call<List<Office>> call = systemService.officeList();
        Response<List<Office>> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
        }

        this.form = new Form<>("form");
        layout.add(this.form);

        this.parentField = new Select2SingleChoice<>("parentField", new PropertyModel<>(this, "parentEntity"), new OfficeChoiceProvider(response.body()));
        this.form.add(this.parentField);
        this.parentFeedback = new TextFeedbackPanel("parentFeedback", this.parentField);
        this.form.add(this.parentFeedback);
    }

}
