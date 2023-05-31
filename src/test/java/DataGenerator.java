import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class DataGenerator {
    @UtilityClass
    public class Registration {

        public String getCity(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return faker.address().cityName();
        }

        public String getDate(int addedDays, String locale) {
            Faker faker = new Faker(new Locale(locale));
            return DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDate.now().plusDays(addedDays));

        }

        public String getLastAndFirstName(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return faker.name().lastName() + " " + faker.name().firstName();
        }

        public String getPhone(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return faker.phoneNumber().phoneNumber();
        }

    }

}
