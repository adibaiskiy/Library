package lms.service;

import lms.dao.LibraryDAO;
import lms.dao.impl.LibraryDaoImpl;
import lms.models.Library;

import java.util.List;

public class LibraryService implements LibraryDAO {
    LibraryDAO libraryDAO = new LibraryDaoImpl();

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        return libraryDAO.saveLibrary(libraries);
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryDAO.getAllLibraries();
    }

    @Override
    public Library getLibraryById(Long id) {
        return libraryDAO.getLibraryById(id);
    }

    @Override
    public Library updateLibrary(Long id, Library updatedLibrary) {
        return libraryDAO.updateLibrary(id, updatedLibrary);
    }

    @Override
    public String deleteLibraryById(Long id) {
        return libraryDAO.deleteLibraryById(id);
    }
}
