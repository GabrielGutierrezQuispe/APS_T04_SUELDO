package com.Sueldos.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Sueldos.back.model.Employee;
import com.Sueldos.back.repository.employeeRepository;

@RequestMapping(value="/employee",produces  = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(value = "*")
@RestController
public class EmployeeController {

	@Autowired
	private employeeRepository employeeRepository;

	@GetMapping(value="/")
	public List<Employee>Employee(){
		return employeeRepository.getAll();
	}

	@GetMapping(value="/{state}")
	public List<Employee>Employee(@PathVariable int state){
		return employeeRepository.getAllbyState(state);
	}


	@PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crearEmployee(@RequestBody Employee Employee){
		employeeRepository.insert(Employee);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable String id){
		employeeRepository.delete(id);
	}

	@PostMapping(value = "/modificar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modificarEmployee(@RequestBody Employee Employee){
		System.out.print("EDITANDO EN BACK: "+ Employee);

		employeeRepository.update(Employee);
	}

	@PostMapping(value = "/activate/{id}")
	public void activate(@PathVariable String id){
		employeeRepository.activate(id);
	}

	@GetMapping(value = "/buscar")
	public List<Employee> buscar(@RequestParam(name = "name") String name,
								 @RequestParam(name = "lastName") String lastName,
								 @RequestParam(name = "dni") String dni) {
		Employee bean = new Employee();
		bean.setName(name);
		bean.setLast_name(lastName);
		bean.setDni(dni);
		return employeeRepository.get(bean);
	}

}
