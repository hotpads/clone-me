## clone-me

A template to be cloned into an application.

### Prerequisites

install "rename":

```
sudo apt-get install rename
```

### Download the template

```
cd /tmp
rm -rf clone-me
rm clone
git clone git@github.com:hotpads/clone-me.git
cp clone-me/clone .
```

### Create your app

Run "clone" with your package and app-name:

```
clone com.example hello-world
```
