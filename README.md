## CloneMe

### Build:
```
docker build -t clone-me .
```

### Run:
```
docker run \
	-p 8080:8080 \
	-p 8443:8443 \
	-e JAVA_OPTS="-Ddatarouter.server.name=localhost -Ddatarouter.server.type=dev -Ddatarouter.internalConfigDirectory=dev-docker -Ddatarouter.server.privateIp=127.0.0.1 -Ddatarouter.server.publicIp=127.0.0.1" \
	clone-me
```

### View:
- http://localhost:8080/clone-me