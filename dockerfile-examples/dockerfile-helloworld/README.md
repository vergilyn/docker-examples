# dockerfile-helloworld

差不多需要下载1GB的镜像：python、Flask、redis

```
# docker build [OPTIONS] PATH | URL | -
# -t, --tag list    Name and optionally a tag in the 'name:tag' format
> docker build -t dockerfile-helloworld .

# 查看build的`dockerfile-helloworl` image 
> docker image ls
REPOSITORY              TAG      IMAGE ID       CREATED           SIZE
dockerfile-helloworld   latest   611885b05bfc   10 seconds ago    907MB

# 运行完成后，访问：http://127.0.0.1:14000/
> docker run -p 14000:80 dockerfile-helloworld:latest

```