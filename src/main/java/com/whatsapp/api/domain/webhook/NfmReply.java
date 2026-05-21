package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the nfm_reply object received when a user submits a WhatsApp Flow.
 *
 * @param name         The name of the flow (always "flow")
 * @param body         The body text shown after submission
 * @param responseJson JSON string containing the submitted form field values
 */
public record NfmReply(

        @JsonProperty("name") String name,

        @JsonProperty("body") String body,

        @JsonProperty("response_json") String responseJson) {

}
