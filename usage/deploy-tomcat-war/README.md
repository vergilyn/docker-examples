# deploy-tomcat-war

- [如何编写最佳的Dockerfile](https://mp.weixin.qq.com/s/x-M5iKvvuseIQwUdVmxSPQ)

> 目标：  
> 更快的构建速度  
> 更小的 Docker 镜像大小，更少的 Docker 镜像层  
> 充分利用镜像缓存（某一层的镜像缓存失效之后，它之后的镜像层缓存都会失效，所以**需要合理书写命令的顺序**）  
> 增加 Dockerfile 可读性  
> 让 Docker 容器使用起来更简单

> 总结：
> 编写. dockerignore 文件  
> 容器只运行单个应用  
> **将多个 RUN 指令合并为一个**  
> 基础镜像的标签不要用 latest  
> **每个 RUN 指令后删除多余文件**  
> 选择合适的基础镜像 (alpine 版本最好)  
> 设置 WORKDIR 和 CMD  
> 使用 ENTRYPOINT (可选)  
> 在 entrypoint 脚本中使用 exec  
> COPY 与 ADD 优先使用前者  
> **合理调整 COPY 与 RUN 的顺序（使其充分利用镜像缓存）**  
> 设置默认的环境变量，映射端口和数据卷  
> 使用 LABEL 设置镜像元数据  
> 添加 HEALTHCHECK


```DOCKERFILE
FROM tomcat:8.5.63-jdk8

# ADD 无法识别并自动解压 war文件
COPY examples.war webapps/

## unzip -[n|o|q]
# -n 解压缩时不要覆盖原有的文件。
RUN unzip -n webapps/examples.war -d webapps/examples/ \
    && rm webapps/examples.war

EXPOSE 8080
ENV APPLICATION_NAME deploy-tomcat-war-dockerfile
CMD ["catalina.sh", "run"]
```
通过观察`image deploy-tomcat-war` inspect 可知：

| image history              | size      |
|:---------------------------|:----------|
| IMAGE tomcat:8.5.63-jdk8   | 537.85 MB |
| COPY examples.war webapps/ | 698.18 KB |
| unzip ... && rm ...        | 1.21 MB   |
| IMAGE deploy-tomcat-war    | 539.76 MB |

image size:
  Actual: 539.76 MB ≈ 537.85 MB + 698.18 KB + 1.21 MB。  
  Expected: 539 MB ≈ 537.85 MB + 1.21 MB。

所以，即使 dockerfile 中 unzip&rm，对最终的image来说，还是会占用多余的 698.18 KB。

## Optimize：Use multi-stage builds
- <https://docs.docker.com/develop/develop-images/multistage-build/>

```
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
```

