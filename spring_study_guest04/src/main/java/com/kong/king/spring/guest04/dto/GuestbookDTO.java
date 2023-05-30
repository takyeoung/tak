package com.kong.king.spring.guest04.dto;

import java.time.LocalDateTime;

import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestbookDTO {
	
	private Long gno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate, modDate;

}
