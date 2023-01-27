import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTests {
    @Test
    public void testByIP( ) {
        String testIP = "172.0.32.11";
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        GeoServiceImpl geoService = new GeoServiceImpl();
        Location actualResult = geoService.byIp(testIP);

        Assertions.assertEquals(expected.getCountry(), actualResult.getCountry());
        Assertions.assertEquals(expected.getCity(), actualResult.getCity());
        Assertions.assertEquals(expected.getStreet(), actualResult.getStreet());
        Assertions.assertEquals(expected.getBuiling(), actualResult.getBuiling());
    }
}
