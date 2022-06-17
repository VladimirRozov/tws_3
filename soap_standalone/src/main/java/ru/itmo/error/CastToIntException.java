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

@WebFault(faultBean = "ru.itmo.error.CastToIntFault")
public class CastToIntException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final CastToIntFault fault;

    public CastToIntException(String message, CastToIntFault fault) {
        super(message);
        this.fault = fault;
    }

    public CastToIntException(String message, CastToIntFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public CastToIntFault getFaultInfo() {
        return fault;
    }

}