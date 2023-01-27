import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.Map;


import static ru.netology.entity.Country.USA;

public class MessageSenderImplTestsEng {
    @Test
    public void testSendEng() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService locService = Mockito.mock(LocalizationService.class);
        Mockito.when(locService.locale(USA))
                .thenReturn("Welcome");
        String expectedResult = "Welcome";

        MessageSenderImpl msi = new MessageSenderImpl(geoService, locService);
        String actualResult = msi.send(Map.of("x-real-ip", "96.44.183.149"));

        Assertions.assertEquals(expectedResult, actualResult);

    }
}
