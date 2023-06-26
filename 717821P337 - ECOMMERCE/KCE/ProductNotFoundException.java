package KCE;
import java.util.*;
import java.sql.*;
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
