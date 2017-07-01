
```
$ docker run -it ubuntu bash
```

```
$ docker-machine rm default
$ docker-machine create -d virtualbox --virtualbox-memory=4096 --virtualbox-cpu-count=2 default
```

```
$ docker-machine rm default
About to remove default
WARNING: This action will delete both local reference and remote instance.
Are you sure? (y/n): y
Error removing host "default": Host does not exist: "default"
```

```
$ docker-machine create -d virtualbox --virtualbox-memory=4096 --virtualbox-cpu-count=2 default
Running pre-create checks...
(default) Default Boot2Docker ISO is out-of-date, downloading the latest release...
(default) Latest release for github.com/boot2docker/boot2docker is v17.06.0-ce
(default) Downloading /Users/vietlq/.docker/machine/cache/boot2docker.iso from https://github.com/boot2docker/boot2docker/releases/download/v17.06.0-ce/boot2docker.iso...
(default) 0%....10%....20%....30%....40%....50%....60%....70%....80%....90%....100%
Creating machine...
(default) Copying /Users/vietlq/.docker/machine/cache/boot2docker.iso to /Users/vietlq/.docker/machine/machines/default/boot2docker.iso...
(default) Creating VirtualBox VM...
(default) Creating SSH key...
(default) Starting the VM...
(default) Check network to re-create if needed...
(default) Waiting for an IP...
Waiting for machine to be running, this may take a few minutes...
Detecting operating system of created instance...
Waiting for SSH to be available...
Detecting the provisioner...
Provisioning with boot2docker...
Copying certs to the local machine directory...
Copying certs to the remote machine...
Setting Docker configuration on the remote daemon...

Checking connection to Docker...
Docker is up and running!
To see how to connect your Docker Client to the Docker Engine running on this virtual machine, run: docker-machine env default
vietlq@Viets-iMac:~/projects/interview-training/cpp/tutver/_build[07:11:57]>
$ docker-machine env default
export DOCKER_TLS_VERIFY="1"
export DOCKER_HOST="tcp://192.168.99.100:2376"
export DOCKER_CERT_PATH="/Users/vietlq/.docker/machine/machines/default"
export DOCKER_MACHINE_NAME="default"
# Run this command to configure your shell:
# eval $(docker-machine env default)
```

https://github.com/Landoop/fast-data-dev

```
$ docker run --rm --net=host landoop/fast-data-dev
```

```
docker run --rm --it \
           -p 2181:2181 -p 3030:3030 -p 8081:8081 \
           -p 8082:8082 -p 8083:8083 -p 9092:9092 \
           -e ADV_HOST=127.0.0.1 \
           landoop/fast-data-dev
```
