package practice.dao;

import practice.model.Pharmacy;

import java.util.List;
import java.util.SimpleTimeZone;

public interface PharmacyDao {
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

