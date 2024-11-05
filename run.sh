#!/bin/bash

echo "java $JAVA_OPTS -jar app.jar"
java $JAVA_OPTS -jar app.jar --spring.profiles.active=env