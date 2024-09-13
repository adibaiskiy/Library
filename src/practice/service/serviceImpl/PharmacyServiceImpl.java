package practice.service.serviceImpl;

import practice.dao.PharmacyDao;
import practice.dao.daoImpl.PharmacyDaoImpl;
import practice.model.Pharmacy;
import practice.service.PharmacyService;

import java.util.List;

public class PharmacyServiceImpl implements PharmacyService {
    PharmacyDao pharmacyDao = new PharmacyDaoImpl();

    @Override
    public String savePharmacy(Pharmacy pharmacy) {
        return pharmacyDao.savePharmacy(pharmacy);
    }

    @Override
    public List<Pharmacy> getAllPharmacy() {
        return pharmacyDao.getAllPharmacy();
    }

    @Override
    public Pharmacy getById(Long pharmacyId) {
        return pharmacyDao.getById(pharmacyId);
    }

    @Override
    public String updatePharmacy(Long pharmacyId, Pharmacy newPharmacy) {
        return pharmacyDao.updatePharmacy(pharmacyId, newPharmacy);
    }

    @Override
    public String deletePharmacy(Long pharmacyId) {
        return pharmacyDao.deletePharmacy(pharmacyId);
    }
}
