package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.type.ButtonType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailsButton extends Button {
    public OrderDetailsButton() {
        super(ButtonType.ORDER_DETAILS);
    }
}
