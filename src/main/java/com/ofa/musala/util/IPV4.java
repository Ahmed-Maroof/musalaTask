package com.ofa.musala.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IPV4Validator.class)
@Documented
public @interface IPV4 {

    String message() default "IP is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}