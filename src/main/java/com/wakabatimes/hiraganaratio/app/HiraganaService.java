package com.wakabatimes.hiraganaratio.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class HiraganaService {
    public List<HiraganaRatio> calculate(HiraganaForm form) {
        List<HiraganaRatio> result = new ArrayList<>();
        String input = form.getInput();
        Pattern pattern = Pattern.compile("([\\u3040-\\u309F])");
        Matcher matcher = pattern.matcher(input);
        int groupCount = matcher.groupCount();
        Set<String> set = new HashSet<String>();
        List<String> chars = new ArrayList<>();
        while (matcher.find()) {
            for (int i=0; i<=groupCount; i++) {
                String g = matcher.group(i);
                chars.add(g);
                set.add(g);
            }
        }

        BigDecimal allCount = new BigDecimal(String.valueOf(chars.size()));
        log.info("allCount:" + String.valueOf(allCount));

        for(String item : set){
            HiraganaRatio hiraganaRatio = new HiraganaRatio();
            hiraganaRatio.setWord(item);
            int count = 0;
            for(String chara : chars){
                if(chara.equals(item)) count++;
            }
            BigDecimal thisCount = new BigDecimal(String.valueOf(count));
            log.info("thisCount: " + String.valueOf(thisCount));
            BigDecimal ratio = (thisCount.divide(allCount,2, RoundingMode.HALF_UP));
            log.info("ratio: " +String.valueOf(ratio));
            hiraganaRatio.setRatio(ratio.multiply(new BigDecimal(100)).intValue());
            result.add(hiraganaRatio);
        }
        return result;
    }
}
