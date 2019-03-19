package com.wakabatimes.hiraganaratio.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private HiraganaService hiraganaService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @PostMapping("/ratio")
    public String ratioPost(@ModelAttribute @Validated HiraganaForm form, BindingResult result, RedirectAttributes attr, Model model){
        List<HiraganaRatio> hiraganaRatios = hiraganaService.calculate(form);
        model.addAttribute("form",form);
        model.addAttribute("hiraganaRatios",hiraganaRatios);
        return "ratio";
    }
}
