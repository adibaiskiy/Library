package lms.dao;

import lms.models.Reader;

import java.util.List;

public interface ReaderDAO {
    List<Reader> saveReader(Reader reader);
    List<Reader> getAllReaders();
    Reader getReaderById(Long id);
    Reader updateReader(Long id, Reader reader);
    void assignReaderToLibrary(Long readerId, Long libraryId);

}
