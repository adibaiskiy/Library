package practice.dao.daoImpl;

import practice.dao.PharmacyDao;
import practice.database.Database;
import practice.model.Pharmacy;

import javax.xml.crypto.Data;
import java.util.List;

public class PharmacyDaoImpl implements PharmacyDao {

    @Override
    public String savePharmacy(Pharmacy pharmacy) {
        Database.pharmacies.add(pharmacy);
        return "Success";
    }

    @Override
    public List<Pharmacy> getAllPharmacy() {
        return Database.pharmacies;
    }

    @Override
    public Pharmacy getById(Long pharmacyId) {
        for (Pharmacy pharmacy: Database.pharmacies){
            if (pharmacy.getId().equals(pharmacyId)){
                return pharmacy;
            }
        }
        return null;
    }

    @Override
    public String updatePharmacy(Long pharmacyId, Pharmacy newPharmacy) {
        Pharmacy pharmacy = getById(pharmacyId);
        pharmacy.setName(newPharmacy.getName());
        pharmacy.setAddress(newPharmacy.getAddress());
        return "successfully updated";
    }

    @Override
    public String deletePharmacy(Long pharmacyId) {
        Pharmacy pharmacy = getById(pharmacyId);
        Database.pharmacies.remove(pharmacy);

        return "successfully deleted";
    }
}
