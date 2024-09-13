package lms;

import lms.models.*;
import lms.service.BookService;
import lms.service.LibraryService;
import lms.service.ReaderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Library> libraries = new ArrayList<>();

        LibraryService libraryService = new LibraryService();
        BookService bookService = new BookService();
        ReaderService readerService = new ReaderService();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Выберите опцию: \n1. Работа с библиотеками\n2. Работа с книгами\n3. Работа с читателями\n4. Выйти");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Добавить библиотеку\n2. Показать все библиотеки\n3. Найти библиотеку по ID\n4. Обновить библиотеку\n5. Удалить библиотеку");
                    int libraryOption = scanner.nextInt();

                    switch (libraryOption) {
                        case 1:
                            System.out.println("Введите ID библиотеки:");
                            Long libraryId = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("Введите название библиотеки:");
                            String libraryName = scanner.nextLine();
                            System.out.println("Введите адрес библиотеки:");
                            String address = scanner.nextLine();

                            Library library = new Library(libraryId, libraryName, address, new ArrayList<>(), new ArrayList<>());
                            List<Library> newLibraries = new ArrayList<>();
                            newLibraries.add(library);
                            libraryService.saveLibrary(newLibraries);
                            System.out.println("Библиотека добавлена.");
                            break;
                        case 2:
                            List<Library> allLibraries = libraryService.getAllLibraries();
                            System.out.println("Список всех библиотек:");
                            allLibraries.forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("Введите ID библиотеки:");
                            Long id = scanner.nextLong();
                            Library foundLibrary = libraryService.getLibraryById(id);
                            if (foundLibrary != null) {
                                System.out.println("Найдена библиотека: " + foundLibrary);
                            } else {
                                System.out.println("Библиотека не найдена.");
                            }
                            break;
                        case 4:
                            System.out.println("Введите ID библиотеки для обновления:");
                            Long updateId = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("Введите новое название:");
                            String newName = scanner.nextLine();
                            System.out.println("Введите новый адрес:");
                            String newAddress = scanner.nextLine();

                            Library updatedLibrary = new Library(updateId, newName, newAddress, new ArrayList<>(), new ArrayList<>());
                            libraryService.updateLibrary(updateId, updatedLibrary);
                            System.out.println("Библиотека обновлена.");
                            break;
                        case 5:
                            System.out.println("Введите ID библиотеки для удаления:");
                            Long deleteId = scanner.nextLong();
                            String result = libraryService.deleteLibraryById(deleteId);
                            System.out.println(result);
                            break;
                    }
                    break;

                case 2:
                    System.out.println("1. Добавить книгу в библиотеку\n2. Показать все книги в библиотеке\n3. Найти книгу по ID\n4. Удалить книгу\n5. Очистить все книги библиотеки");
                    int bookOption = scanner.nextInt();

                    switch (bookOption) {
                        case 1:
                            System.out.println("Введите ID библиотеки:");
                            Long libIdForBook = scanner.nextLong();
                            System.out.println("Введите ID книги:");
                            Long bookId = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("Введите название книги:");
                            String bookName = scanner.nextLine();
                            System.out.println("Введите автора книги:");
                            String author = scanner.nextLine();
                            System.out.println("Введите жанр книги (FICTION, NON_FICTION, FANTASY, DRAMA):");
                            String genreInput = scanner.nextLine();
                            Genre genre = Genre.valueOf(genreInput.toUpperCase());

                            Book book = new Book(bookId, bookName, author, genre);
                            bookService.saveBook(libIdForBook, book);
                            System.out.println("Книга добавлена.");
                            break;
                        case 2:
                            System.out.println("Введите ID библиотеки:");
                            Long libIdForBooks = scanner.nextLong();
                            List<Book> books = bookService.getAllBooks(libIdForBooks);
                            System.out.println("Список всех книг в библиотеке:");
                            books.forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("Введите ID библиотеки:");
                            Long libIdForFindBook = scanner.nextLong();
                            System.out.println("Введите ID книги:");
                            Long findBookId = scanner.nextLong();
                            Book foundBook = bookService.getBookById(libIdForFindBook, findBookId);
                            if (foundBook != null) {
                                System.out.println("Найдена книга: " + foundBook);
                            } else {
                                System.out.println("Книга не найдена.");
                            }
                            break;
                        case 4:
                            System.out.println("Введите ID библиотеки:");
                            Long libIdForDeleteBook = scanner.nextLong();
                            System.out.println("Введите ID книги для удаления:");
                            Long deleteBookId = scanner.nextLong();
                            String bookDeleteResult = bookService.deleteBook(libIdForDeleteBook, deleteBookId);
                            System.out.println(bookDeleteResult);
                            break;
                        case 5:
                            System.out.println("Введите ID библиотеки для очистки всех книг:");
                            Long libIdForClearBooks = scanner.nextLong();
                            bookService.clearBookByLibraryId(libIdForClearBooks);
                            System.out.println("Все книги в библиотеке удалены.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("1. Добавить читателя\n2. Показать всех читателей\n3. Найти читателя по ID\n4. Обновить читателя\n5. Назначить читателя в библиотеку");
                    int readerOption = scanner.nextInt();

                    switch (readerOption) {
                        case 1:
                            System.out.println("Введите ID читателя:");
                            Long readerId = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("Введите полное имя читателя:");
                            String fullName = scanner.nextLine();
                            System.out.println("Введите email читателя:");
                            String email = scanner.nextLine();
                            System.out.println("Введите номер телефона читателя:");
                            String phoneNumber = scanner.nextLine();
                            System.out.println("Введите пол (MALE, FEMALE, OTHER):");
                            String genderInput = scanner.nextLine();
                            Gender gender = Gender.valueOf(genderInput.toUpperCase());

                            Reader reader = new Reader(readerId, fullName, email, phoneNumber, gender);
                            readerService.saveReader(reader);
                            System.out.println("Читатель добавлен.");
                            break;
                        case 2:
                            List<Reader> readers = readerService.getAllReaders();
                            System.out.println("Список всех читателей:");
                            readers.forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("Введите ID читателя:");
                            Long findReaderId = scanner.nextLong();
                            Reader foundReader = readerService.getReaderById(findReaderId);
                            if (foundReader != null) {
                                System.out.println("Найден читатель: " + foundReader);
                            } else {
                                System.out.println("Читатель не найден.");
                            }
                            break;
                        case 4:
                            System.out.println("Введите ID читателя для обновления:");
                            Long updateReaderId = scanner.nextLong();
                            scanner.nextLine(); // для перевода строки
                            System.out.println("Введите новое полное имя:");
                            String newFullName = scanner.nextLine();
                            System.out.println("Введите новый email:");
                            String newEmail = scanner.nextLine();
                            System.out.println("Введите новый номер телефона:");
                            String newPhoneNumber = scanner.nextLine();
                            System.out.println("Введите новый пол (MALE, FEMALE, OTHER):");
                            String newGenderInput = scanner.nextLine();
                            Gender newGender = Gender.valueOf(newGenderInput.toUpperCase());


                            Reader updatedReader = new Reader(updateReaderId, newFullName, newEmail, newPhoneNumber, newGender);
                            readerService.updateReader(updateReaderId, updatedReader);
                            System.out.println("Читатель обновлен.");
                            break;
                        case 5:
                            System.out.println("Введите ID читателя:");
                            Long readerIdToAssign = scanner.nextLong();
                            System.out.println("Введите ID библиотеки для назначения:");
                            Long libraryIdToAssign = scanner.nextLong();


                            readerService.assignReaderToLibrary(readerIdToAssign, libraryIdToAssign);
                            System.out.println("Читатель назначен в библиотеку.");
                            break;
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Программа завершена.");
                    break;

                default:
                    System.out.println("Неверная опция, попробуйте снова.");
            }
        }
    }
}
