package junit5app.models;

import junit5app.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

// @TestInstance(TestInstance.Lifecycle.PER_CLASS) -> Para que se ejecute una sola vez su ciclo de vida del test
class CuentaTest {
    Cuenta cuenta;

    @BeforeEach
    void initMetodoTest() {
        System.out.println("Iniciando el metodo");
        cuenta = new Cuenta("Diego", new BigDecimal("1000.12345"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando el metodo de prueba");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test");
    }

    @Test
    @DisplayName("Probando el nombre de la cuenta corriente")
    // @Disabled
    void testNombreCuenta() {
        // fail(); -> Fuerza el error
        Cuenta cuenta = new Cuenta();
        cuenta.setPersona("Diego");
        String expected = "Diego";
        String actual = cuenta.getPersona();

        assertEquals(expected, actual);
        assertTrue(actual.equals(expected));
    }

    @Test
    @DisplayName("Probando el saldo de la cuenta corriente")
    void testSaldoCuenta() {

        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    @DisplayName("Testeando referencias que sean iguales con el metodo equals")
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta3 = new Cuenta("John Roe", new BigDecimal("8900.9997"));

        assertEquals(cuenta, cuenta2);
        assertNotEquals(cuenta, cuenta3);
    }

    @DisplayName("Probando debito cuenta repetir!")
    @RepeatedTest(value = 5, name = "{displayName} - Repeticion numero {currentReptition} de {totalRepetitions}")
    void testDebitoCuentaRepetir(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 3) {
            System.out.println("Estamos en la repeticion " + info.getCurrentRepetition());
        }

        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo(), () -> "La cuenta no puede ser nula");
        assertEquals(900, cuenta.getSaldo().intValue(), () -> "El sueldo no es el mismo");
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @DisplayName("Test con parametros!!!!!!!!!!")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
    void testCreditoCuenta(String monto) {
        cuenta.credito(new BigDecimal(monto));

        assertNotNull(cuenta.getSaldo());
        // assertEquals(900, cuenta.getSaldo().intValue());
        assumeTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testDineroInsuficienteExceptionCuenta() {
        Cuenta cuenta = new Cuenta("Diego", new BigDecimal("1000.12345"));
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String expected = "Dinero Insuficiente";
        assertEquals(expected, actual);
    }

    @Test
    void testTransferirDineroCuentas() {
        Cuenta cuenta1 = new Cuenta("Diego", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Jhon", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("Banco Patagonia");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());
    }

    @Test
    @DisplayName("Probando relaciones entre las cuentas y el banco con assertAll")
    void testRelacionBancoCuentas() {
        Cuenta cuenta1 = new Cuenta("Diego", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Jhon", new BigDecimal("1500.8989"));

        Banco banco = new Banco("Banco Patagonia");
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        assertAll( // Permite seguir ejecutando los demas tests aunque falle uno antes
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Banco Patagonia", cuenta1.getBanco().getNombre()),
                () -> {
                    assertEquals("Diego", banco.getCuentas().stream()
                            .filter(c -> c.getPersona().equals("Diego"))
                            .findFirst()
                            .get().getPersona());
                },
                () -> assertTrue(banco.getCuentas().stream()
                        .anyMatch(c -> c.getPersona().equals("Diego")))
        );
    }

    @Nested // Indica que es una clase añidada - Se puede poner Before/AfterEach dentro de ella
    @DisplayName("Probando el sistema operativo")
    class SistemaOperativosTests {
        @RepeatedTest(3)
        @EnabledOnOs(OS.WINDOWS)
        public void testSoloWindows() {
        }

        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})
        public void testSoloLinuxMac() {
        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
        public void testNoWindows() {
        }
    }

    @Nested // Indica que es una clase añidada
    @DisplayName("Probando la version de java")
    class JavaVersionTest {
        @RepeatedTest(3)
        @EnabledOnJre(JRE.JAVA_8)
        void testSoloJdk8() {
        }

        @Test
        @EnabledOnJre(JRE.JAVA_16)
        void testSoloJdk16() {
        }

        @Test
        @DisabledOnJre(JRE.JAVA_16)
        void testNoJdk16() {
        }
    }

    @Nested // Indica que es una clase añidada
    @DisplayName("Probando el system property")
    class SystemPropertiesTest {
        @RepeatedTest(3)
        void testImprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k, y) -> System.out.println(k + ":" + y));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "16.0.1")
        void testJavaVersion() {
        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
        void testNO64() {
        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testCustomENV() {
        }
    }

    @Nested // Indica que es una clase añidada
    @DisplayName("Probando variables de ambiente")
    class VariablesDeAmbienteTest {
        @RepeatedTest(value = 5, name = "Repeticion numero: {currentRepetition} de {totalRepetitions}")
        void imprimirVariablesAmbiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k, v) -> System.out.println(k + " = " + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = "D:\\Cursos\\jdk-15.0.1")
        void testJavaHome() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void testProcesadores() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "dev")
        void testEnv() {
        }
    }

    @Test
    @DisplayName("test Saldo Cuenta Dev") // TODO: Con Asumting desabilita el tests
    void testSaldoCuentaDev() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev); // Asume que es de desarrollo, si no lo es no continua la prueba
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    @DisplayName("test Saldo Cuenta Dev") // TODO: Con Asumting desabilita el tests
    void testSaldoCuentaDev2() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumingThat(esDev, () -> {
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        });
    }

    @DisplayName("Test con parametros!!!!!!!!!!")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000"})
    void testDebitoCuentaCsvSource(String index, String monto) {
        System.out.println(index + " -> " + monto);
        cuenta.credito(new BigDecimal(monto));

        assertNotNull(cuenta.getSaldo());
        assumeTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @DisplayName("Test con parametros!!!!!!!!!!")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @CsvFileSource(resources = "/data.csv")
    void testDebitoCuentaCsvFileSource(String monto) {
        cuenta.credito(new BigDecimal(monto));

        assertNotNull(cuenta.getSaldo());
        assumeTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @DisplayName("Test con parametros!!!!!!!!!!")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @CsvFileSource(resources = "/data2.csv")
    void testDebitoCuentaCsvFileSource2(String saldo, String monto, String esperado, String actual) {
        cuenta.setSaldo(new BigDecimal(saldo));
        cuenta.debito(new BigDecimal(monto));
        cuenta.setPersona(actual);

        assertNotNull(cuenta.getSaldo());
        assertNotNull(cuenta.getPersona());
        assertEquals(esperado, actual);
        assumeTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @DisplayName("Test con parametros!!!!!!!!!! y Tag")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @MethodSource("montoList")
    @Tag("params")
    void testDebitoCuentaMethodSource(String monto) {
        cuenta.credito(new BigDecimal(monto));

        assertNotNull(cuenta.getSaldo());
        assumeTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    private static List<String> montoList() {
        return Arrays.asList("100", "200", "300", "500", "700", "1000");
    }

    @Test
    @DisplayName("Test con inyeccion de info y reporte")
    void testDebitoConID(TestInfo testInfo, TestReporter testReporter) {
        System.out.println("ejecutando: " + testInfo.getDisplayName() + " " + testInfo.getTestMethod()
                .orElse(null)
                .getName());
        cuenta.credito(new BigDecimal(100));

        assertNotNull(cuenta.getSaldo());
        assumeTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @Tag("timeout")
    void testPruebaTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
    }

    //TODO: Ingresar surefire plugins nos permite poner tasks para ejecutar nuestros tests (se pone en el pom.xml)
    // Maven -> LifeCycle -> test
}