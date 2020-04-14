FROM openjdk:8
EXPOSE 9090
ADD target/DemoJenkins.jar DemoJenkins.jar
ENTRYPOINT ["java","-jar","/DemoJenkins.jar"]