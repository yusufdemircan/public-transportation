package com.transportation.city.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MustBeRouteHaveStops extends RuntimeException{

    public MustBeRouteHaveStops (String message){
        super(message);
    }
}
