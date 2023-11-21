package com.designpattern.state;

class Brightness {
    private State state;

    public Brightness() {
        this.state = new LowState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressButton() {
        state.handleRequest(this);
    }

    public String toString() {
        return state.toString();
    }
}

interface State {
    void handleRequest(Brightness brightness);
}

class LowState implements State {
    public void handleRequest(Brightness brightness) {
        brightness.setState(new MediumState());
    }

    public String toString() {
        return "Brightness is low";
    }
}

class MediumState implements State {
    public void handleRequest(Brightness brightness) {
        brightness.setState(new HighState());
    }

    public String toString() {
        return "Brightness is medium";
    }
}

class HighState implements State {
    public void handleRequest(Brightness brightness) {
        brightness.setState(new LowState());
    }

    public String toString() {
        return "Brightness is High";
    }
}
