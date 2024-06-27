package taskList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Task;

public class App {
	
	private static List <Task> list = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	private static Task ts = new Task(null); 

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);

		menu();
		
		int option;
		
		do {
			System.out.print("\n");
			System.out.print("Escolha uma opção: ");
			option = sc.nextInt();
			
			switch(option) {
				case 1:
					addTask();
					
					break;
				case 2:
					removeTask();
					
					break;
				case 3:
					markAsCompleted();
					
					break;
				case 4:
					displayTask();
					
					break;
				case 5:	
					exit();
				
					break;
				default:
					System.out.println("Opção invalida!");
					
					break;
			}
		
		} while(option != 5);
		
		sc.close();
	}
	
	private static void menu() {
		System.out.println("Bem vindo ao gerenciador de tarefas!\n");
		System.out.println("Menu: ");
		System.out.println("1. Adicionar tarefa");
		System.out.println("2. Remover tarefa");
		System.out.println("3. Marcar tarefa com concluida");
		System.out.println("4. Exibir tarefas");
		System.out.println("5. Sair");
	}
	
	private static void addTask() {
		System.out.print("Digite a descrição da tarefa: ");
		sc.nextLine();
		String task = sc.nextLine();
		list.add(new Task(task));
		System.out.println("Tarefa adicionado com sucesso!");
	}
	
	private static void removeTask() {
		System.out.print("qual o indice da tarefa que deseja remover: ");
		int ind = sc.nextInt();
		list.remove(ind);
		System.out.println("Tarefa removida com sucesso!");
	}
	
	private static void markAsCompleted() {
		System.out.print("Qual o indice da tarefa que deseja marcar como concluida: ");
		int ind = sc.nextInt();
		list.get(ind).concluded();
		System.out.println("A tarefa (" + ind + ") foi marcada como concluida!");
	}
	
	private static void displayTask() {
		if (list.size() == 0) {
			System.out.println("Nenhuma tarefa no momento!");
		}
		else {
			System.out.println("Tarefas: ");
			for (int i=0; i < list.size(); i++) {
				System.out.println(i + ": " + list.get(i).toString());
			}
		}
	}
	
	private static void exit() {
		System.out.println("Saindo...");
	}
	
}
