package edu.stanford.protege.webprotege;

import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-06-06
 */
@SpringBootApplication
@Import({WebProtegeJacksonApplication.class})
public class WebProtegeBackendApi {

}
