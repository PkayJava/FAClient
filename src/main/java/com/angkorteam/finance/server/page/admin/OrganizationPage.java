package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.server.layout.MasterPage;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class OrganizationPage extends MasterPage {

    @Override
    protected void doInitialize(Border layout) {
        add(layout);

        BookmarkablePageLink<Void> officeBrowsePage = new BookmarkablePageLink<>("officeBrowsePage", OfficeBrowsePage.class);
        layout.add(officeBrowsePage);
    }
}
