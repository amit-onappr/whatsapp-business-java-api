package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Interactive.
 *
 * @param listReply   Used on Webhooks related to List Messages                    Contains a list {@link ListReply} object.
 * @param type        Contains the type of interactive object. Supported options are:<ul>                    <li>button_reply: for responses of Reply Buttons.</li>                    <li>list_reply: for responses to List Messages and other interactive objects.</li></ul>
 * @param buttonReply Used on Webhooks related to Reply Buttons.                    Contains a {@link ButtonReply} reply object.
 * @param nfmReply    Received when a user submits a WhatsApp Flow.               Contains a {@link NfmReply} object.
 */
public record Interactive(

        @JsonProperty("list_reply") ListReply listReply,

        @JsonProperty("type") String type,

        @JsonProperty("button_reply") ButtonReply buttonReply,

        @JsonProperty("nfm_reply") NfmReply nfmReply) {

}