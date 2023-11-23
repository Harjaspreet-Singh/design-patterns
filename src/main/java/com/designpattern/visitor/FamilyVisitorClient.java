package com.designpattern.visitor;


import java.util.ArrayList;
import java.util.List;

public class FamilyVisitorClient {

    // the FamilyElement interface
    interface FamilyElement {
        void accept(FamilyElementVisitor visitor);
    }

    // the Parents class that implements FamilyElement
    static class Parents implements FamilyElement {
        public void accept(FamilyElementVisitor visitor) {
            visitor.visit(this);
        }
    }

    // the UncleAunty class that implements FamilyElement
    static class UncleAunty implements FamilyElement {
        public void accept(FamilyElementVisitor visitor) {
            visitor.visit(this);
        }
    }

    // the Brother class that implements FamilyElement
    static class Brother implements FamilyElement {
        public void accept(FamilyElementVisitor visitor) {
            visitor.visit(this);
        }
    }

    // the Cousin class that implements FamilyElement
    static class Cousin implements FamilyElement {
        public void accept(FamilyElementVisitor visitor) {
            visitor.visit(this);
        }
    }

    // the Family class that implements FamilyElement
    static class Family implements FamilyElement {
        private final List<FamilyElement> elements;

        public Family() {
            this.elements = new ArrayList<>();
            this.elements.add(new Parents());
            this.elements.add(new UncleAunty());
            this.elements.add(new Brother());
            this.elements.add(new Cousin());
        }

        public void accept(FamilyElementVisitor visitor) {
            for (FamilyElement element : elements) {
                element.accept(visitor);
            }
        }
    }

    // the FamilyElementVisitor interface
    interface FamilyElementVisitor {
        void visit(Parents parents);
        void visit(UncleAunty uncleAunty);
        void visit(Brother brother);
        void visit(Cousin cousin);
    }

    // the FamElementPrintVisitor class that implements FamilyElementVisitor
    static class FamElementPrintVisitor implements FamilyElementVisitor {
        public void visit(Parents parents) {
            System.out.println("Visiting Parents");
        }

        public void visit(UncleAunty uncleAunty) {
            System.out.println("Visiting Uncle and Aunty");
        }

        public void visit(Brother brother) {
            System.out.println("Visiting the big Brother");
        }

        public void visit(Cousin cousin) {
            System.out.println("Visiting the older cousin");
        }
    }
}



















