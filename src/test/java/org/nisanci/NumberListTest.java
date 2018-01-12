package org.nisanci;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class NumberListTest {

    @Test
    public void testAssertList() {

        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        assertThat(actual, is(expected));

        assertThat(actual, hasItems(2));

        assertThat(actual, hasSize(5));

        assertThat(actual.size(), is(5));

        assertThat(actual, contains(1, 2, 3, 4, 5));

        assertThat(actual, containsInAnyOrder(5, 4, 3, 2, 1));

        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(actual, everyItem(greaterThanOrEqualTo(1)));

        assertThat(actual, everyItem(lessThan(10)));
    }
}
