package org.guidelines.examples.vna.compliant;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class IPHolder {
    private final List<InetAddress> ips =
            Collections.synchronizedList(new ArrayList<InetAddress>());

    public void addAndPrintIPAddresses(InetAddress address) {
        synchronized(ips) {
            ips.add(address); // atomic
            InetAddress[] addressCopy = (InetAddress[]) ips.toArray(new InetAddress[0]); // atomic
        }
    }
}
