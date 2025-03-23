package com.brightkut.custom_annotation.annotation;

import java.lang.annotation.*;


@Target(ElementType.METHOD) // where to apply this annotation
// RetentionPolicy.RUNTIME = use when runtime (start app)
// RetentionPolicy.Source = use before compile code (before we start app) e.g @SuppressWarnings()
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrintHello {
    int times() default 3; // normally it is a field in class, but we need to declare as function
}
