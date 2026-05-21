package com.whatsapp.api.domain.templates.type;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * The enum Button type.
 */
public enum ButtonType {
    PHONE_NUMBER,
    URL,
    QUICK_REPLY,
    VOICE_CALL,
    ORDER_DETAILS,
    COPY_CODE,
    CATALOG,
    OTP,
    @JsonEnumDefaultValue
    UNKNOWN;
}
