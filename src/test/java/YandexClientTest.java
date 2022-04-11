import com.models.yandex.TranslationsModel;
import com.models.yandex.YandxTranslateModel;
import com.yandx_client_new.YandxTranslationClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class YandexClientTest {

    @Test
    public void YandexResponseTest() {
        List<TranslationsModel> translationsModel = new ArrayList<>();
        translationsModel.add(new TranslationsModel("yes"));
        translationsModel.add(new TranslationsModel("no"));
        YandxTranslateModel yandxTranslateModel = new YandxTranslateModel(translationsModel);

        YandxTranslateModel actual = YandxTranslationClient.translate("ru", "en", "да нет");
        Assertions.assertEquals(yandxTranslateModel, actual);
    }
}
