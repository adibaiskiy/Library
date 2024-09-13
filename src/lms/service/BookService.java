package lms.service;

import lms.dao.BookDAO;
import lms.dao.impl.BookDaoImpl;
import lms.models.Book;
import lms.models.Reader;

import java.util.ArrayList;
import java.util.List;

public class BookService implements BookDAO {
    BookDAO bookDAO = new BookDaoImpl(new ArrayList<>());

    @Override
    public Book saveBook(Long libraryId, Book book) {
        return bookDAO.saveBook(libraryId,book);
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        return bookDAO.getAllBooks(libraryId);
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        return bookDAO.getBookById(libraryId,bookId);
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        return bookDAO.deleteBook(libraryId,bookId);
    }

    @Override
    public void clearBookByLibraryId(long libraryId) {
        bookDAO.clearBookByLibraryId(libraryId);
    }
}
