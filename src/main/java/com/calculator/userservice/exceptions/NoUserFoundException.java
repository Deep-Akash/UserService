package com.calculator.userservice.exceptions;

import com.calculator.userservice.enums.APIResponseCodeENUM;

/**
 * Created by akashdeepnew on 26/12/18.
 */
public class NoUserFoundException  extends APIBaseException {
    public NoUserFoundException() {
        super(APIResponseCodeENUM.NO_USER_FOUND);
    }
}