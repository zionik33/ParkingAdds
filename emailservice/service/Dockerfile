
FROM    java:8

MAINTAINER  Bo Stokholm <info@stokholmsolutions.dk>

ENV MAVEN_HOME /usr/lib/apache/maven/3.3.9
ENV PATH /usr/lib/apache/maven/3.3.9/bin:$PATH

RUN export DEBIAN_FRONTEND=noninteractive && \
  apt-get update

RUN \
  mkdir -p $MAVEN_HOME && \
  cd $MAVEN_HOME && \
  wget http://mirrors.rackhosting.com/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz && \
  tar -zxvf apache-maven-3.3.9-bin.tar.gz && \
  mv apache-maven-3.3.9/* . && \
  rm -rf apache-maven-3.3.9

RUN ["mvn", "tomcat7:deploy"]
