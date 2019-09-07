package com.example.hr;

import com.example.hr.entity.Employee;
import com.example.hr.exception.EmployeeNotFound;
import com.example.hr.repository.EmployeeRepository;
import com.example.hr.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrBackendApplicationTests {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void findByIdentity_existingEmployee() {
        Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
        Mockito.when(employeeRepository.findById("12345678910"))
                .thenReturn(Optional.of(jack));
        assertEquals(employeeService.findByIdentity(jack.getIdentity()), jack);
    }

    @Test(expected = EmployeeNotFound.class)
    public void findByIdentity_nonexistingEmployee() {
        Mockito.when(employeeRepository.findById("12345678910"))
                .thenReturn(Optional.empty());
        employeeService.findByIdentity("12345678910");
    }

}

