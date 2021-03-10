package com.peijia.common.validator.constraintvalidators;

import com.peijia.common.entity.RegexpConstant;
import com.peijia.common.util.EdenUtil;
import com.peijia.common.validator.constraints.Mobile;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang.StringUtils;

/**
 * @author Peijia
 * @className MobileValidator
 * @desc
 * @create 2021/3/10 10:31
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    @Override
    public void initialize(Mobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return EdenUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
