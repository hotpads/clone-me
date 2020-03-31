## CloneMe

A template to be cloned into an application.

### clone.sh

To create an app named `hello-world` with parent java package `com.example`:

```
cd /tmp
rm -rf clone-me
rm clone
git clone git@github.com:hotpads/clone-me.git
cd clone-me
git checkout mattc/clone-script
cd /tmp
cp clone-me/clone .
clone com.example hello-world
```
