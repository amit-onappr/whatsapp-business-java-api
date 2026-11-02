package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Contact.
 *
 * @param profile The {@link Profile} object.
 * @param waId    The WhatsApp ID of the customer. You can send messages using this wa_id. Omitted when the
 *                customer has a WhatsApp username and their phone number can't be shared.
 * @param userId  The customer's business-scoped user ID (e.g. "US.13491208655302741918"). Always present on
 *                inbound messages since April 2026; send to it with {@code recipient} when there is no wa_id.
 */
public record Contact(

        @JsonProperty("profile") Profile profile,

        @JsonProperty("name") Name name,

        @JsonProperty("phones") List<Phone> phones,

        @JsonProperty("wa_id") String waId,

        @JsonProperty("user_id") String userId) {

    /** Kept for callers written before {@code user_id} existed. */
    public Contact(Profile profile, Name name, List<Phone> phones, String waId) {
        this(profile, name, phones, waId, null);
    }
}