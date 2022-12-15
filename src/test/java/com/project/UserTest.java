package com.project;


import com.project.database.entity.Users;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
    public class UserTest {

        @Test
        public void testUserCreation() {
            // Create a new user with some test data
            Users users = new Users(11,"steve","banks", "cookiesyum@11.com", "password",
                    "11234 Acme rd", "Acme", "CA", "99999");

            // Verify that the user's first and last names are correct
            Assert.assertEquals("John", users.getFirstName());
            Assert.assertEquals("john.doe@gmail.com", users.getEmail());

            // Verify that the user's email address is correct
            Assert.assertEquals("john.doe@gmail.com", users.getEmail());
        }

        @Test
        public void testUserPassword() {
            // Create a new user with a test password
            Users user = new Users(11,"steve","banks", "cookiesyum@11.com", "password",
                    "11234 Acme rd", "Acme", "CA", "99999");

            // Verify that the user's password is correct
            Assert.assertEquals("p@ssw0rd", user.getPassword());

            // Verify that the user's password can be changed
            user.setPassword("newP@ssw0rd");
            Assert.assertEquals("newP@ssw0rd", user.getPassword());
        }

        @Test
        @Ignore
        public void test(){
            Assertions.assertEquals("Hank", "Bob");
        }


    }



