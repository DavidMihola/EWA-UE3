/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userDB;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
/**
 *
 * @author david
 */
public class SimpleUserDataBase implements UserDataBase{

    private Map<String, UserDataBaseUser> users;

    public SimpleUserDataBase() {
        users = new HashMap<String, UserDataBaseUser>();
        addUser("David", "david2901");
    }

    @Override
    public void addUser(String username, String password) {
        UserDataBaseUser user = new UserDataBaseUser(username, password);
        if (! userExists(username) ) {
            users.put(username, user);
        }
    }

    @Override
    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    @Override
    public boolean loginUser(String username, String password) {
        if (! userExists(username) ) {
            return false;
        }
        
        return (users.get(username).isPassword(password));
    }

    public UserDataBaseUser getUser(String username) {
        return users.get(username);
    }

    public Collection<UserDataBaseUser> getUsers() {
        return users.values();
    }
}
