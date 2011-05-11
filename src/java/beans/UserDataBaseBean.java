/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

import userDB.UserDataBase;
import userDB.SimpleUserDataBase;
/**
 *
 * @author david
 */
@ManagedBean
@ApplicationScoped
public class UserDataBaseBean implements UserDataBase {

    /** Creates a new instance of UserDataBaseBean */
    private UserDataBase db;

    public UserDataBaseBean() {
        db = new SimpleUserDataBase();
    }

    @Override
    public void addUser(String username, String password) {
        db.addUser(username, password);
    }

    @Override
    public boolean userExists(String username) {
        return db.userExists(username);
    }

    @Override
    public boolean loginUser(String username, String password) {
        return db.loginUser(username, password);
    }

}
