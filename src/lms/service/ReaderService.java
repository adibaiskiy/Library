package lms.service;

import lms.dao.ReaderDAO;
import lms.dao.impl.ReaderDaoImpl;
import lms.models.Reader;

import java.util.List;

public class ReaderService implements ReaderDAO {
    ReaderDAO readerDAO = new ReaderDaoImpl();

    @Override
    public List<Reader> saveReader(Reader reader) {
        return readerDAO.saveReader(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return readerDAO.getAllReaders();
    }

    @Override
    public Reader getReaderById(Long id) {
        return readerDAO.getReaderById(id);
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        return readerDAO.updateReader(id, reader);
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {

        readerDAO.assignReaderToLibrary(readerId,libraryId);
    }
}
