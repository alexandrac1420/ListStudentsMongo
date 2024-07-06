# NamesNetworkClientService Project

This repository contains a series of practical exercises to learn about socket programming in Java, covering basic connections to more complex client-server applications.


## Included Exercises

1. **Exercise_1**: Exercise to print details of a URL using Java's `URL` class.
2. **Exercise_2**: Application to download the content of a URL and save it to a local file.
3. **Exercise_3**: Basic implementation of a client and server communicating over TCP sockets.
4. **Exercise_4**: Extension of Exercise_3 where the client sends a number to the server and receives its cosine.
5. **Exercise_5**: Basic HTTP server responding with a simple HTML page and an image for GET requests.
6. **Exercise_6**: Enhanced version of Exercise_5 serving static files (HTML, images) from a local directory.
7. **Exercise_7**: Implementation of a UDP client and server to fetch and send server time.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You need to install the following tools and configure their dependencies:

1. **Java** (versions 7 or 8)
    ```sh
    java -version
    ```
    Should return something like:
    ```sh
    java version "1.8.0"
    Java(TM) SE Runtime Environment (build 1.8.0-b132)
    Java HotSpot(TM) 64-Bit Server VM (build 25.0-b70, mixed mode)
    ```

2. **Maven**
    - Download Maven from [here](http://maven.apache.org/download.html)
    - Follow the installation instructions [here](http://maven.apache.org/download.html#Installation)

    Verify the installation:
    ```sh
    mvn -version
    ```
    Should return something like:
    ```sh
    Apache Maven 3.2.5 (12a6b3acb947671f09b81f49094c53f426d8cea1; 2014-12-14T12:29:23-05:00)
    Maven home: /Users/dnielben/Applications/apache-maven-3.2.5
    Java version: 1.8.0, vendor: Oracle Corporation
    Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/jre
    Default locale: es_ES, platform encoding: UTF-8
    OS name: "mac os x", version: "10.10.1", arch: "x86_64", family: "mac"
    ```

3. **Git**
    - Install Git by following the instructions [here](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

    Verify the installation:
    ```sh
    git --version
    ```
    Should return something like:
    ```sh
    git version 2.2.1
    ```

### Installing

1. Clone the repository and navigate into the project directory:
    ```sh
    git clone https://github.com/alexandrac1420/NamesNetworkClientService.git

    cd NamesNetworkClientService
    ```

2. Build the project:
    ```sh
    mvn package
    ```

    Should display output similar to:
    ```sh
    [INFO] --- jar:3.3.0:jar (default-jar) @ NamesNetworkClientService ---
    [INFO] Building jar: C:\Users\alexa\Downloads\NamesNetworkClientService\target\NamesNetworkClientService-1.0-SNAPSHOT.jar
    [INFO] BUILD SUCCESS
    ```

### Running Each Exercise

#### Exercise_1

To run Exercise_1, use the following command:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_1.Exercise_1
```

This will print details of the provided URL.
![Exercise_1](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/a31fe305-fd72-46b2-b9b3-c99fb556c7b4)



#### Exercise_2

To run Exercise_2, use the following command:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_2.Exercise_2

```

After running Exercise_2, to open the generated HTML file, use the appropriate command based on your operating system:

-  **On Windows:**
```sh
start resultado.html
```

-  **On macOS:**
```sh
open index.html
```

-  **On Linux:**
```sh
xdg-open index.html
```
![Exercise_2](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/9f55920f-b9f6-4281-aeb9-dda6918e27ac)
![Pagina](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/5f90566a-fc3e-49f7-940c-86f023c802f1)


#### Exercise_3

To run Exercise_3, first start the server:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_3.EchoServer_Exercise3
```

Then, in another terminal, run the client:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_3.EchoClient_Exercise3

```
This establishes a TCP connection where the client sends messages to the server and receives echoes back.

![Server](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/0f244e0f-82cc-4b06-bdbf-dac20250504e)
![Client](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/be5487a8-5584-4827-a44c-3bd6bd3ed7af)


#### Exercise_4

To run Exercise_4, first start the server:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_4.EchoServer_Exercise4
```
This server implements a functionality where it receives a number and performs an operation based on the client's request. By default, the server calculates the cosine of the received number. However, if the server receives a message starting with "fun:", it changes its operation to either sine, cosine, or tangent as specified in the message. For instance, sending "fun
" instructs the server to compute the sine of subsequent numbers.
Then, in another terminal, run the client:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_4.EchoClient_Exercise4
```

The client interacts with the server by sending numbers. It expects to receive the result of the corresponding trigonometric operation (defaulting to cosine unless specified otherwise with "fun:"). For example, sending the number 0 will result in the server responding with the cosine of 0, which is 1. Sending subsequent numbers or changing the function with "fun:" prefix will adjust the server's behavior accordingly.

![Server](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/f8231cc6-5efc-4fc5-be3a-3ea19eb7182c)

![Client](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/fd6217ee-5da7-4c5d-abbf-9d3ff3822cab)


#### Exercise_5

To run Exercise_5, first start the server:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_5.HttpServer_Exercise5

```
- **Accessing the Server**
  
  After starting the server, open your web browser and navigate to:
    ```arduino
    http://localhost:53000/
    ```

![Server](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/8d664656-50da-4533-b9a9-e054e9dd894e)

![HTTP](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/7d145bfa-eeb6-49f3-8088-0ace92eac956)


#### Exercise_6

To run Exercise_6, first start the server:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_6.HttpServer_Exercise6

```
- **Accessing the Server**

  After starting the server, open your web browser and navigate to the following URLs:

    1. For the index.html file:
       
       ```arduino
        http://localhost:53000/index.html
        ```
       
    2. For the PictureExercise6.jpg image file:
       
       ```arduino
        http://localhost:53000/PictureExercise6.jpg
        ```
![Server](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/5687e883-0f63-4cc9-bcb3-d9422b10f2b9)
![html](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/76a6c3ec-9e1b-467f-a96f-d9b597edc36c)
![jpg](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/f88b623d-fb1d-4d87-9edf-c283623da5d6)


#### Exercise_7

To run Exercise_7, first start the server:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_7.DatagramTimeServer_Exercise7

```

Then, in another terminal, run the client:

```sh
java -cp target/NamesNetworkClientService-1.0-SNAPSHOT.jar edu.escuelaing.arsw.Exercise_7.DatagramTimeClient_Exercise7
```

- **Server Behavior Summary**
    - Continuous Updates: The server sends current time messages to connected clients.
    - Client Interaction: Clients receive these time updates.
    - Server Restart: Upon restarting the server, time updates resume for clients.
    - Update Interval: Time messages are sent every 5 seconds.

![image](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/e491bc2d-012f-4b55-a66e-066186e3a9a4)
![image](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/88768a0b-502c-47e7-89c2-0d46abab451b)
![image](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/8ab2e2a8-e173-43bf-b66e-7ee639f20d6e)
![image](https://github.com/alexandrac1420/NamesNetworkClientService/assets/138069735/9f160577-4eb6-419f-9cf2-425414fd0056)


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Git](http://git-scm.com/) - Version Control System

## Versioning

I use [GitHub](https://github.com/) for versioning. For the versions available, see the [tags on this repository](https://github.com/alexandrac1420/NamesNetworkClientService.git).

## Authors

* **Alexandra Cortes Tovar** - [alexandrac1420](https://github.com/alexandrac1420)

## License

This project is licensed under the GNU
