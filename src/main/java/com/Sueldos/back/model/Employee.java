package com.Sueldos.back.model;

public class Employee {

	private int id_employee;
	private String name;
	private String last_name;
	private String dni;
	private String birth_date;
	private String address;
	private String phone;
	private String email;
	private String hiring_date;
	private int department_department_id;
	private int contract_type_id_contract_type;
	private int position_id_position;


	public int getId_employee() {
		return id_employee;
	}

	public String getName() {
		return name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getDni() {
		return dni;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getHiring_date() {
		return hiring_date;
	}

	public int getDepartment_department_id() {
		return department_department_id;
	}

	public int getContract_type_id_contract_type() {
		return contract_type_id_contract_type;
	}

	public int getPosition_id_position() {
		return position_id_position;
	}

	public void setContract_type_id_contract_type(int contract_type_id_contract_type) {
		this.contract_type_id_contract_type = contract_type_id_contract_type;
	}

	public void setPosition_id_position(int position_id_position) {
		this.position_id_position = position_id_position;
	}

	public void setDepartment_department_id(int department_department_id) {
		this.department_department_id = department_department_id;
	}

	public void setHiring_date(String hiring_date) {
		this.hiring_date = hiring_date;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}

	@Override
	public String toString() {
		return "employee{" +
				"id_employee=" + id_employee +
				", name='" + name + '\'' +
				", last_name='" + last_name + '\'' +
				", dni='" + dni + '\'' +
				", birth_date='" + birth_date + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", hiring_date='" + hiring_date + '\'' +
				", department_department_id=" + department_department_id +
				", contract_type_id_contract_type=" + contract_type_id_contract_type +
				", position_id_position=" + position_id_position +
				'}';
	}
}
