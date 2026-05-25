package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.templates.type.ButtonType;

/**
 * The type Flow button.
 * Refers to a button bound to a WhatsApp Flow attached to the template.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowButton extends Button {

    @JsonProperty("flow_id")
    private String flowId;
    @JsonProperty("navigate_screen")
    private String navigateScreen;
    @JsonProperty("flow_action")
    private String flowAction;

    /**
     * Instantiates a new Flow button.
     */
    protected FlowButton() {
        super(ButtonType.FLOW);
    }

    /**
     * Instantiates a new Flow button.
     *
     * @param text the button label
     */
    public FlowButton(String text) {
        super(ButtonType.FLOW, text);
    }

    /**
     * Gets flow id.
     *
     * @return the flow id
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * Sets flow id.
     *
     * @param flowId the flow id
     * @return this
     */
    public FlowButton setFlowId(String flowId) {
        this.flowId = flowId;
        return this;
    }

    /**
     * Gets navigate screen.
     *
     * @return the navigate screen
     */
    public String getNavigateScreen() {
        return navigateScreen;
    }

    /**
     * Sets navigate screen.
     *
     * @param navigateScreen the navigate screen
     * @return this
     */
    public FlowButton setNavigateScreen(String navigateScreen) {
        this.navigateScreen = navigateScreen;
        return this;
    }

    /**
     * Gets flow action.
     *
     * @return the flow action
     */
    public String getFlowAction() {
        return flowAction;
    }

    /**
     * Sets flow action.
     *
     * @param flowAction the flow action
     * @return this
     */
    public FlowButton setFlowAction(String flowAction) {
        this.flowAction = flowAction;
        return this;
    }
}
