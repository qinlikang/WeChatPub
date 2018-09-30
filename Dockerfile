FROM java:8-alpine

RUN mkdir /app
COPY ./target/WeChatPub-0.0.1.jar /app

ENTRYPOINT ["/usr/bin/java"]
# We can define an environment variable to interpolate these values, as Docker does not support
# this functionality, hence we have to do it in the command.
CMD ["-jar", "/app/WeChatPub-0.0.1.jar"]

