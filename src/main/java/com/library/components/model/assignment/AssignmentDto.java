package com.library.components.model.assignment;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class AssignmentDto {
	private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long userId;
    private Long bookId;
}
