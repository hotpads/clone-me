## clone-me

A template to be cloned into an application.

### Prerequisites

#### Install "rename":

```
# ubuntu
sudo apt-get install rename
# mac
brew install rename
```

#### Run MySQL

If not already running MySQL on port 3306:

```
docker run -d \
	--name mysql \
	-e MYSQL_ALLOW_EMPTY_PASSWORD=true \
	-p 3306:3306 \
	mysql:5.7
```

Apple Silicon:
```
docker run -d \
	--name mysql \
	-e MYSQL_ALLOW_EMPTY_PASSWORD=true \
	-p 3306:3306 \
	mysql/mysql-server:latest-aarch64
```

### Download the template to /tmp

```
cd /tmp && rm -rf clone-me && rm clone
git clone https://github.com/hotpads/clone-me.git
cp clone-me/clone .
```

### Create your app

Run "clone" with your package and app-name:

```
clone com.example hello-world
```
