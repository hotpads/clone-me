# $1 com.example
# $2 hello-world

docker rm -f $2
mkdir ~/tmp
cd ~/tmp
rm -rf clone-me
rm -rf $2

git clone git@github.com:hotpads/clone-me.git
cp -R clone-me $2
cd $2
rm -rf .git

#directories
packageDirectory=$(echo $1 | sed "s/\./\//g")

cd ~/tmp/$2/src/main/java
mkdir -p $packageDirectory
cp -R orgpackage/* $packageDirectory
rm -rf orgpackage

cd ~/tmp/$2/src/test/java
mkdir -p $packageDirectory
cp -R orgpackage/* $packageDirectory
rm -rf orgpackage

cd ~/tmp/$2

echo 'moving'
find . | sed -e "p;s/cloneme/helloworld/g" | xargs -n2 mv
find . | sed -e "p;s/clone-me/$2/g" | xargs -n2 mv
echo 'moved'

#files
find . | sed -e "p;s/CloneMe/HelloWorld/" | xargs -n2 mv

#code packages
find . -type f -exec sed -i'' -e "s/orgpackage/$1/g" {} +

#code
find . -type f -exec sed -i'' -e "s/clone-me/$2/g" {} +
find . -type f -exec sed -i'' -e "s/Clone-Me/Hello-World/g" {} +
find . -type f -exec sed -i'' -e "s/clone-Me/hello-World/g" {} +
find . -type f -exec sed -i'' -e "s/Clone-me/Hello-world/g" {} +
find . -type f -exec sed -i'' -e "s/cloneme/helloworld/g" {} +
find . -type f -exec sed -i'' -e "s/CloneMe/HelloWorld/g" {} +
find . -type f -exec sed -i'' -e "s/cloneMe/helloWorld/g" {} +
find . -type f -exec sed -i'' -e "s/Cloneme/Helloworld/g" {} +

git init

#from readme
docker build -t $2 .
docker run \
    -d \
    --name $2 \
    -p 8080:8080 \
    -p 8443:8443 \
    -e JAVA_OPTS="-Ddatarouter.server.name=localhost -Ddatarouter.server.type=dev -Ddatarouter.internalConfigDirectory=dev-docker -Ddatarouter.server.privateIp=127.0.0.1 -Ddatarouter.server.publicIp=127.0.0.1" \
    hello-world
xdg-open http://localhost:8080/$2
#
