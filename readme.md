# Quickstart: Java standard In/Out

This is a quickstart demonstrating how to use Java 17 fat jar to create a simple equivalent of the Linux `grep` command.

## Building

To build the project execute the following command:

```
$ mvn
```

Then our simple project can be executed as a fat jar:

```
$ printf "foo\nbar\nbaz" | java -jar target/quickstart-java-stdinout-0.0-SNAPSHOT-jar-with-dependencie
s.jar bar
bar
```

## License

This project is distributed under [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).