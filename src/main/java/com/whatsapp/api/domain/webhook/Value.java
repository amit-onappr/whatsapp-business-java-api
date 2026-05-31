package com.whatsapp.api.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.webhook.type.EventType;

import java.util.List;

/**
 * The type Value.
 *
 * @param metadata                The metadata about your phone number.
 * @param messagingProduct        The messaging service used for Webhooks. For WhatsApp messages, this value needs to be set to “whatsapp”.
 * @param messages                An array of message objects. Added to Webhooks for incoming message notifications.
 * @param contacts                An array of contacts
 * @param statuses                An array of message status objects. Added to Webhooks for message status update.
 * @param decision                Used if a decision about accounts or phone numbers has been made. (APPROVED or REJECTED)
 * @param displayPhoneNumber      Includes the display phone number of the business  account that triggered the notification.
 * @param event                   Used when an event happened in a specific WABA. See {@link EventType}
 * @param messageTemplateId       The message template ID
 * @param messageTemplateLanguage The message template language
 * @param messageTemplateName     The message template name
 * @param phoneNumber             the phone number
 * @param reason                  reason
 * @param rejectionReason         If a request was rejected, this field displays the reason for that rejection.
 * @param requestedVerifiedName   This field displays the name that was sent to be verified.
 * @param previousQualityScore    For message_template_quality_update — quality score before this change (GREEN / YELLOW / RED).
 * @param newQualityScore         For message_template_quality_update — quality score after this change.
 * @param previousCategory        For template_category_update — category before Meta's reclassification.
 * @param newCategory             For template_category_update — category Meta is moving the template to (immediate or scheduled).
 * @param correctCategory         For template_category_update — Meta's recommended category (may differ from newCategory on scheduled events).
 * @param currentCategory         For template_category_update — what the template is right now during a scheduled transition (set even when newCategory describes a future state).
 * @param categoryUpdateTimestamp For template_category_update — when the change becomes effective. Free-form string (epoch seconds or ISO) — Meta has varied the format.
 */
public record Value(

        @JsonProperty("metadata") Metadata metadata,

        @JsonProperty("messaging_product") String messagingProduct,

        @JsonProperty("messages") List<Message> messages,

        @JsonProperty("contacts") List<Contact> contacts,

        @JsonProperty("statuses") List<Status> statuses,

        @JsonProperty("event") EventType event,

        @JsonProperty("phone_number") String phoneNumber,

        @JsonProperty("message_template_id") String messageTemplateId,

        @JsonProperty("message_template_name") String messageTemplateName,

        @JsonProperty("message_template_language") String messageTemplateLanguage,

        @JsonProperty("reason") String reason,

        @JsonProperty("display_phone_number") String displayPhoneNumber, @JsonProperty("decision") String decision,

        @JsonProperty("requested_verified_name") String requestedVerifiedName,

        @JsonProperty("rejection_reason") Object rejectionReason,

        @JsonProperty("disable_info") DisableInfo disableInfo,

        @JsonProperty("current_limit") String currentLimit,

        @JsonProperty("ban_info") BanInfo banInfo,

        @JsonProperty("restriction_info") List<RestrictionInfo> restrictionInfo,

        @JsonProperty("previous_quality_score") String previousQualityScore,

        @JsonProperty("new_quality_score") String newQualityScore,

        @JsonProperty("previous_category") String previousCategory,

        @JsonProperty("new_category") String newCategory,

        @JsonProperty("correct_category") String correctCategory,

        @JsonProperty("current_category") String currentCategory,

        @JsonProperty("category_update_timestamp") String categoryUpdateTimestamp


) {

    /**
     * Compatibility constructor preserving the canonical signature from v0.6.4-nfm.
     * Callers that built {@code new Value(...)} positionally against the older
     * library can keep working without padding {@code null}s for the webhook fields
     * added in v0.6.5+. New webhook fields (quality score, category, etc.) default
     * to {@code null} — those are only meaningful for non-message webhook events
     * and callers that don't supply them weren't testing those events anyway.
     */
    public Value(
            Metadata metadata,
            String messagingProduct,
            List<Message> messages,
            List<Contact> contacts,
            List<Status> statuses,
            EventType event,
            String phoneNumber,
            String messageTemplateId,
            String messageTemplateName,
            String messageTemplateLanguage,
            String reason,
            String displayPhoneNumber,
            String decision,
            String requestedVerifiedName,
            Object rejectionReason,
            DisableInfo disableInfo,
            String currentLimit,
            BanInfo banInfo,
            List<RestrictionInfo> restrictionInfo) {
        this(metadata, messagingProduct, messages, contacts, statuses, event, phoneNumber,
                messageTemplateId, messageTemplateName, messageTemplateLanguage, reason,
                displayPhoneNumber, decision, requestedVerifiedName, rejectionReason,
                disableInfo, currentLimit, banInfo, restrictionInfo,
                null, null, null, null, null, null, null);
    }

}
