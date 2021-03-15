# add-zip

+ <https://docs.docker.com/engine/reference/builder/#add>

compression format supports:
- identity: e.g. tomcat:8.5.63-jdk8 `ADD file:8f75f11b2bd2d50e5912359ae750de06a7b49506df3756c19baf4cc63d900c4f in /`
- gzip
- bzip2
- xz

## Q&A
1. `ADD` 自动解压后是否会删除？
```DOCKERFILE
FROM centos:centos7
WORKDIR /tmp/

# copy, not-compress
ADD compress-file/dockerfile-add-gzip.gz .

# copy, de-compress, delete-source-file
ADD compress-file/dockerfile-add-tar.tar.gz .

# copy, not-compress
ADD compress-file/dockerfile-add-zip.zip .

CMD ["/bin/bash"]
```

最终文件`/tmp`:
- dockerfile-add-**gzip.gz**
- dockerfile-add-**tar.txt**
- dockerfile-add-**zip.zip**
