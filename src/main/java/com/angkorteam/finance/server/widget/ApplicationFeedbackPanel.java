package com.angkorteam.finance.server.widget;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Page;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class ApplicationFeedbackPanel extends FeedbackPanel {

    private Level level;

    public ApplicationFeedbackPanel(String id, Level level) {
        super(id, message -> {
            if (message.getReporter() == null || message.getReporter() instanceof Form || message.getReporter() instanceof Page) {
                if (level == Level.Danger) {
                    return message.getLevel() == FeedbackMessage.ERROR || message.getLevel() == FeedbackMessage.DEBUG || message.getLevel() == FeedbackMessage.FATAL;
                } else if (level == Level.Info) {
                    return message.getLevel() == FeedbackMessage.INFO;
                } else if (level == Level.Success) {
                    return message.getLevel() == FeedbackMessage.SUCCESS;
                } else if (level == Level.Warning) {
                    return message.getLevel() == FeedbackMessage.WARNING;
                }
            }
            return false;
        });
        this.level = level;
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();
        WebMarkupContainer feedbackul = (WebMarkupContainer) get("feedbackul");
        feedbackul.add(AttributeModifier.replace("class", this.level.getCssClass()));
    }

    public enum Level {

        Danger("callout callout-danger"), Info("callout callout-info"), Warning("callout callout-warning"), Success("callout callout-success");

        private final String cssClass;

        Level(String cssClass) {
            this.cssClass = cssClass;
        }

        public String getCssClass() {
            return this.cssClass;
        }
    }

}
