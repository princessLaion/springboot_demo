


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


## HATEOAS
Hypermedia as the Engine of Application State

Its about making API responses more informative and interactive by including links 
that guide the user to the next possible action.

Concept in Rest APIs that makes API more flexible and easier to use.

Imagine you're using app to browse movies. When looking at movie's details, 
the app will shows the movie information (e.g title, director, year, plot . . .), 
but also other links like 'View Reviews', 'See Similar Movies'.

Hateoas are like those buttons or links but in API response.

WITHOUT HATEOAS: 
    If you want to see related information like movie reviews or similar movie, 
you have to know the specific URL or ask someone

WITH HATEOAS:
    API response would include links to related actions. 
Example, if you get details about the movie, the API will also give you link to view reviews or see similar movie. 
Its like the API guiding you on what you can do next, without having to guess or know the specific URLs.

Output:
{
    "id": 1,
    "name": "Piolo Milby",
    "birthDate": "2014-08-14",
    "_links": {
        "all-users": {
        "href": "http://localhost:8080/users"
        }
    }
}

Reference:
https://github.com/in28minutes/spring-microservices-v2/blob/main/02.restful-web-services/01-step-by-step-changes/v2.md#step-12
