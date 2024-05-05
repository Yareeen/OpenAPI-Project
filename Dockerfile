# Dockerfile for Book OpenAPI project
FROM openjdk:20-jdk

# Meta Bilgiler
LABEL author="Yaren"
MAINTAINER Yaren

# Çalışma dizini /app olarak ayarlanıyor
WORKDIR /app

# Uygulamanın executable JAR dosyası container'a kopyalanıyor
COPY target/OpenApiProject-0.0.1-SNAPSHOT.jar /app/OpenApiProject.jar

# Uygulamanın çalışacağı port
EXPOSE 8080

# Container başlatıldığında uygulamayı çalıştır
CMD ["java", "-jar", "OpenApiProject.jar"]

