import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.Map;

import static ru.netology.entity.Country.RUSSIA;

public class MessageSenderImplTestsRus {
    @Test
    public void testSendRus() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", RUSSIA, "Lenina", 15));

        LocalizationService locService = Mockito.mock(LocalizationService.class);
        Mockito.when(locService.locale(RUSSIA))
                .thenReturn("Добро пожаловать");
        String expectedResult = "Добро пожаловать";

        MessageSenderImpl msi = new MessageSenderImpl(geoService, locService);
        String actualResult = msi.send(Map.of("x-real-ip", "172.0.32.11"));

        Assertions.assertEquals(expectedResult, actualResult);

    }


}
