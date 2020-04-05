## clone-me

A template to be cloned into an application.

### Prerequisites

#### Install "rename":

```
sudo apt-get install rename
```

#### Run MySQL

Code defaults to port 3307, password "changeit"
```
docker run -p 3307:3306 --name mysql -e MYSQL_ROOT_PASSWORD=changeit -d mysql:5.7
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
