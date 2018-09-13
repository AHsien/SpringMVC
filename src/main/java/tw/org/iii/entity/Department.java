package tw.org.iii.entity;

public class Department {

	private Integer id;
	private String departmentName;

	public Department() {
	}

	public Department(int id, String departmentName) {
		this.id = id;
		this.departmentName = departmentName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
