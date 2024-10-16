
package com.eteration.simplebanking.model.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accountNumber",
    "owner",
    "balance",
    "createDate",
    "transactions"
})
@Generated("jsonschema2pojo")
public class AccountDto {

    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("balance")
    private Double balance;
    @JsonProperty("createDate")
    private String createDate;
    @JsonProperty("transactions")
    private List<Transaction> transactions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    @JsonProperty("accountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountDto withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public AccountDto withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    @JsonProperty("balance")
    public Double getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountDto withBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    @JsonProperty("createDate")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("createDate")
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public AccountDto withCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    @JsonProperty("transactions")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @JsonProperty("transactions")
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public AccountDto withTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public AccountDto withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
