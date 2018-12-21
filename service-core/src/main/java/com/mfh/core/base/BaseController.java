package com.mfh.core.base;

import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    public ResponseEntity ok(Object t){
        return ResponseEntity.ok().body(t);
    }
}
