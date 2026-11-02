package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type System.
 *
 * @param newWaId Added to Webhooks for phone number updates. New WhatsApp ID of the customer.
 * @param body    Describes the system message event. Supported use cases are:                Phone number update: for when a user changes from an old number to a new number.                Identity update: for when a user identity has changed.
 * @param type    Supported types are: <ul>                <li>user_changed_number: for a user changed number notification.</li>                <li>user_identity_changed: for user identity changed notification.</li>                <li>user_changed_user_id: the customer's business-scoped user ID changed and no phone number can be shared.</li>                </ul>
 * @param userId         The customer's new business-scoped user ID.
 * @param previousUserId The customer's previous business-scoped user ID.
 */
public record System(

        @JsonProperty("new_wa_id") String newWaId,

        @JsonProperty("body") String body,

        @JsonProperty("type") String type,

        @JsonProperty("user_id") String userId,

        @JsonProperty("previous_user_id") String previousUserId) {

    /** Kept for callers written before the user-id fields existed. */
    public System(String newWaId, String body, String type) {
        this(newWaId, body, type, null, null);
    }
}