package co.k.prj.board.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class SnsVO extends CommentsVO {
	private int sNo;
	private String sWriter;
	private Date sDate;
	private String sTitle;
	private String sContents;
	private int sAno;
}
