FROM openjdk:8
EXPOSE 8094
ADD target/MedicareApp-PaymentService-0.0.1-SNAPSHOT.war MedicareApp-PaymentService-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/MedicareApp-PaymentService-0.0.1-SNAPSHOT.war" ]