package taskList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Task;

public class App {

    private static List<Task> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        menu();

        int option;

        do {
            System.out.print("\n");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();

            switch (option) {
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
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (option != 5);

        sc.close();
    }

    private static void menu() {
        System.out.println("Bem-vindo ao gerenciador de tarefas!\n");
        System.out.println("Menu: ");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Remover tarefa");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("4. Exibir tarefas");
        System.out.println("5. Sair");
    }

    private static void addTask() {
        System.out.print("Digite a descrição da tarefa: ");
        sc.nextLine();
        String task = sc.nextLine();
        list.add(new Task(task));
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void removeTask() {
        System.out.print("Qual o índice da tarefa que deseja remover: ");
        int ind = sc.nextInt() - 1;  // Ajustar para índice base 0
        if (ind >= 0 && ind < list.size()) {
            list.remove(ind);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private static void markAsCompleted() {
        System.out.print("Qual o índice da tarefa que deseja marcar como concluída: ");
        int ind = sc.nextInt() - 1;  // Ajustar para índice base 0
        if (ind >= 0 && ind < list.size()) {
            list.get(ind).concluded();
            System.out.println("A tarefa (" + (ind + 1) + ") foi marcada como concluída!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private static void displayTask() {
        if (list.size() == 0) {
            System.out.println("Nenhuma tarefa no momento!");
        } else {
            System.out.println("Tarefas: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ": " + list.get(i).toString());
            }
        }
    }

    private static void exit() {
        System.out.print("Deseja salvar em um bloco de notas na área de trabalho? (responda com:[y/n]): ");
        char c = sc.next().charAt(0);

        if (c == 'y' || c == 'Y') {
            System.out.println();

            System.out.print("Digite o nome para o bloco de notas: ");
            sc.nextLine();  // Consumir a quebra de linha
            String note = sc.nextLine();

            String path = "C:\\Users\\gabriel.souza\\Desktop\\" + note + ".txt";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                bw.write("Tarefas: \n");
                for (int i = 0; i < list.size(); i++) {
                    bw.write((i + 1) + ": " + list.get(i).toString());
                    bw.newLine();
                }
            } catch (IOException k) {
                k.printStackTrace();
            }
            System.out.println("Salvando e saindo...");
        } else {
            System.out.println("Saindo...");
        }
    }
}