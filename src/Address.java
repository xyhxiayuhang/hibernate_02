
public class Address {

	private String code;// �ʱ�
	private String phone;// �绰
	private String address;// ��ַ

	public Address() {

	}

	public Address(String code, String phone, String address) {
		super();
		this.code = code;
		this.phone = phone;
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
