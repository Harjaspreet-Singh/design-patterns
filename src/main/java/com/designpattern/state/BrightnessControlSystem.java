package com.designpattern.state;

// Public class representing a brightness control system using the State pattern.
public class BrightnessControlSystem {

    // Context class managing the state of brightness.
    private static class Brightness {
        // Private variable to store the current state.
        private State state;

        // Constructor initializes the state to LowState.
        public Brightness() {
            this.state = new LowState();
        }

        // Setter method to change the state.
        public void setState(State state) {
            this.state = state;
        }

        // Method to handle a button press, delegates to the current state.
        public void pressButton() {
            state.handleRequest(this);
        }

        // Override toString() to provide a string representation of the current state.
        public String toString() {
            return state.toString();
        }
    }

    // Interface declaring a method for handling requests.
    private interface State {
        void handleRequest(Brightness brightness);
    }

    // Concrete state representing low brightness.
    private static class LowState implements State {
        // Changes the state to MediumState when handling a request.
        public void handleRequest(Brightness brightness) {
            brightness.setState(new MediumState());
        }

        // Override toString() to provide a string representation of the state.
        public String toString() {
            return "Brightness is low";
        }
    }

    // Concrete state representing medium brightness.
    private static class MediumState implements State {
        // Changes the state to HighState when handling a request.
        public void handleRequest(Brightness brightness) {
            brightness.setState(new HighState());
        }

        // Override toString() to provide a string representation of the state.
        public String toString() {
            return "Brightness is medium";
        }
    }

    // Concrete state representing high brightness.
    private static class HighState implements State {
        // Changes the state to LowState when handling a request.
        public void handleRequest(Brightness brightness) {
            brightness.setState(new LowState());
        }

        // Override toString() to provide a string representation of the state.
        public String toString() {
            return "Brightness is High";
        }
    }
}