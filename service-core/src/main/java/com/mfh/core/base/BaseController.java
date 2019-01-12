package com.mfh.core.base;

import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    public ResponseEntity ok(Object result){
        if (result instanceof String){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.ok(result);
        }
    }
}
