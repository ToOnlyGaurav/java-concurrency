package org.jcip.examples;

import org.jcip.annotations.ThreadSafe;


@ThreadSafe
public class ResourceFactory {
    public static Resource getResource() {
        return ResourceFactory.ResourceHolder.resource;
    }

    private static class ResourceHolder {
        public static Resource resource = new Resource();
    }

    static class Resource {
    }
}
