package com.haeungun.mocketl.database;

import com.haeungun.mocketl.model.PaymentStats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StatsGenderPaymentDao implements PaymentDao {
    private static final String TABLE_NAME = "statsPaymentPerGender";
    private static final String INSERT_QUERY = "INSERT INTO $tableName (gender, userCount, payment) "
                                                + "VALUES (?, ?, ?)";

    private ConnectionManager connectionManager;

    public StatsGenderPaymentDao(String dbUrl) {
        this.connectionManager = new ConnectionManager(dbUrl);
    }

    @Override
    public int insertOne(PaymentStats statsPayment) {
        int numOfInserted = 0;

        String query = INSERT_QUERY.replace("$tableName", TABLE_NAME);

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = this.connectionManager.getConnection();
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, statsPayment.getName());
            pstmt.setInt(2, statsPayment.getUserCount());
            pstmt.setInt(3, statsPayment.getPayment());
            numOfInserted = pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO handling error
            e.printStackTrace();
        } finally {
            this.connectionManager.close(connection, pstmt, rs);
        }

        return numOfInserted;
    }
}
