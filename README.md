# Chat System

## About the project

Chat System is a decentralized communication software created as part of the 4 IR program at INSA Toulouse.
It enables users to communicate with each other on the same network. It is developed in Java and is designed to be deployed on a closed corporate network: no Internet connection is required.

## Features

- [x] Discover the network to get connected users.
- [x] Connection to the system
- [x] Change username
- [x] Disconnection
- [ ] Messaging
- [ ] History of messages
- [ ] Extra

## How to use the program

You will need Maven and Java (version >=17).

### Install Maven on Linux machines

```shell
mkdir -p ~/bin
cd ~/bin
wget https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz -O maven.tar.gz
tar xf maven.tar.gz
echo 'export PATH=~/bin/apache-maven-3.9.5/bin:$PATH' >> ~/.bashrc
source ~/.bashrc
```

### Clone the repository

Clone the repository to get the source code:
```shell
git clone https://github.com/insa-4ir-chatsystem/chatsystem-bonnet-cazeneuve.git
```

You can also download, the ZIP file and unzip it.

### Compilation
To **compile** it, you will use Maven, run the following command:
```bash
mvn clean package
```
### Run the program

Two versions of the program are implemented:
* Command Line Interface (no-gui), for testing purposes
* Graphical User Interface (default)

To **run no-gui**, execute the following command:
```bash
java -jar target/chatsystem-bonnet-cazeneuve-1.0-SNAPSHOT-jar-with-dependencies.jar no-gui
```

To **run default version** of it, execute the following command:
```bash
java -jar target/chatsystem-bonnet-cazeneuve-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Carbonara recipe
For one lonely person:
- 2 eggs
- 50g parmesan cheese
- freshly grounded black pepper
- rigatoni (~110 g)
- 2 slices of guanciale
  
Fry the guanciale cut into dices in a pan. Keep the fat in the pan and put the pan aside.
Put the water to a boil. In the meantime mix the two egg yolks, the black pepper and the parmesan cheese in a bowl.
Add the pasta into the salted water, stir. After a couple minute, take some pasta water out of the pot and mix it in the egg and cheese mixture.
When the pasta is done (but not overcooked!), add it to the greasy pan and fry it for a minute. Cut power off, light up a candle and add the egg mix to the pasta.
Serve immediately.

## Authors
- [Ronan Bonnet](https://github.com/BloodFutur)
- [Anna Cazeneuve](https://github.com/annzzza)