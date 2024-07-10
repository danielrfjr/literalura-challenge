package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class GutendexClient implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Buscar livro por título");
            System.out.println("2. Listar todos os livros");
            System.out.println("3. Listar autores dos livros");
            System.out.println("4. Listar autores vivos em determinado ano");
            System.out.println("5. Exibir quantidade de livros por idioma");
            System.out.println("6. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (choice) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String title = scanner.nextLine();
                    Book book = bookService.fetchBook(title);
                    if (book != null) {
                        System.out.println("Livro encontrado e salvo: " + book);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 2:
                    List<Book> books = bookService.getAllBooks();
                    books.forEach(System.out::println);
                    break;
                case 3:
                    List<Author> authors = authorService.getAllAuthors();
                    authors.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Digite o ano: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha
                    List<Author> livingAuthors = authorService.getLivingAuthorsInYear(year);
                    livingAuthors.forEach(System.out::println);
                    break;
                case 5:
                    bookService.displayBooksByLanguageStatistics();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
