package web.sample.dto;

public class Member {

	private String userid;
	private String userpw;
	private String username;
	private String userphone;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String userid, String userpw, String username, String userphone) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userphone = userphone;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", userphone=" + userphone
				+ "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

}
