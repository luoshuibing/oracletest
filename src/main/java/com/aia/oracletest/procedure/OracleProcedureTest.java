package com.aia.oracletest.procedure;

import oracle.jdbc.OracleTypes;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author FM
 * @Description
 * @create 2020-10-26 23:09
 */
public class OracleProcedureTest {

    @Test
    public void test1() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.111.131:1521:orcl"
                , "freeman"
                , "freeman");
        CallableStatement statement = conn.prepareCall("{call pro_student_add(?,?)}");
        statement.setString(1, "周十");
        statement.setLong(2, 1l);
        statement.execute();
        statement.close();
        conn.close();
    }

    @Test
    public void test2() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.111.131:1521:orcl"
                , "freeman"
                , "freeman");
        CallableStatement statement = conn.prepareCall("{call pro_student_add(?,?,?)}");
        statement.setString(1, "周十");
        statement.setLong(2, 1l);
        statement.registerOutParameter(3, OracleTypes.NUMBER);
        statement.execute();
        long aLong = statement.getLong(3);
        System.out.println(aLong);
        statement.close();
        conn.close();
    }


}
