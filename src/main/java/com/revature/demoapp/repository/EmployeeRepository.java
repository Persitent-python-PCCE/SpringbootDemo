package com.revature.demoapp.repository;

import com.revature.demoapp.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
//
//    @Query("SELECT e FROM Employee e WHERE e.role = :role AND e.salary > :salary ORDER BY e.salary DESC")
//    List<Employee> findByRole(@Param("role") String role, @Param("salary") double salary);

    @Query(value="""
SELECT * FROM employees e INNER JOIN 
    departments d ON e.department_id = d.id 
         WHERE name = :name 
""", nativeQuery = true)
    List<Employee> findByDeparmentName(@Param("dept") String name);

    //pagination
    // total records/ no of records per page = total pages
    Page<Employee> findByRole(String role, Pageable pageable);

}
