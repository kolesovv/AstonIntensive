package com.github.kolesovv;

import com.github.kolesovv.task_1.collections.ArrayList_SergeiKolesov;
import com.github.kolesovv.task_1.collections.IntensiveList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class ArrayList_SergeiKolesovTest {
    private IntensiveList<String> actualList;

    @BeforeEach
    public void init() {
        actualList = new ArrayList_SergeiKolesov<>();
        actualList.add("Haval");
        actualList.add("Audi");
        actualList.add("Seat");
    }

    @Test
    void size_listIsGiven_sizeIsReturned() {
        //GIVEN
        int expectedSize = 3;
        //WHEN
        int actualSize = actualList.size();
        //THEN
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    void add_correctObjectIsGiven_objectIsAdded() {
        //GIVEN
        String expectedItem = "Dodge";
        //WHEN
        actualList.add(expectedItem);
        //THEN
        int index = actualList.size() - 1;
        Assertions.assertEquals(expectedItem, actualList.get(index));
    }

    @Test
    void add_correctIndexAndObjectIsGiven_objectIsAdded() {
        //GIVEN
        String expectedItem = "Dodge";
        int index = 1;
        //WHEN
        actualList.add(index, expectedItem);
        //THEN
        String actualItem = actualList.get(index);
        Assertions.assertEquals(expectedItem, actualItem);
    }

    @Test
    void get_correctIndexIsGiven_correctObjectIsReturned() {
        //GIVEN
        final String expectedItem = "Audi";
        //WHEN
        int index = 1;
        String actualItem = actualList.get(index);
        //THEN
        Assertions.assertEquals(expectedItem, actualItem);
    }

    @Test
    void set_correctIndexAndObjectIsGiven_objectIsAdded() {
        //GIVEN
        final String expectedItem = "Audi";
        //WHEN
        int index = 1;
        actualList.set(index, expectedItem);
        //THEN
        String actualItem = actualList.get(index);
        Assertions.assertEquals(expectedItem, actualItem);
    }

    @Test
    void remove_correctIndexIsGiven_objectIsDeleted() {
        //GIVEN
        final String expectedRemovedItem = "Audi";
        //WHEN
        int index = 1;
        String actualRemovedItem = actualList.remove(index);
        //THEN
        Assertions.assertEquals(expectedRemovedItem, actualRemovedItem);
        Assertions.assertNotEquals(expectedRemovedItem, actualList.get(index));
    }

    @Test
    void clear_methodIsCalled_listIsEmpty() {
        //GIVEN
        IntensiveList<String> expectedList = new ArrayList_SergeiKolesov<>();
        //WHEN
        actualList.clear();
        //THEN
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void quickSort_methodIsCalled_listIsSorted() {
        //GIVEN
        IntensiveList<String> expectedList = new ArrayList_SergeiKolesov<>();
        expectedList.add("Audi");
        expectedList.add("Haval");
        expectedList.add("Seat");
        //WHEN
        Comparator<String> c = String::compareTo;
        actualList.quickSort(c);
        //THEN
        Assertions.assertEquals(expectedList, actualList);
        Assertions.assertTrue(actualList.isSorted());
    }

    @Test
    void split_methodIsCalled_listIsSplited() {
        //GIVEN
        int size = 2;
        IntensiveList<String> expectedList = new ArrayList_SergeiKolesov<>(size);
        expectedList.add("Haval");
        expectedList.add("Audi");
        //WHEN
        actualList.split(size);
        //THEN
        Assertions.assertEquals(expectedList, actualList);
    }
}