import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;
import  org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LocalizationServiceImplTests {
    @ParameterizedTest
    @CsvSource ({"USA, Welcome", "RUSSIA, Добро пожаловать"})

    public void testLocale (Country country, String expectedMessage) {
        String actualMessage = new LocalizationServiceImpl().locale(country);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
