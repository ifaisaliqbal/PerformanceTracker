/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author iqbal
 */
//@Constraint(validatedBy = UniqueEmailValidator.class)
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface UniqueEmail {
//    public String message() default "There is already a user with this email";
//    public Class<?>[] groups() default {};
//
//    public Class<? extends Payload>[] payload() default{};
}
