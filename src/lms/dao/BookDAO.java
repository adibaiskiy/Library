package lms.dao;

import lms.models.Book;
import lms.models.Library;

import java.util.List;

public interface BookDAO {
    Book saveBook(Long libraryId, Book book);
    List<Book> getAllBooks(Long libraryId);
    Book getBookById(Long libraryId, Long bookId);
    String deleteBook(Long libraryId, Long bookId);
    void clearBookByLibraryId (long libraryId);

}
