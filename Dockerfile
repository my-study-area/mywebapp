FROM maven:3.3-jdk-8

ENV INSTALL_PATH /mywebapp
RUN mkdir -p $INSTALL_PATH
WORKDIR $INSTALL_PATH
COPY pom.xml ./
COPY . .
