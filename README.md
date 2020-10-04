## Feature http-client documentation

- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

Sample micronaut web application using an http client.

# Running locally:

`./gradlew run`

The app uses a http client, `GeoClient` to fetch a user's geo location based on the IP, if running locally, make sure you
use a `X-Forwarded-For` header with a valid public IP or it will result in error. For instance:

`curl -H "X-Forwarded-For:173.20.20.1"  localhost:8080/sample`


# Building it

`gcloud builds submit --machine-type=n1-highcpu-8 --tag gcr.io/[PROJECT_ID]/[IMAGE_NAME]`

# Run it

Deploy it to cloud run and invoke the `/sample` endpoint with a `GET`


