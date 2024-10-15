package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.AccountService;
import com.eteration.simplebanking.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountController {

    private final  TransactionService transactionService;

    private final      AccountService accountService;

    public AccountController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @GetMapping(value = "/account/v1/{accountNumber}")
    public ResponseEntity getAccount(@PathVariable String accountNumber) {
        try {
            Account existingAccount = accountService.findAccount(accountNumber);
            return ResponseEntity.status(HttpStatus.OK).body(existingAccount);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping(value = "/account/v1/credit/{accountNumber}")
    public ResponseEntity credit(@PathVariable String accountNumber, @RequestBody DepositTransaction transaction) {
        try {
            Account existingAccount = accountService.findAccount(accountNumber);
            String approvalCode = transactionService.getApprovalCode();
            transaction.setApprovalCode(approvalCode);
            if (existingAccount == null){
                Account newAccount = new Account("New ", accountNumber);
                newAccount.post(transaction);
                accountService.saveAccount(newAccount);
            } else {
                existingAccount.post(transaction);
                accountService.saveAccount(existingAccount);
            }
            return ResponseEntity.status(HttpStatus.OK).body(new TransactionStatus("OK", transaction.getApprovalCode()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping(path = "/account/v1/debit/{accountNumber}")
    public ResponseEntity debit(@PathVariable String accountNumber, @RequestBody WithdrawalTransaction transaction)
    throws InsufficientBalanceException {
        try {
            Account existingAccount = accountService.findAccount(accountNumber);
            String approvalCode = transactionService.getApprovalCode();
            transaction.setApprovalCode(approvalCode);
            if (existingAccount == null){
                Account newAccount = new Account("New", accountNumber);
                newAccount.post(transaction);
                accountService.saveAccount(newAccount);
            } else {
                existingAccount.post(transaction);
                accountService.saveAccount(existingAccount);
            }
            return ResponseEntity.status(HttpStatus.OK).body(new TransactionStatus("OK", transaction.getApprovalCode()));

        } catch (InsufficientBalanceException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            throw new InsufficientBalanceException();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
	}
}
