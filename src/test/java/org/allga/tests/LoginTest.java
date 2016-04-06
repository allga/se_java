package org.allga.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() throws Exception {
        assertThat(app.getMovieHelper().isLoggedIn(), equalTo(true));
    }
}
