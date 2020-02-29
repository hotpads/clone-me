## CloneMe

### Checkstyle
The parent pom will require these checks pass:

https://github.com/hotpads/datarouter/blob/master/datarouter-checkstyle/src/main/resources/datarouter-checkstyle.xml

### Build:
```
cd ~/<project root>
docker build . -t clone-me
```

### Run:

#### dev-docker

```
docker run \
	-p 8080:8080 \
	-p 8443:8443 \
	-e JAVA_OPTS="-Ddatarouter.server.name=localhost -Ddatarouter.server.type=dev -Ddatarouter.internalConfigDirectory=dev-docker -Ddatarouter.server.privateIp=127.0.0.1 -Ddatarouter.server.publicIp=127.0.0.1" \
	clone-me
```
