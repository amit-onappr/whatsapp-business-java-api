package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Optional.
 *
 * @param name     Specifies the sender's profile name.
 * @param username The sender's WhatsApp username, when they have adopted one.
 */
public record Profile(

        @JsonProperty("name") String name,

        @JsonProperty("username") String username

) {
    /** Kept for callers written before {@code username} existed. */
    public Profile(String name) {
        this(name, null);
    }
}