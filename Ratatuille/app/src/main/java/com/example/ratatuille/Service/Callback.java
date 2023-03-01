package com.example.ratatuille.Service;

public interface Callback {

    void returnResult(Object o);
    void returnError(Throwable e);
}
