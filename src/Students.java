import java.util.Date;

//ѧ����

public class Students {

	// JAVA Beans�����ԭ��
	// 1.������
	// 2.�ṩ���еĲ���������Ĭ�ϵĹ��췽��
	// 3.����˽��
	// 4.����setter/getter��װ
	private int sid;// ѧ��
	private String sname;// ����
	private String gender;// �Ա�
	private Date birthday;// ��������
	// private String address;// ��ַ
	private Address address;

	public Students() {

	}

	public Students(int sid, String sname, String gender, Date birthday) {
		// super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/*
	 * public String getAddress() { return address; }
	 * 
	 * public void setAddress(String address) { this.address = address; }
	 */

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday
				+ ", address=" + address + "]";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
