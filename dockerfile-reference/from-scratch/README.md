# from-scratch
- [base image](https://docs.docker.com/develop/develop-images/baseimages/)

**scratch**:  
"You can use Docker’s reserved, **minimal image**, `scratch`, as a starting point for building containers."

> Note:  
> Because Docker Desktop for Mac and **Docker Desktop for Windows** use a Linux VM,
> you need a Linux binary, rather than a Mac or Windows binary. You can use a Docker container to build it:
> `cmd> docker run --rm -it -v $PWD:/build ubuntu:16.04`

