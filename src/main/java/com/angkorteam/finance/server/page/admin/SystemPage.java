package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.server.layout.MasterPage;
import org.apache.wicket.markup.html.border.Border;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class SystemPage extends MasterPage {

    @Override
    protected void doInitialize(Border layout) {
        add(layout);
    }
}
