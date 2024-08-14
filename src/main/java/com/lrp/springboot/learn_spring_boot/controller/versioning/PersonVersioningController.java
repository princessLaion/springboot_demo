package com.lrp.springboot.learn_spring_boot.controller.versioning;

import com.lrp.springboot.learn_spring_boot.model.PersonName;
import com.lrp.springboot.learn_spring_boot.model.PersonV1;
import com.lrp.springboot.learn_spring_boot.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 Versioning REST API Factors to consider:
 - URI Pollution
        -> need to keep the versioning in mind when starting application
        -> we are having different urls because we are exposing the version number, unlike if we use header, its consisten URL.
 - Misuse of HTTP Headers
        -> Headers are not to be used for versioning
 - Caching
        -> when caching, the url is the only factor and it will ignore the headers.
 - Can we execute the request on the browser
        -> This cannot be done when using headers as versioning.
 - API Documentation
        -> Might not show versioning if we chose header specific

 ** Approach used should be consistent to the enterprise. Make it standard
 */
@RestController
public class PersonVersioningController {
    /**
     URI Versioning - Twitter
     http://localhost:8080/v1/person
     http://localhost:8080/v2/person
     */

    @GetMapping(path = "/person/v1")
    public PersonV1 urlVersionV1() {
        return new PersonV1("URL Version");
    }

    @GetMapping(path = "/person/v2")
    public PersonV2 urlVersionV2() {
        PersonName name = new PersonName("URL", "Version");
        return new PersonV2(name);
    }

    /**
     Request Parameter Versioning - Amazon
     http://localhost:8080/person?version=1
     http://localhost:8080/person?version=2
     */
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 requestParamVersionV1() {
        return new PersonV1("Request Param");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 requestParamVersionV2() {
        PersonName name = new PersonName("Request", "Param");
        return new PersonV2(name);
    }

    /**
     Custom Headers Versioning - Microsoft
     http://localhost:8080/person, Header [X-API-VERSION=1]
     http://localhost:8080/person, Header [X-API-VERSION=2]
     */
    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 customHeaderVersionV1() {
        return new PersonV1("Custom Header");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 customHeaderVersionV2() {
        PersonName name = new PersonName("Custom", "Header");
        return new PersonV2(name);
    }

    /**
     MEDIA TYPE Versioning (a.k.a "content negotiation or accept header") - Github
     http://localhost:8080/person, Header [Accept=application/vnd.company.appv1+json]
     http://localhost:8080/person, Header [Accept=application/vnd.company.appv2+json]
     */

    @GetMapping(path = "/person", produces = "application/vnd.company.appv1+json")
    public PersonV1 mediaTypeVersionV1() {
        return new PersonV1("Media Type");
    }

    @GetMapping(path = "/person", produces = "application/vnd.company.appv2+json")
    public PersonV2 mediaTypeVersionV2() {
        PersonName name = new PersonName("Media", "Type");
        return new PersonV2(name);
    }

}
