import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

@RestController
public class SpringAsmDemo {
    public static void main(String[] args) throws IOException {
        String className = SpringAsmDemo.class.getName();

        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();

        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);

        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        annotationMetadata.getAnnotationTypes().stream().forEach(annotationType -> {
            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);
            metaAnnotationTypes.stream().forEach(metaAnnotationType -> {
                System.out.println("==="+metaAnnotationType);
            });
        });
    }
}
