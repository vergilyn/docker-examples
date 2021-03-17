# dockerfile-reference

docs:
+ <https://docs.docker.com/engine/reference/builder/>

dockerfiles:
- [github, jessfraz/dockerfiles](https://github.com/jessfraz/dockerfiles)
- [github, mritd/dockerfile](https://github.com/mritd/dockerfile)

```cmd
$cmd> docker build -t tag:version .
$cmd> docker run -p host-port:container-port --name container-name --rm image
```

## EXPOSE
- <https://docs.docker.com/engine/reference/builder/#expose>

> The `EXPOSE` instruction **does not actually publish the port.**  
> It functions as a type of documentation between the person
> who builds the image and the person who runs the container, about which ports are intended to be published.  
> To actually publish the port when running the container,
> use the `-p` flag on `docker run` to publish and map one or more ports,
> or the `-P` flag to publish all exposed ports and map them to high-order ports.
