package com.example.fraudcore.Controller;

import com.example.fraudcore.Domain.Customer;
import com.example.fraudcore.Domain.Transaction;
import com.example.fraudcore.Model.TransactionRequest;
import com.example.fraudcore.Model.TransactionResponse;
import com.example.fraudcore.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @PostMapping("/test")
    public String saveCustomer(@RequestBody Customer customer){
        return transactionService.createCustomer(customer.getFullName(), customer.getNic());
    }

    @PostMapping("/makeTransaction")
    public TransactionResponse saveTxn(@RequestBody TransactionRequest transactionRequest){
        return transactionService.createTransaction(transactionRequest);
    }

    @GetMapping("/allTransaction")
    public List<Transaction> getAllTransactions(){

        return transactionService.getAllTransactions();
    }
}
