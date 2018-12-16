package com.library.utils.messages;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Message {
	@NonNull
	private String title;
	@NonNull
	private String text;
	
	public Message() {
		this.title="text";
		this.text="cos";
	}
	
}
