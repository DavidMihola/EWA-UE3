/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
//import javax.faces.validator.Validator;
//import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import javax.faces.validator.*;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 *
 * @author david
 */
@FacesValidator(value="DateValidator")
public class DateValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String str = (String)o;

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.setLenient(false);
        dateFormat.applyPattern("dd.MM.yyyy");

        Date date = null;

        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {

        }

        if (date == null) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
"Date must be of format dd.MM.yyyy or input is not a valid date", null);
            throw new ValidatorException(msg);
        }


    }
    
}
