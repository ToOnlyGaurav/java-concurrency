package org.jcip.examples;

import org.jcip.annotations.ThreadSafe;


@ThreadSafe
public class EagerInitialization {
    private static final Resource resource = new Resource();

    public static Resource getResource() {
        return resource;
    }

    static class Resource {
    }
}
