package levina.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("properties")
public class SystemPropertiesTests {
    @Test
    void someTest4() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
        //  gradle clean properties_tests
        //  chrome

        //  gradle clean properties_tests -Dbrowser=opera
        //  opera
    }

    @Test
    void someTest5() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);

        // gradle clean properties_tests -Dbrowser=opera -Dversion=93
    }
}
