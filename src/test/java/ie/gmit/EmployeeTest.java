package ie.gmit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



public class EmployeeTest {
    Employee employee;

    @BeforeAll
    static void startingTests() {
        System.out.println("Starting tests");
    }

    @BeforeEach
    void printDisplayNames(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry(testInfo.getDisplayName());
    }

    @AfterAll
    static void testingComplete() {
        System.out.println("Testing Complete");
    }

    @DisplayName("Testing constructor initialisation success")
    @Test
    void testingConstructorSuccess() {
        employee = new Employee("Mr", "Ruairi Doherty", "NZ23AMZ3", "Contract", 123456789,23);
        assertEquals("Mr", employee.getTitle());
        assertEquals("Ruairi Doherty", employee.getName());
        assertEquals(123456789, employee.getPhone());
        assertEquals(23, employee.getAge());
        assertEquals("Contract", employee.getType());
        assertEquals("NZ23AMZ3", employee.getPps());
    }

    @DisplayName("Testing invalid title entry")
    @Test
    void testingInvalidTitle() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("M", "Random Name", "NGGGGGGG", "Contract", 123456789,44);
        });
        assertEquals("Invalid title provided", e.getMessage());
    }

    @DisplayName("Testing invalid name entry")
    @Test
    void testingInvalidName() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "Ru", "NZ23AMZ23", "Contract", 123456789,23);
        });
        assertEquals("Name must contain 3 - 25 characters", e.getMessage());
    }

    @DisplayName("Testing invalid pps entry")
    @Test
    void testingInvalidPPS() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "Ruandria", "NZ", "Contract", 123456789,23);
        });
        assertEquals("PPS must contain 8 characters", e.getMessage());
    }

    @DisplayName("Testing invalid type entry")
    @Test
    void testingInvalidType() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "Ruairi Doherty", "NZ23AM23", "none", 123456789,23);
        });
        assertEquals("Must contain employment type", e.getMessage());
    }

    @DisplayName("Testing invalid phone entry")
    @Test
    void testingInvalidPhone() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "Ruairi Doherty", "NZ23AMZ3", "Part-time", 1234569,23);
        });
        assertEquals("Phone number must be 9 digits", e.getMessage());
    }

    @DisplayName("Testing invalid age entry")
    @Test
    void testingInvalidAge() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "Ruairi Doherty", "NZ23AZ23", "Contract", 123456789,13);
        });
        assertEquals("Employee age must be over 16 to work in the company", e.getMessage());
    }
}
///testing commits