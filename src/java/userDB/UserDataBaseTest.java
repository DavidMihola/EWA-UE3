/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userDB;

/**
 *
 * @author david
 */
public class UserDataBaseTest {
    static void assertFalse(boolean val) {
        assert (!val);
    }

    public static void main(String[] args) {
        UserDataBase db = new SimpleUserDataBase();

        // Registriere neuen User und teste Login
        db.addUser("David", "dav1d");
        assert(db.userExists("David"));
        assert(db.loginUser("David", "dav1d"));


        // Eine zweite Registrierung ist nicht möglich,
        // d.h. im Moment gibt es keine Möglichkeit, das Passwort
        // zu ändern
        db.addUser("David", "dav2d");
        assert(db.userExists("David"));
        assertFalse(db.loginUser("David", "dav2d"));

        // Ein nicht registrierter User kann sich nicht anmelden
        assertFalse(db.userExists("Florian"));
        assertFalse(db.loginUser("Florian", "fl0r1an"));

        // Zweiter Benützer wird angelegt
        db.addUser("Florian", "fl0r1an");
        assert(db.userExists("Florian"));
        assert(db.loginUser("Florian", "fl0r1an"));

        System.out.println("Alle Tests geschafft!");
    }
}
