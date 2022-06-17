/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.itmo.error;

/**
 *
 * @author rozov
 */
public class RowIsNotExistsFault {
    private static final String DEFAULT_MESSAGE = "Row with this rowId is not exists.";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static RowIsNotExistsFault defaultInstance() {
        RowIsNotExistsFault fault = new RowIsNotExistsFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}