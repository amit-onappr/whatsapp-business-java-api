package com.whatsapp.api.domain.messages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.domain.messages.type.MessageType;
import com.whatsapp.api.domain.webhook.Profile;
import com.whatsapp.api.domain.webhook.Status;
import com.whatsapp.api.domain.webhook.System;
import com.whatsapp.api.domain.webhook.type.MessageStatus;

/** A WhatsApp username user is addressed by business-scoped user ID in {@code recipient}, not {@code to}. */
class MessageRecipientSerializationTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void recipientIsSentInsteadOfTo() throws JsonProcessingException {
        Message message = Message.MessageBuilder.builder()
                .setRecipient("NP.1120662127531373")
                .buildTextMessage(new TextMessage().setBody("hi"));

        JsonNode json = mapper.readTree(mapper.writeValueAsString(message));

        assertEquals("NP.1120662127531373", json.get("recipient").asText());
        assertNull(json.get("to"));
        assertEquals("individual", json.get("recipient_type").asText());
        assertEquals("text", json.get("type").asText());
        assertEquals("NP.1120662127531373", message.getRecipient());
    }

    @Test
    void toIsSentWithoutRecipient() throws JsonProcessingException {
        Message message = Message.MessageBuilder.builder()
                .setTo("5511999999999")
                .buildTextMessage(new TextMessage().setBody("hi"));

        JsonNode json = mapper.readTree(mapper.writeValueAsString(message));

        assertEquals("5511999999999", json.get("to").asText());
        assertNull(json.get("recipient"));
        assertNull(message.getRecipient());
    }

    @Test
    void recipientIsKeptForEveryMessageType() {
        Message.MessageBuilder builder = Message.MessageBuilder.builder().setRecipient("US.1");

        assertEquals("US.1", builder.buildTemplateMessage(new TemplateMessage()).getRecipient());
        assertEquals("US.1", builder.buildImageMessage(new ImageMessage()).getRecipient());
        assertEquals("US.1", builder.buildLocationMessage(new LocationMessage()).getRecipient());
        assertEquals(MessageType.TEMPLATE, builder.buildTemplateMessage(new TemplateMessage()).getType());
    }

    @Test
    void compatibilityConstructorsLeaveTheNewFieldsNull() {
        com.whatsapp.api.domain.webhook.Contact contact = new com.whatsapp.api.domain.webhook.Contact(
                new Profile("Ana"), null, null, "5511999999999");
        System system = new System("5511999999999", "changed", "user_changed_number");
        Status status = new Status("wamid.1", null, null, "5511999999999", MessageStatus.SENT, "1", List.of());
        com.whatsapp.api.domain.webhook.Message message = new com.whatsapp.api.domain.webhook.Message(null, null,
                null, null, null, null, null, "5511999999999", "wamid.1", null, null, MessageType.TEXT, null, "1",
                null, null, null, null, null, null);

        assertNull(contact.userId());
        assertNull(contact.profile().username());
        assertNull(system.userId());
        assertNull(system.previousUserId());
        assertNull(status.recipientUserId());
        assertNull(message.fromUserId());
        assertEquals("5511999999999", message.from());
    }
}
