package practice.service;

import practice.model.Medicine;

import java.util.List;

public interface MedicineService {
    String savaMedicine(Long pharmacy, Medicine medicine);
    List<Medicine> getAllMedicineByPharmacyId(Long pharmacyId);
    Medicine getById(Long medicineId);
    String updateMedicine(Long medicineId, Medicine newMedicine);
    String deleteMedicine(Long medicineId);
}
