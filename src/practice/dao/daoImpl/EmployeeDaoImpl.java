package practice.dao.daoImpl;

import practice.dao.EmployeeDao;
import practice.dao.PharmacyDao;
import practice.database.Database;
import practice.model.Employee;
import practice.model.Pharmacy;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public String saveEmployee(Employee employee) {
        Database.employees.add(employee);
        return "Success";
    }

    @Override
    public String assignEmployeeToPharmacy(Long pharmacyId, Long employeeId) {
        for (Pharmacy pharmacy : Database.pharmacies) {
            if (pharmacy.getId().equals(pharmacyId)){
                for (Employee employee : Database.employees) {
                    if (employee.getId().equals(employeeId)) {

                    }
                }
            }
        }
        return "";
    }
}
