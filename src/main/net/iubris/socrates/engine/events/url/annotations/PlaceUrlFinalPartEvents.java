package net.iubris.socrates.engine.events.url.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

@BindingAnnotation
@Target(value={ElementType.FIELD, ElementType.PARAMETER})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface PlaceUrlFinalPartEvents {}
