package com.example.t2009m1demo.until;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionHelperTest {

    @Test
    void getConnection() {
        assertNotEquals(null, ConnectionHelper.getConnection());
    }
}