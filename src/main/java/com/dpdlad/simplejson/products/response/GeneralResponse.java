package com.dpdlad.simplejson.products.response;

import java.util.List;

public class GeneralResponse<T> {
    private T data;
    private List<T> multiData;
    private int statusCode;
    private String statusMessage;

    public List<T> getMultiData() {
        return multiData;
    }

    public void setMultiData(List<T> multiData) {
        this.multiData = multiData;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
