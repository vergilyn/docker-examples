FROM centos:centos7
WORKDIR /tmp/

# copy, not-compress
ADD compress-file/dockerfile-add-gzip.gz .

# copy, de-compress, delete-source-file
ADD compress-file/dockerfile-add-tar.tar.gz .

# copy, not-compress
ADD compress-file/dockerfile-add-zip.zip .

CMD ["/bin/bash"]