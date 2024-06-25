package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.enums.Stats;

public class Options extends Task{
	
	Scanner sc = new Scanner(System.in);
	List <Task> list = new ArrayList<>();
	
	public Options(String task, Stats stats) {
		super(task, stats);
	}
	
	public void addTask(String task, Stats stats) {
		
		System.out.print("Digite a descrição da tarefa: ");
		task = sc.nextLine();
		String stat = sc.nextLine();
		
				
	}
	

}
