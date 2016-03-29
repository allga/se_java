package org.allga.tests;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() throws Exception {
        login("admin", "admin");
    }
}
