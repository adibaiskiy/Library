package practice.service;

import practice.model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    //    CRUD
//    create
    String savePharmacy(Pharmacy pharmacy);
    //    read
    List<Pharmacy> getAllPharmacy();
    Pharmacy getById(Long pharmacyId);
    //update
    String updatePharmacy(Long pharmacyId, Pharmacy newPharmacy);
    //    delete
    String deletePharmacy(Long pharmacyId);

}
