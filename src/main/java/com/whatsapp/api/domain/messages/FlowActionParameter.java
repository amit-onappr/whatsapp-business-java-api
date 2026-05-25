package com.whatsapp.api.domain.messages;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Flow action parameter.
 * Required for flow buttons. Serializes as
 * {@code { "type": "action", "action": { "flow_token": "...", "flow_action_data": {...} } }}.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/sendingaflow">Sending a Flow</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowActionParameter extends Parameter {
    @JsonProperty("action")
    private final FlowAction action;

    /**
     * Instantiates a new Flow action parameter.
     *
     * @param action the flow action
     */
    public FlowActionParameter(FlowAction action) {
        super(ParameterType.ACTION);
        this.action = action;
    }

    /**
     * Gets action.
     *
     * @return the action
     */
    public FlowAction getAction() {
        return action;
    }

    /**
     * The flow action object carried by a flow button parameter.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class FlowAction {
        @JsonProperty("flow_token")
        private final String flowToken;
        @JsonProperty("flow_action_data")
        private final Map<String, Object> flowActionData;

        /**
         * Instantiates a new Flow action.
         *
         * @param flowToken      developer-generated token echoed back in the flow response webhook
         * @param flowActionData optional data payload for the flow's first screen (may be null)
         */
        public FlowAction(String flowToken, Map<String, Object> flowActionData) {
            this.flowToken = flowToken;
            this.flowActionData = flowActionData;
        }

        /**
         * Gets flow token.
         *
         * @return the flow token
         */
        public String getFlowToken() {
            return flowToken;
        }

        /**
         * Gets flow action data.
         *
         * @return the flow action data
         */
        public Map<String, Object> getFlowActionData() {
            return flowActionData;
        }
    }
}
