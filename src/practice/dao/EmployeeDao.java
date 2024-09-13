package practice.dao;

import practice.model.Employee;

public interface EmployeeDao {
    String saveEmployee(Employee employee);
    String assignEmployeeToPharmacy(Long pharmacyId, Long employeeId);
}
