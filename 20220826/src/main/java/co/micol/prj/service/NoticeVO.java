package co.micol.prj.service;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone ="Asia/seoul")
	private java.util.Date noticeDate;
	private int noticeHit;
	private String noticeAttech;
	private String noticeAttechdir;
}
