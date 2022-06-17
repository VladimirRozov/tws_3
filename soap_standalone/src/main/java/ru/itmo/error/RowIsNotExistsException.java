/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.itmo.error;

/**
 *
 * @author rozov
 */
import javax.xml.ws.WebFault;

@WebFault(faultBean = "ru.itmo.error.RowIsNotExistsFault")
public class RowIsNotExistsException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final RowIsNotExistsFault fault;

    public RowIsNotExistsException(String message, RowIsNotExistsFault fault) {
        super(message);
        this.fault = fault;
    }

    public RowIsNotExistsException(String message, RowIsNotExistsFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public RowIsNotExistsFault getFaultInfo() {
        return fault;
    }
}
