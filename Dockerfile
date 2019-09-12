FROM ycr.yonyoucloud.com/base/maven-ynpm-debian:latest
MAINTAINER licza licza@yonyou.com
ADD ./ /app/
WORKDIR /app/
RUN cd sps-fe/ \
    && ynpm install \
    && npm run build \
    && cd ../sps-be \
    && /usr/local/maven/bin/mvn clean install -U -Dmaven.test.skip=true


FROM ycr.yonyoucloud.com/base/tomcat:8-jdk8-alpine
WORKDIR /app
RUN  mkdir -p /usr/local/tomcat/webapps/sps-be

COPY --from=0 /app/sps-fe/ucf-publish/sps-fe /usr/local/tomcat/webapps/sps-fe
COPY --from=0 /app/sps-be/iuap-bootstrap/target/sps-be.war /usr/local/tomcat/webapps/sps-be.war
RUN unzip /usr/local/tomcat/webapps/sps-be.war -d /usr/local/tomcat/webapps/sps-be
RUN rm -f /usr/local/tomcat/webapps/sps-be.war
WORKDIR /usr/local/tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]
