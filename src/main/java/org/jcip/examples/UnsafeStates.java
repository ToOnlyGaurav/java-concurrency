package org.jcip.examples;


class UnsafeStates {
    private final String[] states = new String[]{
            "AK", "AL" /*...*/
    };

    public String[] getStates() {
        return states;
    }
}
