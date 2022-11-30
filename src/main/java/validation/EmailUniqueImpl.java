package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.mycapstone.springboot.database.dao.UsersDAO;
import com.project.mycapstone.springboot.database.entity.Users;


public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);

    @Autowired
    private UsersDAO usersDao;

    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( StringUtils.isEmpty(value) ) {
            return true;
        }

        Users users = usersDao.findByEmail(value);

        return ( users == null );
    }

}
