package com.nougat.application.dto.error;

import java.util.List;

public record ErrorResponse(int status, List<String> errors) {}
