package com.library.components.model.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Niezgodność edytowanej książki z id adresu")
public class BookIdConflictException extends RuntimeException {}