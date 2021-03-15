FROM centos:centos7 AS copy_unzip_rm_stage
WORKDIR /tmp/
COPY examples.war .
## unzip -[n|o|q]
# -n 解压缩时不要覆盖原有的文件。
RUN yum install unzip -y \
    && unzip -n examples.war -d examples/ \
    && rm examples.war

FROM tomcat:8.5.63-jdk8
COPY --from=copy_unzip_rm_stage /tmp/examples webapps/examples/
EXPOSE 8080
ENV APPLICATION_NAME deploy-tomcat-war-dockerfile
CMD ["catalina.sh", "run"]