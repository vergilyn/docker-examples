# compose-helloworld

+ [Compose Specification](https://github.com/compose-spec/compose-spec/blob/master/spec.md)
+ [Get started with Docker Compose](https://docs.docker.com/compose/gettingstarted/)

> 重点关注一下：  
> Step 5: Edit the Compose file to add a bind mount  
> Step 6: Re-build and run the app with Compose  
> Step 7: Update the application  
> &nbsp;&nbsp;Because the application code is now mounted into the container using a volume,
>   you can make changes to its code and see the changes instantly,
>   **without having to rebuild the image.**

## command
```
# up  Create and start containers
> docker-compose up

# -f, --file FILE  Specify an alternate compose file
# (default: docker-compose.yml)
> docker-compose -f docker-compose-bind-mount.yml up
```