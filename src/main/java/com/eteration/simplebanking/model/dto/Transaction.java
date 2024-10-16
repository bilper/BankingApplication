
package com.eteration.simplebanking.model.dto;

import java.util.LinkedHashMap;
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
    "date",
    "amount",
    "type",
    "approvalCode"
})
@Generated("jsonschema2pojo")
public class Transaction {

    @JsonProperty("date")
    private String date;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("type")
    private String type;
    @JsonProperty("approvalCode")
    private String approvalCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public Transaction withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transaction withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Transaction withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("approvalCode")
    public String getApprovalCode() {
        return approvalCode;
    }

    @JsonProperty("approvalCode")
    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public Transaction withApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
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

    public Transaction withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
