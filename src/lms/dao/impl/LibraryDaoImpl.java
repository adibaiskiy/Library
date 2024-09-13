package lms.dao.impl;

import lms.dao.LibraryDAO;
import lms.models.Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryDaoImpl implements LibraryDAO {
    private List<Library> libraries = new ArrayList<>();
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        this.libraries.addAll(libraries);
        return List.of();
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        return libraries.stream().filter(library -> library.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Library updateLibrary(Long id, Library updatedLibrary) {
        Library library = getLibraryById(id);
        if (library != null){
            library.setName(updatedLibrary.getName());
            library.setAddress(updatedLibrary.getAddress());
            library.setBooks(updatedLibrary.getBooks());
            library.setReaders(updatedLibrary.getReaders());
        }
        return library;
    }

    @Override
    public String deleteLibraryById(Long id) {
        Library library = getLibraryById(id);
        if (library != null){
            libraries.remove(library);
            return "Library deleted successfully";
        }
        return "Library not found";
    }
}
