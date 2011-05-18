/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userDB;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

import java.util.Date;
/**
 *
 * @author david
 */
public class SimpleUserDataBase implements UserDataBase{

    private Map<String, UserDataBaseUser> users;

    public SimpleUserDataBase() {
        users = new HashMap<String, UserDataBaseUser>();
        addUser("David", "david2901", 2);
        addUser("Flo", "florian4x4", 4);
        getUser("Flo").setAdditionalData("Florian", "Mihola", new Date());
    }

    @Override
    public void addUser(String username, String password, int stackSize) {
        UserDataBaseUser user = new UserDataBaseUser(username, password, stackSize);
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
