package web.sample.dto;

import java.util.Date;

public class Board {

	private int boardno;
	private String title;
	private String content;
	private String userid;
	private String username;
	private int hit;
	private Date writedate;

	public Board() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", title=" + title + ", content=" + content + ", userid=" + userid
				+ ", username=" + username + ", hit=" + hit + ", writedate=" + writedate + "]";
	}

	public Board(int boardno, String title, String content, String userid, String username, int hit, Date writedate) {
		super();
		this.boardno = boardno;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.username = username;
		this.hit = hit;
		this.writedate = writedate;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

}
