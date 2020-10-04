FROM oracle/graalvm-ce:20.2.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/micronaut-graal-web
WORKDIR /home/app/micronaut-graal-web
RUN ./gradlew build

RUN native-image -J-Xmx4096m  -cp build/libs/micronaut-graal-web-*-all.jar

FROM debian
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-graal-web/micronaut-graal-web /app/micronaut-graal-web
ENTRYPOINT ["/app/micronaut-graal-web"]
