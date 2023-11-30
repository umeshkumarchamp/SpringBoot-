package com.codizworld.codizworld.model.springdatajpa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_number")
    private Long accountNumber;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person accountHolder; 

    public BankAccount() {
    }

    public BankAccount(Long id, String bankName, Long accountNumber, Person accountHolder) {
        this.id = id;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Person getAccountHolder() {
        return this.accountHolder;
    }

    public void setAccountHolder(Person accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", bankName='" + getBankName() + "'" +
            ", accountNumber='" + getAccountNumber() + "'" +
            ", accountHolder='" + getAccountHolder() + "'" +
            "}";
    }

}
