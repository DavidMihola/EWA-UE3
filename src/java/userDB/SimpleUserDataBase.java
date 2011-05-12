/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userDB;

import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author david
 */
public class SimpleUserDataBase implements UserDataBase{

    private Map<String, String> users;

    public SimpleUserDataBase() {
        users = new HashMap<String, String>();
        addUser("David", "david2901");
    }

    @Override
    public void addUser(String username, String password) {
        if (! userExists(username) ) {
            users.put(username, password);
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
        
        return (users.get(username).equals(password));
    }

}
