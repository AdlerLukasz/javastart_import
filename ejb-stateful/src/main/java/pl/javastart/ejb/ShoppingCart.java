package pl.javastart.ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.sql.DataSource;

@Stateful
public class ShoppingCart implements ShoppingCartLocal, ShoppingCartRemote {
    private DataSource ds;
    private Connection conn;
    //...
    
    @PrePassivate
    private void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @PostActivate
    private void getConnection() {
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Remove
    public void cancelShopping() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
