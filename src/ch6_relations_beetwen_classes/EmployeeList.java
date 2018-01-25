package ch6_relations_beetwen_classes;

import java.util.*;

class Employee {

}

public class EmployeeList {

    private Employee [] employees = new Employee[10];

    class Iterator implements java.util.Iterator {

        int element = 0;
        public boolean hasNext() {
            return element < employees.length;
        }

        public Object next() {
            if (hasNext()) {
                return employees[element++];
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    Iterator getIterator() {
        return new Iterator();
    }
}
