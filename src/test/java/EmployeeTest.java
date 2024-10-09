import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Employee;
import com.hrmastery.app.repository.inerfaces.EmployeeRepo;
import com.hrmastery.app.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateEmployee_Success() throws RepoException {
        Employee employee = new Employee();
        when(employeeRepo.create(employee)).thenReturn(true);

        String result = employeeServiceImpl.createEmployee(employee);

        assertEquals("Employee added successfully", result);
        verify(employeeRepo, times(1)).create(employee);
    }

    @Test
    public void testCreateEmployee_Failure() {
        Employee employee = new Employee();
        when(employeeRepo.create(employee)).thenReturn(false);

        assertThrows(RepoException.class, () -> {
            employeeServiceImpl.createEmployee(employee);
        });
        verify(employeeRepo, times(1)).create(employee);
    }
}
