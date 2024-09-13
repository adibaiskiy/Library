package practice.service.serviceImpl;

import practice.dao.MedicineDao;
import practice.dao.daoImpl.MedicineDaoImpl;
import practice.model.Medicine;
import practice.service.MedicineService;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {
    MedicineDao medicineDao = new MedicineDaoImpl();
    @Override
    public String savaMedicine(Long pharmacy, Medicine medicine) {

        return "";
    }

    @Override
    public List<Medicine> getAllMedicineByPharmacyId(Long pharmacyId) {
        return List.of();
    }

    @Override
    public Medicine getById(Long medicineId) {
        return null;
    }

    @Override
    public String updateMedicine(Long medicineId, Medicine newMedicine) {
        return "";
    }

    @Override
    public String deleteMedicine(Long medicineId) {
        return "";
    }
}
