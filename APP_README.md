## clone-me

### Run with Docker

```
cd /tmp/clone-me

docker stop clone-me && docker rm clone-me

docker build -t clone-me .

email=<YOUR_EMAIL>

docker run \
    -d \
    --name clone-me \
    -p 8080:8080 \
    -e JAVA_OPTS="-Ddatarouter.server.name=localhost -Ddatarouter.server.type=dev -Ddatarouter.internalConfigDirectory=dev-docker -Ddatarouter.server.privateIp=127.0.0.1 -Ddatarouter.server.publicIp=127.0.0.1 -Ddatarouter.administrator.email=$email -Ddatarouter.environment=clone-me -Ddatarouter.environmentType=development"" \
    clone-me

# linux
xdg-open http://localhost:8080/clone-me

# mac
open http://localhost:8080/clone-me
#
```
