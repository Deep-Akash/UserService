package com.calculator.userservice.controller;


import com.calculator.userservice.dao.daoServices.UserDAO;
import com.calculator.userservice.dao.entity.User;
import com.calculator.userservice.enums.APIResponseCodeENUM;
import com.calculator.userservice.exceptions.APIBaseException;
import com.calculator.userservice.model.request.UserCreditRequest;
import com.calculator.userservice.model.request.UserDebitRequest;
import com.calculator.userservice.model.response.APIResponse;
import com.calculator.userservice.service.UserCreditService;
import com.calculator.userservice.service.UserDebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserServiceController {

    @Autowired
    private UserCreditService userCreditService;

    @Autowired
    private UserDebitService userDebitService;

    @Autowired
    private UserDAO userDAO;

    @PostMapping("/debit")
    @ResponseBody
    public APIResponse debit(@RequestBody UserDebitRequest userDebitRequest) throws Exception {
        userDebitService.debitUserBalance(userDebitRequest);
        return APIResponse.buildSuccess("");
    }

    @PostMapping("/credit")
    @ResponseBody
    public APIResponse credit(@RequestBody UserCreditRequest userCreditRequest) throws Exception {
        userCreditService.topUpUserBalance(userCreditRequest.getUserEmailId(),userCreditRequest.getTopUp());
        return APIResponse.buildSuccess("");
    }

    @GetMapping("/get")
    @ResponseBody
    public APIResponse getUser(@RequestParam("email") String emailId) throws Exception {
        User user = userDAO.findUserWithEmail(emailId);
        if (StringUtils.isEmpty(user)){
            return APIResponse.buildFailure(APIResponseCodeENUM.NO_USER_FOUND);
        }
        return APIResponse.buildSuccess(user);
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