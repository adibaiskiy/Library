package practice;

import practice.database.GenerateId;
import practice.model.Pharmacy;
import practice.service.MedicineService;
import practice.service.PharmacyService;
import practice.service.serviceImpl.PharmacyServiceImpl;

public class Main {
    public static void main(String[] args) {
        PharmacyService pharmacyService = new PharmacyServiceImpl();
        Pharmacy pharmacy1 = new Pharmacy(GenerateId.genPharmacy(),"Neman", "Vostor5");
        Pharmacy pharmacy2 = new Pharmacy(GenerateId.genPharmacy(),"Neman", "Vostor5");
        System.out.print("Save Pharmacy -> ");
        System.out.println(pharmacyService.savePharmacy(pharmacy1));
        System.out.println(pharmacyService.savePharmacy(pharmacy2));
        System.out.println("Get all-> ");
        System.out.println(pharmacyService.getAllPharmacy());
        System.out.println("Get by id -> ");
        System.out.println(pharmacyService.getById(2L));
        System.out.print("Update -> ");
//        Pharmacy newPharmacy = new Pharmacy("neman update", "vostor51");
//        pharmacyService
        System.out.println(pharmacyService.getAllPharmacy());

        System.out.println("---------Medicine------------");

    }
}
