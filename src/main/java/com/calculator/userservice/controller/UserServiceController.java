package com.calculator.userservice.controller;


import com.calculator.userservice.enums.APIResponseCodeENUM;
import com.calculator.userservice.exceptions.APIBaseException;
import com.calculator.userservice.model.request.UserCreditRequest;
import com.calculator.userservice.model.request.UserDebitRequest;
import com.calculator.userservice.model.response.APIResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserServiceController {

    @PostMapping("/debit")
    @ResponseBody
    public APIResponse calculate(@RequestBody UserDebitRequest userDebitRequest) throws Exception {
        return APIResponse.buildSuccess("");
    }

    @PostMapping("/credit")
    @ResponseBody
    public APIResponse calculate(@RequestBody UserCreditRequest userCreditRequest) throws Exception {
        return APIResponse.buildSuccess("");
    }

    @ExceptionHandler
    @ResponseBody
    public APIResponse handleException(Exception ex) {
        if (ex instanceof APIBaseException){
            return APIResponse.buildFailure(((APIBaseException) ex).getApiResponseCodeENUM());
        }
        return APIResponse.buildFailure(APIResponseCodeENUM.GENERAL_FAILURE);
    }
}