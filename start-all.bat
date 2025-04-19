@echo off
REM -- Build the entire project
echo Building the project...
call mvn clean install

REM -- Launch all services in separate terminals
echo Starting microservices...

start cmd /k "cd products && mvn spring-boot:run"
start cmd /k "cd orders && mvn spring-boot:run"
start cmd /k "cd customer && mvn spring-boot:run"
start cmd /k "cd serviceDiscovery && mvn spring-boot:run"
start cmd /k "cd adminServer && mvn spring-boot:run"
start cmd /k "cd confServer && mvn spring-boot:run"

echo All services launched!
