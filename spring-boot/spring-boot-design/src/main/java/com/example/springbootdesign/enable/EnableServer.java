package com.example.springbootdesign.enable;


import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
@Import(ServerImportSelector.class)
public @interface EnableServer {

    Server.Type type();

}
