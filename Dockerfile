FROM openjdk:17

COPY build/libs/programVariant3-1.jar app.jar

RUN mkdir "interface"
ENV BASE_RATING 1500
VOLUME interface /interface

CMD ["java", "-jar", "app.jar"]