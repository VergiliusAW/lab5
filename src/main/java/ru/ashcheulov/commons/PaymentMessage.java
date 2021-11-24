package ru.ashcheulov.commons;

public class PaymentMessage {
    private final String message;

    public PaymentMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
