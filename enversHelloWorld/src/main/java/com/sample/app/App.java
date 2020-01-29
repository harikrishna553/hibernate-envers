package com.sample.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.app.entity.Employee;
import com.sample.app.repository.EmployeeRepository;

@SpringBootApplication
public class App {

	private static void printEmployee(Employee emp) {
		System.out.println("------------------------------");
		System.out.println("Id : " + emp.getId());
		System.out.println("firstName : " + emp.getFirstName());
		System.out.println("lastName : " + emp.getLastName());

		System.out.println("------------------------------");
	}

	public static void main(String args[]) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository employeeRepository) {
		return (args) -> {
			Employee emp1 = new Employee();

			emp1.setFirstName("Krishna");
			emp1.setLastName("Gurram");
			emp1.setAge(23);
			emp1.setUpdatedBy("Ram");

			emp1 = employeeRepository.save(emp1);
			printEmployee(emp1);
			
			emp1.setFirstName("Gopi");
			emp1 = employeeRepository.save(emp1);
			
			employeeRepository.delete(emp1);

		};
	}

}