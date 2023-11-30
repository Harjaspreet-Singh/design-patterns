package com.designpattern.interpreter;

public class InterpreterExample {

    // Abstract Expression class
    interface Expression {
        int interpret();
    }

    // Terminal Expression for numbers
    public static class Number implements Expression {
        private int value;

        public Number(int value) {
            this.value = value;
        }

        @Override
        public int interpret() {
            return value;
        }
    }

    // Non-terminal Expression for addition
    public static class Add implements Expression {
        private Expression left;
        private Expression right;

        public Add(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret() {
            return left.interpret() + right.interpret();
        }
    }

    // Non-terminal Expression for subtraction
    public static class Subtract implements Expression {
        private Expression left;
        private Expression right;

        public Subtract(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret() {
            return left.interpret() - right.interpret();
        }
    }
}
