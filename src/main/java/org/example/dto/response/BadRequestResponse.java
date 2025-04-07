package org.example.dto.response;

import lombok.Data;

import java.util.Map;

@Data
public class BadRequestResponse {
    private Map<String, String> messages;
    private boolean success;
}
