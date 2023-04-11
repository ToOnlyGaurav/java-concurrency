# java-concurrency
Java Concurrency example

This has few examples where we make common mistakes and how to fix. 
## Order of Files
Ensure visibility when accessing shared primitive variables
- ControlledStop:

Ensure that compound operations on shared variables are atomic
- Flag

Ensure visibility of shared references to immutable objects
- Foo 

Use thread pools to enable graceful degradation of service during traffic bursts
- RequestHandler

#java -cp target/java-concurrency-1.0-SNAPSHOT.jar org.guidelines.examples.faulty.ControlledStop
#java -cp target/java-concurrency-1.0-SNAPSHOT.jar org.jcip.examples.PossibleReordering
 java -XshowSettings
  java -cp target/java-concurrency-1.0-SNAPSHOT.jar org.guidelines.examples.faulty.ControlledStop

java -cp target/java-concurrency-1.0-SNAPSHOT-jar-with-dependencies.jar org.guidelines.examples.Log


