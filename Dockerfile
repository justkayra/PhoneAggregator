FROM java:8-jre
MAINTAINER kaira
EXPOSE 8080 8081
COPY target/docker/phoneagg/build/maven /maven/
CMD java -jar \
                                        /maven/PhoneAggregator-1.0-SNAPSHOT.jar server \
                                        /maven/docker-config.yml
