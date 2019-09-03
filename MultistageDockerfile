FROM maven:latest AS mvn-package
COPY . .
RUN mvn -Dmaven.test.skip=true package

FROM openjdk:8-jre-alpine
COPY --from=mvn-package target/miracle-0.0.1.jar /app.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone
EXPOSE 8080
ENTRYPOINT java -jar /app.jar
