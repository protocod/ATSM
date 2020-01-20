package com.xpi.atsm.data;

import com.xpi.atsm.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            if((username.compareTo("asd") == 0) && (password.compareTo("asdasd") == 0)) {
                LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe");
                return new Result.Success<>(fakeUser);
            }
            else {
                return new Result.Error(new Exception("Invalid username or password"));
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
