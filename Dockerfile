FROM maven:3.9.9-jdk-21-alpine  AS builder

ARG NEXUS_USERNAME
ARG NEXUS_PASSWORD
ARG NEXUS_URL
ENV MODULE_NAME=${MODULE_NAME}
ENV NEXUS_USERNAME=$NEXUS_USERNAME \
    NEXUS_PASSWORD=$NEXUS_PASSWORD \
    NEXUS_URL=$NEXUS_URL

WORKDIR /code
COPY . /code

RUN mvn clean package

FROM primetoninc/jdk:21
LABEL vendor="Ayla IoT" \
    maintainer="admin@aylanetworks.com"

RUN mkdir -p /ayla/userservice-v2 \
    && useradd -U app

USER root:root
WORKDIR /ayla/userservice-v2

COPY --from=builder /code/target/userservice-v2-*.jar current.jar
COPY --from=builder /code/run.sh run.sh

EXPOSE 8080

ENTRYPOINT ["/bin/bash"]
CMD ["./run.sh"]
