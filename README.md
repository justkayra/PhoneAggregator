builded on Dropwizard
https://www.dropwizard.io/en/stable/

**to run**

in folder 'PhoneAggregator'

1. mvn clean install
2. mvn docker:build
3.  A) docker run -it -p 8080:8080 -p 8081:8081 phoneagg
    B) docker-compose up web 


./validate.sh localhost:8080/aggregate

