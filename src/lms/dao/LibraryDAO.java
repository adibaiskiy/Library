package lms.dao;

import lms.models.Library;

import java.util.List;

public interface LibraryDAO {
    List<Library> saveLibrary(List<Library> libraries);
    List<Library> getAllLibraries();
    Library getLibraryById(Long id);
    Library updateLibrary(Long id, Library updatedLibrary);
    String deleteLibraryById(Long id);


}
