
**Dockerising Spring Boot application with Database**

Download and install Docker for windows/Linux/mac from the official website [https://hub.docker.com/](https://hub.docker.com/)

 - Clone the above Demo Spring Boot Application.
 - After installation in order to check whether the Docker is running or
   not

*Take the **CMD** from the project folder (or anywhere) and type command*

***docker   –v*** (will display current Docker version) 

Then open the “**DockerFile**” from the project folder
This contains the commands for generating Docker image

    FROM openjdk:8  
    ADD target/demo-docker.jar demo-docker.jar  
    EXPOSE 8080  
    ENTRYPOINT ["java", "-jar" , "demo-docker.jar" ]

**FROM** will pull openjdk from Docker repo.

**ADD** will copy build jar form target folder to root folder of the Docker.

**EXPOSE** will expose the port 8080.

**ENTRYPOINT** will execute the command given.
(Change the target jar name if you want)

`docker build -f Dockerfile -t docker-spring-boot-user .`
From the cmd enter the command where –f <FILENAME>
-t <tag-name-for-Docker-image> and **‘.’** is the file path that is current as of now.

This will execute the commands from the docker file. Initially running may take some time as it downloads a **openjdk** from the repository.

    docker image ls

This command will give you list of images you have and you can find one with the name **docker-spring-boot-user.**

**Setup MySQL**

Now we will create and run an image of the MySQL database. From our terminal, we will run the below command. Here, -d in this command indicates that the Docker command will run in detached mode.

    docker run -d  -p  6033:3306 --name=mysql-docker --env="MYSQL_ROOT_PASSWORD=root"  --env="MYSQL_PASSWORD=root"  --env="MYSQL_DATABASE=demo" mysql

Hopefully, the MySQL image is pulled and running as a container. To check this, we can run.

You can check that using `docker container ls` command.

Now we can check by logging in to MySQL.

    docker exec -it mysql-docker bash
*(mysql-docker is the tag name we have given while creating)*
Now you have the databse created inside the docker mysql

You can import the sql by following command

    docker exec -i docker-mysql mysql -uroot -proot demo <demo.sql

**Running the Project inside the Docker**

`docker run -t --link mysql-docker:mysql -p 8080:8080 docker-spring-boot-user`

**--link** will link the MySQL container and will be exposing the port 8080

Now it will open up in

    http://localhost:8080/demo/user

POST 

    {
    "username":"anyname"
    }
