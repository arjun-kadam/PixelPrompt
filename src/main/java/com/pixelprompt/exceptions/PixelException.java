package com.pixelprompt.exceptions;

import lombok.Getter;

@Getter
public class PixelException extends RuntimeException{
    private final int status;

    public PixelException(int status, String message){
        super(message);
        this.status = status;
    }
}
