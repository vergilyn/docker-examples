# docker-examples

- [vergilyn/docker-qq-doc](https://docs.qq.com/doc/DUkx4T0tqR216dEph)

github-examples:
- [Docker-Compose with SpringBoot, MySQL, NGINX](https://github.com/hellokoding/dockercompose-springboot-mysql-nginx)
- [dockerfile&docker-compose microservices](https://github.com/ewolff/microservice)


| image  | tags               | size      |
|:-------|:-------------------|:----------|
| centos | centos:centos7     | 203.94 MB |
| tomcat | tomcat:8.5.63-jdk8 | 537.85 MB |

## Q&A
1. 从host传输文件到container
```
# 1. 获取 container-id
$cmd> docker ps
CONTAINER ID   IMAGE            COMMAND       CREATED        STATUS       PORTS     NAMES
591ae5c3e367   centos:centos7   "/bin/bash"   3 months ago   Up 2 hours             docker-centos

# 2. copy
$cmd> docker cp --help
Usage:  docker cp [OPTIONS] CONTAINER:SRC_PATH DEST_PATH|-
        docker cp [OPTIONS] SRC_PATH|- CONTAINER:DEST_PATH

Copy files/folders between a container and the local filesystem
```
