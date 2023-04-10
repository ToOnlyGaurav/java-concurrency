package org.jcip.examples;

import org.jcip.annotations.GuardedBy;
import org.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;


@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    interface Person {
    }
}
