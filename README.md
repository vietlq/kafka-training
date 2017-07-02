
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
docker run --rm -it \
           -p 2181:2181 -p 3030:3030 -p 8081:8081 \
           -p 8082:8082 -p 8083:8083 -p 9092:9092 \
           -e ADV_HOST=127.0.0.1 \
           landoop/fast-data-dev
```

```
$ docker run --rm -it --net=host landoop/fast-data-dev bash
```

Create a topic

```
root@fast-data-dev / $ kafka-topics --zookeeper 127.0.0.1:2181 --create --topic dummy --partitions 3 --replication-factor 3
Error while executing topic command : replication factor: 3 larger than available brokers: 1
[2017-07-02 10:10:04,666] ERROR org.apache.kafka.common.errors.InvalidReplicationFactorException: replication factor: 3 larger than available brokers: 1
 (kafka.admin.TopicCommand$)

root@fast-data-dev / $ kafka-topics --zookeeper 127.0.0.1:2181 --create --topic dummy --partitions 3 --replication-factor 2
Error while executing topic command : replication factor: 2 larger than available brokers: 1
[2017-07-02 10:10:12,199] ERROR org.apache.kafka.common.errors.InvalidReplicationFactorException: replication factor: 2 larger than available brokers: 1
 (kafka.admin.TopicCommand$)

root@fast-data-dev / $ kafka-topics --zookeeper 127.0.0.1:2181 --create --topic dummy --partitions 3 --replication-factor 1
Created topic "dummy".
```

```
root@fast-data-dev / $ kafka-topics --zookeeper 127.0.0.1:2181 --create --topic dummy_two --partitions 3 --replication-factor 1
WARNING: Due to limitations in metric names, topics with a period ('.') or underscore ('_') could collide. To avoid issues it is best to use either, but not both.
Created topic "dummy_two".

root@fast-data-dev / $ kafka-topics --zookeeper 127.0.0.1:2181 --delete --topic dummy_two
Topic dummy_two is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
```

```
root@fast-data-dev / $ kafka-topics --zookeeper 127.0.0.1:2181 --describe --topic dummy
Topic:dummy    PartitionCount:3    ReplicationFactor:1    Configs:
    Topic: dummy    Partition: 0    Leader: 0    Replicas: 0    Isr: 0
    Topic: dummy    Partition: 1    Leader: 0    Replicas: 0    Isr: 0
    Topic: dummy    Partition: 2    Leader: 0    Replicas: 0    Isr: 0
```

```
kafka-console-producer --broker-list 127.0.0.1:9092 --topic dummy
```

```
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic dummy --from-beginning
```

Use `group.id`:

```
kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic dummy --consumer-property group.id=group1 --from-beginning
```

https://kafka.apache.org/documentation/#producerconfigs

https://github.com/apache/kafka/tree/trunk/examples

https://www.youtube.com/watch?v=sl2mfyjnkXk&feature=youtu.be

https://www.youtube.com/watch?v=pGYAg7TMmp0

https://www.youtube.com/watch?v=JBtWxj9l7zM

https://www.youtube.com/watch?v=_I94-tJlovg

https://www.youtube.com/watch?v=_f-qkGJBPts

https://www.youtube.com/watch?v=upGiAG7-Sa4

https://www.youtube.com/watch?v=ddhU3NMrhX4

https://www.draw.io/

https://www.youtube.com/watch?annotation_id=annotation_42917443&feature=iv&index=3&list=PLoYCgNOIyGAAzevEST2qm2Xbe3aeLFvLc&src_vid=JBtWxj9l7zM&v=K6WER0oI-qs

https://www.youtube.com/watch?v=YiZkHUbE6N0

https://www.youtube.com/watch?v=zzAdEt3xZ1M

https://www.youtube.com/watch?v=4sBF5Dg8dQ4&index=5&list=PLoYCgNOIyGAAzevEST2qm2Xbe3aeLFvLc

https://www.youtube.com/watch?v=7ZFBn_e27o0
