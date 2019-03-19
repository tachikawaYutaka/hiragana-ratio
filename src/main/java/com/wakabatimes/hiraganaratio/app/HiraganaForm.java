package com.wakabatimes.hiraganaratio.app;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class HiraganaForm {
    @Size(min=1,max=100000)
    private String input;
}
