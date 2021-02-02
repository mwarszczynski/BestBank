package com.example.demo.utils;

import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * Contains methods to generate unique account number for indicated account types.
 * Methods are beta and do not yet check the uniqueness of the account numbers.
 * At the end this and similar classes will be set as external libs/dependency.
 *
 * @author MW
 */
@Component
public class AccountNumberGenerator {

//    private Random random;
//
//    Integer randomedUniqueAccountNumber;
//    Integer uniqueAccountNumber;
//
//    private final int prefixDomesticAcc = 27;
//    private final int prefixForeignAcc = 28;
//    private final int prefixCurrencyAcc = 29;
//    private final int accNumberLength = 26;
//
//    public AccountNumberGenerator(Random random) {
//        this.random = random;
//    }
//
//    public void generateUniqueDomesticAccountNumber() {
//        uniqueAccountNumber = prefixDomesticAcc + randomSequence();
//    }
//
//    public void generateUniqueForeignAccountNumber() {
//        uniqueAccountNumber = prefixForeignAcc + randomSequence();
//    }
//
//    public void generateUniqueCurrencyForeignAccountNumber() {
//        uniqueAccountNumber = prefixCurrencyAcc + randomSequence();
//    }
//
//    public Integer randomSequence() {
//        for (int i = 0; i <= accNumberLength - 2; i++) {
//            randomedUniqueAccountNumber = random.nextInt(10);
//        }
//        return randomedUniqueAccountNumber;
//    }

}