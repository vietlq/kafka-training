Published on 14 Apr 2015
Docker tutorial for beginners - part 1:
Free Digital Ocean Credit! http://webdev.willstern.com/digitalocean
Docker is amazing, and it doesn't have to be difficult to understand. In these tutorials, I'll be breaking down exactly what a Docker container is and how to use it. I've found a lot of Docker container tutorials on the web, but I still hear from developers that it's hard to grasp exactly what Docker is and how to work with Docker images & containers.

In this video, I'll compare Docker to Vagrant and explain the differences, then in the next video, we'll do our first miniature deployment with Docker by creating a Digital Ocean machine with Docker installed and then running a Docker web server container on the machine. Later on, we'll get into docker machine, docker compose (fig) and a whole mess of other fun tooling.

Next up: how to run your first Docker web server - http://youtu.be/JBtWxj9l7zM

High-Availability Docker #1: https://youtu.be/wxUxtflalE4
- Cluster computing - CoreOS is our solution here. CoreOS allows us to make an expandable cluster of computers so we can add more computers should our application need more power to scale. CoreOS also allows us to run services on any machine in the cluster and they can all communicate with each other.

High-Availability Docker #2: https://youtu.be/top0MlcKSw4
- Scheduling: we shouldn't manually choose which app runs on which machine - this idea doesn't work at scale. Fleet will be our scheduler that decides where our apps/services run. If a CoreOS machine goes down, fleet will reschedule any services that it was running onto a new machine.

High-Availability Docker #3: https://youtu.be/1zJ8FfC-gmU
- Service Registration
Since we never know what ip address or port a service will be running on, we need to register that service so other services can find it and communicate with it. We'll use Etcd and Flannel for this

High-Availability Docker #4: https://youtu.be/R39VRocQtrQ
- Service Discovery:
Now that services have registered, we can discover them and load balance between them with a generic docker nginx container

High-Availability Docker #5: https://youtu.be/4215szNHlC4
- Public DNS: Once the app is working, we need a fixed way for the outside world to access it. We'll use Nginx and Confd for this. Confd will watch Etcd for service registration and when services come/go, it will build a new configuration file for Nginx and reload Nginx.
