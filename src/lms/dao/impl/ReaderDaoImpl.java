package lms.dao.impl;

import lms.dao.ReaderDAO;
import lms.models.Library;
import lms.models.Reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderDaoImpl implements ReaderDAO {
    private List<Reader> readers = new ArrayList<>();
    private List<Library> libraries;

    public void ReaderService(List<Library> libraries) {
        this.libraries = libraries;
    }

    @Override
    public List<Reader> saveReader(Reader reader) {
        return readers;
    }

    @Override
    public List<Reader> getAllReaders() {
        return readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        return readers.stream().filter(reader -> reader.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Reader updateReader(Long id, Reader updatedReader) {
        Reader reader = getReaderById(id);
        if (reader != null) {
            reader.setFullName(updatedReader.getFullName());
            reader.setEmail(updatedReader.getEmail());
            reader.setPhoneNumber(updatedReader.getPhoneNumber());
            reader.setGender(updatedReader.getGender());
        }
        return reader;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader reader = getReaderById(readerId);
        Library library = libraries.stream().filter(lib -> lib.getId().equals(libraryId)).findFirst().orElse(null);
        if (library != null && reader != null) {
            library.getReaders().add(reader);
        }
    }
}
