package com.wakabatimes.hiraganaratio;

import com.wakabatimes.hiraganaratio.app.HiraganaForm;
import com.wakabatimes.hiraganaratio.app.HiraganaRatio;
import com.wakabatimes.hiraganaratio.app.HiraganaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HiraganaRatioApplication.class)
@AutoConfigureMockMvc
public class HiraganaServiceTest {
    @Autowired
    private HiraganaService hiraganaService;

    @Test
    public void calculate(){
        String input = "ああああああああああああああああああああああああああああああああああああああああああああああああああいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいいい";

        HiraganaForm form = new HiraganaForm();
        form.setInput(input);

        List<HiraganaRatio> hiraganaRatios = hiraganaService.calculate(form);
        for(HiraganaRatio hiraganaRatio : hiraganaRatios){
            log.info(hiraganaRatio.getWord() + ":" + hiraganaRatio.getRatio() + "%");
        }
    }
}
