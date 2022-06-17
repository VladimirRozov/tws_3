/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.itmo.error;

/**
 *
 * @author rozov
 */
public class EmptyFieldFault {
    private static final String DEFAULT_MESSAGE = "This method cannot contain parameters with " +
            "empty strings or strings with spaces only!";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static EmptyFieldFault defaultInstance() {
        EmptyFieldFault fault = new EmptyFieldFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
