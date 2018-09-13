package tw.org.iii.entity;

public class User {

	private Integer id;

	private String userName;
	private String password;

	private String email;
	private int age;

	private Address address;

	public User() {

	};

	public User(String userName, String password, String email, int age) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	public User(Integer id, String userName, String password, String email, int age) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", age="
				+ age + "]";
	}

	// @Override
	// public String toString() {
	// return "User [userName=" + userName + ", password=" + password + ", email=" +
	// email + ", age=" + age
	// + ", address=" + address + "]";
	// }

}
