package com.ruCode.filmorate.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private final String error;
    private final String message;
}
