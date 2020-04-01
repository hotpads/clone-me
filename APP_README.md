## clone-me

### Run with Docker

```
docker build -t clone-me .
docker run \
    -d \
    --name clone-me \
    -p 8080:8080 \
    -p 8443:8443 \
    -e JAVA_OPTS="-Ddatarouter.server.name=localhost -Ddatarouter.server.type=dev -Ddatarouter.internalConfigDirectory=dev-docker -Ddatarouter.server.privateIp=127.0.0.1 -Ddatarouter.server.publicIp=127.0.0.1" \
    clone-me
xdg-open http://localhost:8080/clone-me
#
```