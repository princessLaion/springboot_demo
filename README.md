


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
