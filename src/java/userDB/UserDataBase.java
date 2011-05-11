/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userDB;

/**
 *
 * @author david
 */
public interface UserDataBase {
    public void addUser(String username, String password);

    public boolean userExists(String username);

    public boolean loginUser(String username, String password);
}
