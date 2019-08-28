package com.jh.common.model.demo;

import lombok.Data;

@Data
public class JsonResult {

    private int stateCode;

    private String message;

    private Object data;

}
