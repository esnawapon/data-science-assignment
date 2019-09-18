package swe.ds.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import swe.ds.assignment.mongo.model.Student;
import swe.ds.assignment.mongo.repository.StudentRepository;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired Assignment1 assignment1;
	@Autowired Assignment2 assignment2;
	@Autowired Assignment3 assignment3;
	@Autowired Assignment4 assignment4;
	@Autowired Assignment5 assignment5;
	@Autowired Assignment6 assignment6;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Start demo");
		for (String arg: args) {
			try {
				int no = Integer.parseInt(arg);
				System.out.println("Assignment #" + no);
				Demoable assignment;
				switch (no) {
					case 1: assignment = assignment1; break;
					case 2: assignment = assignment2; break;
					case 3: assignment = assignment3; break;
					case 4: assignment = assignment4; break;
					case 5: assignment = assignment5; break;
					case 6: assignment = assignment6; break;
					default: assignment = null;
				}
				if (assignment != null) {
					assignment.demo();
				}
				System.out.println("Assignment #" + no + " end");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finish demo");
	}
}
