package org.nisanci;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class ObjectListTest {

    @Test
    public void testAssertList() {
        List<Fruit> fruitList = Arrays.asList(new Fruit("banana", 2),
                new Fruit("apple", 3));

        assertThat(fruitList, hasItem(new Fruit("banana", 2)));

        assertThat(fruitList, containsInAnyOrder(new Fruit("apple", 3), new Fruit("banana", 2)));

        assertThat(fruitList, containsInAnyOrder(
                hasProperty("name", is("apple")),
                hasProperty("name", is("banana"))
        ));
    }

    public class Fruit {

        public Fruit(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }

        private String name;
        private int qty;

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        //Test equal, override equals() and hashCode()
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fruit fruit = (Fruit) o;
            return qty == fruit.qty &&
                    Objects.equals(name, fruit.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, qty);
        }
    }
}
