package com.example.springbootdesign.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class ServerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());
        Server.Type type = (Server.Type) annotationAttributes.get("type");
        String[] strings = null;
        if (type.equals(Server.Type.FTP)) {
            strings = new String[]{new FtpServer().getClass().getName()};
        }
        if (type.equals(Server.Type.HTTP)) {
            strings = new String[]{new HttpServer().getClass().getName()};
        }

        return strings;
    }
}
