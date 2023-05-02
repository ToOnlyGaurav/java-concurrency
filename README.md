# java-concurrency

Java Concurrency example

This has few examples where we make common mistakes and how to fix.

## Order of Files

### Visibility and Atomicity

> Ensure visibility when accessing shared primitive variables

- ControlledStop
- AbstractControlledStop

> Ensure that compound operations on shared variables are atomic

- Flag
- Flag1

> Ensure visibility of shared references to immutable objects

The problem is that, while the shared object is immutable,
the reference used to access the shared object is itself shared and often mutable.
Consequently, a correctly synchronized program must synchronize access to that shared reference,
but often programs do not do this, because programmers do not recognize the need to do it.
- Foo (Helper)

> Do not assume that a group of calls to independently atomic methods is atomic

A thread-safe class can only guarantee atomicity of its individual methods. 
A grouping of calls to such methods requires additional syn- chronization.

- Adder
- IPHolder
- KeyedCounter

### Locking

> Do not synchronize on objects that may be reused
- 

> Use thread pools to enable graceful degradation of service during traffic bursts

- RequestHandler

### Thread APIs

> Do not assume that the sleep(), yield(), or getState() methods provide synchronization semantics
> 
> Do not invoke ThreadGroup methods

> Do not invoke Thread.run()

- Foo

> Always invoke wait() and await() methods inside a loop

> Notify all waiting threads instead of a single thread

- ProcessStep
- ConditionalStep

> Do not use Thread.stop() to terminate threads

> Ensure that threads and tasks performing blocking operations can be terminated

### Thread Pools
> Use thread pools to enable graceful degradation of service during traffic bursts

> Do not execute interdependent tasks in a bounded thread pool

> Ensure that tasks submitted to a thread pool are interruptible
> 

> Ensure ThreadLocal variables are reinitialized when using thread pools

### Thread safety (Rest)

> Do not override thread-safe methods with methods that are not thread-safe

> Do not let the “this” reference escape during object construction

> Do not use background threads during class initializa

#java -cp target/java-concurrency-1.0-SNAPSHOT.jar org.guidelines.examples.vna.faulty.ControlledStop
#java -cp target/java-concurrency-1.0-SNAPSHOT.jar org.jcip.examples.PossibleReordering
java -XshowSettings
java -cp target/java-concurrency-1.0-SNAPSHOT.jar org.guidelines.examples.vna.faulty.ControlledStop

java -cp target/java-concurrency-1.0-SNAPSHOT-jar-with-dependencies.jar org.guidelines.examples.Log

