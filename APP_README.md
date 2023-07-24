## clone-me

### Run with Docker

```
cd /tmp/clone-me

docker build -t clone-me .

docker run \
    -d \
    --name clone-me \
    --network="host" \
    -e JAVA_OPTS="-Ddatarouter.server.name=localhost -Ddatarouter.server.type=dev -Ddatarouter.internalConfigDirectory=dev-docker -Ddatarouter.server.privateIp=127.0.0.1 -Ddatarouter.server.publicIp=127.0.0.1" \
    clone-me

# linux
xdg-open http://localhost:8080/clone-me

# mac
open http://localhost:8080/clone-me
#
```
