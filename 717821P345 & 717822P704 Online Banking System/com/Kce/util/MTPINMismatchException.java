package com.Kce.util;
import java.lang.*;
public class MTPINMismatchException extends Exception{
    //toString() to return wrong MIPIN
    @Override
    public String toString() {
        return "Wrong MTPIN";
    }
}
