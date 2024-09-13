package lms.dao.impl;

import lms.dao.BookDAO;
import lms.dao.LibraryDAO;
import lms.models.Book;
import lms.models.Library;
import lms.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDAO {
    private List<Library> libraries;
    public BookDaoImpl(List<Library> libraries){
        this.libraries = libraries;
    }
    LibraryDaoImpl libraryDao = new LibraryDaoImpl();
    @Override
    public Book saveBook(Long libraryId, Book book) {
         Library library = libraryDao.getLibraryById(libraryId);
        if (library != null) {
            library.getBooks().add(book);
            return book;
        }
        return null;
    }



    @Override
    public List<Book> getAllBooks(Long libraryId) {
        Library library = libraryDao.getLibraryById(libraryId);
        return library != null ? library.getBooks() : new ArrayList<>();
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        return getAllBooks(libraryId).stream().filter(book -> book.getId().equals(bookId)).findFirst().orElse(null);
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        Library library = libraryDao.getLibraryById(libraryId);
        if (library != null){
            Book book = getBookById(libraryId,bookId);
            if (book != null){
                library.getBooks().remove(book);
                return "Book deleted successfully";
            }
        }
        return "book not found";
    }

    @Override
    public void clearBookByLibraryId(long libraryId) {
        Library library = libraryDao.getLibraryById(libraryId);
        if (library != null) {
            library.getBooks().clear();
        }

    }
    private Library getLibraryById(Long id){
        return libraries.stream().filter(library -> library.getId().equals(id)).findFirst().orElse(null);
    }
}
