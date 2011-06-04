/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userDB;

import java.util.Collection;

/**
 *
 * @author david
 */
public interface UserDataBase {
    public void addUser(String username, String password, String gameSize, String continent);

    public boolean userExists(String username);

    public boolean loginUser(String username, String password);

    public UserDataBaseUser getUser(String username);

    public Collection<UserDataBaseUser> getUsers();
}
