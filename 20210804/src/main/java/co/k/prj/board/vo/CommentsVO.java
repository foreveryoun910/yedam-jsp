package co.k.prj.board.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class CommentsVO {
	private int sNo;
	private int cNo;
	private String cName;
	private String cSubject;
	private Date cDate;
}
