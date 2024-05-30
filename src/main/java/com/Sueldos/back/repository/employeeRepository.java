package com.Sueldos.back.repository;

import java.sql.Types;
import java.util.List;

import com.Sueldos.back.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Sueldos.back.model.Employee;

@Repository
@Slf4j
public class employeeRepository implements Crud<Employee>{

    private final String SQL_SELECT_BASE = "SELECT * FROM employee";

    private final String SQL_INSERT = "INSERT INTO employee(id_employee, name, last_name, dni, birth_date, address, phone, email, hiring_date, department_department_id, contract_type_id_contract_type, position_id_position) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    private final String SQL_DELETE = "DELETE FROM employee WHERE id_employee = ?";

    private final String SQL_UPDATE = "UPDATE employee SET name = ? , last_name = ?, dni = ?, birth_date = ?, address =?, phone =?, email =?, hiring_date = ? , department_department_id =?, contract_type_id_contract_type =?, position_id_position =?  WHERE id_employee = ?";

    private final String SQL_ACTIVATE = "UPDATE employee SET state = 1 WHERE id = ?";



    @Autowired
    private JdbcTemplate conexion;

    @Override
    public List<Employee> getAll() {
        return conexion.query(SQL_SELECT_BASE, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public List<Employee> getAllbyState(int state) {
        // TODO Auto-generated method stub
        return conexion.query("SELECT * FROM employee WHERE state = ? ORDER BY ID ASC",new Object[] { state },new int [] {Types.INTEGER},BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public Employee getForId(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Employee> get(Employee bean) {
        return conexion.query(SQL_SELECT_BASE, BeanPropertyRowMapper.newInstance(Employee.class));
    }



    @Override
    public void insert(Employee bean) {
        // TODO Auto-generated method stub
        System.out.print(bean);
        var id = conexion.queryForObject("SELECT MAX(id_employee) as id FROM employee", Integer.class) + 1;
        conexion.update(SQL_INSERT,id,bean.getName(),bean.getLast_name(),bean.getDni(),bean.getBirth_date(),bean.getAddress(),bean.getPhone(),bean.getEmail(),bean.getHiring_date(),bean.getDepartment_department_id(), bean.getContract_type_id_contract_type(), bean.getPosition_id_position());
    }


    @Override
    public void update(Employee bean) {
        conexion.update(SQL_UPDATE,bean.getName(),bean.getLast_name(),bean.getDni(),bean.getBirth_date(),bean.getAddress(),bean.getPhone(),bean.getEmail(),bean.getHiring_date(),bean.getDepartment_department_id(), bean.getContract_type_id_contract_type(), bean.getPosition_id_position(), bean.getId_employee());
    }

    @Override
    public void delete(String id) {
        conexion.update(SQL_DELETE,id);
    }

    @Override
    public void activate(String id) {
        conexion.update(SQL_ACTIVATE,id);
    }





}



