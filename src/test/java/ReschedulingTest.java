import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ReschedulingTest {
    String locale = "ru";
    String city = DataGenerator.Registration.getCity(locale);
    String firstDate = DataGenerator.Registration.getDate(11, locale);
    String secondDate = DataGenerator.Registration.getDate(17, locale);
    String lastAndFirstName = DataGenerator.Registration.getLastAndFirstName(locale);
    String phone = DataGenerator.Registration.getPhone(locale);
    @Test
    void positiveTest() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue(city);
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(firstDate);
        $("[data-test-id=name] input").setValue(lastAndFirstName);
        $("[data-test-id=phone] input").setValue(phone);
        $("[data-test-id=agreement]").click();
        $(By.className("button_size_m")).click();
        $("[data-test-id=success-notification]").shouldHave(Condition.text("Встреча успешно запланирована на "+firstDate)).shouldBe(Condition.visible);
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(secondDate);
        $(By.className("button_size_m")).click();
        $("[data-test-id=replan-notification]").shouldHave(Condition.text("Перепланировать?")).shouldBe(Condition.visible);
        $(By.className("button_size_s")).click();
        $("[data-test-id=success-notification]").shouldHave(Condition.text("Встреча успешно запланирована на "+secondDate)).shouldBe(Condition.visible);


    }
}
