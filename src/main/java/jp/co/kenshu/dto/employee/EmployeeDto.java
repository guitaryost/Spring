package jp.co.kenshu.dto.employee;

//ControllerからViewに情報を渡す用途で使用
public class EmployeeDto {
	private String name;
	private Integer age;
	private String memo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
