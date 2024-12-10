package org.example;

import org.example.Candidate;
import org.example.Database;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("candidates.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие: 1 - добавить кандидата, 2 - удалить кандидата, 3 - просмотреть всех кандидатов, 4 - выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистить буфер

            switch (choice) {
                case 1:
                    System.out.println("Введите пол (М/Ж):");
                    String gender = scanner.nextLine();
                    System.out.println("Введите регистрационный номер:");
                    String regNumber = scanner.nextLine();
                    System.out.println("Введите дату регистрации (Год-Месяц-Число):");
                    LocalDate regDate = LocalDate.parse(scanner.nextLine());
                    System.out.println("Введите сведения о себе:");
                    String aboutYourself = scanner.nextLine();
                    System.out.println("Введите требования к партнеру:");
                    String partnerRequirements = scanner.nextLine();

                    Candidate candidate = new Candidate(gender, regNumber, regDate, aboutYourself, partnerRequirements);
                    database.addCandidate(candidate);
                    break;

                case 2:
                    System.out.println("Введите регистрационный номер кандидата для удаления:");
                    String removeRegNumber = scanner.nextLine();
                    database.removeCandidate(removeRegNumber);
                    break;

                case 3:
                    List<Candidate> candidates = database.getCandidates();
                    System.out.println("Список кандидатов:");
                    for (Candidate c : candidates) {
                        System.out.println(c);
                    }
                    break;

                case 4:
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}