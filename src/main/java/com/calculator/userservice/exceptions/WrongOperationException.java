package com.calculator.userservice.exceptions;

import com.calculator.userservice.enums.APIResponseCodeENUM;

/**
 * Created by akashdeepnew on 26/12/18.
 */
public class WrongOperationException  extends APIBaseException {
    public WrongOperationException() {
        super(APIResponseCodeENUM.WRONG_FORMAT);
    }
}