


## Libraries
### Lombok - helps reduce boilerplate code. 
For Intellij, install lombok thru File > Settings > Plugin. Search Lombok and click install


## Tools
Json Formatter Chrome Extension - https://chromewebstore.google.com/detail/json-formatter/bcjindcccaagfpapjjmafapmmgkkhgoa?pli=1
Devtools - Easier development as no need to restart server.
For intellij, 
    Go to Settings -> Build, Execution, Deployment > Compiler. Enable the Build the project automatically.
    Go to Project Settings > Advanced Settings and select 'Allow auto-make to start even if developed application is currently running'
    Install LiveReload from Chrome extension
    Then restart 

## To access
http://localhost:8080/coursesv1 - The standard Controller. Need to specify ResponseBody annotation
http://localhost:8080/coursesv2 - Using RestController. Includes the Controller and ResponseBody annotation.


## Generic Exception Handling generated response based from ErrorDetail
Status: 404
{
"localDateTime": "2024-08-13T23:04:54.3524296",
"message": "id: 23",
"description": "uri=/users/23"
}

## Validation Error Message Response Sample
{
     "localDateTime": "2024-08-14T01:11:31.5306997",
     "message": "Name is required., Birth date is required.",
     "description": "uri=/users"
}

## API documentation
http://localhost:8080/swagger-ui/index.html

## Specify Response format (XML / JSON) by adding Accept Header
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>

## Versioning
Can be URL, Request Parameter, Header or Media Type

Sample:
V1:
{
    "name": "John Smith"
}

V2:
{
    "name": {
        "firstName": "John",
        "lastName": "Smith"
    }
}


Reference:
https://github.com/in28minutes/spring-microservices-v2/blob/main/02.restful-web-services/01-step-by-step-changes/v2.md#step-12
