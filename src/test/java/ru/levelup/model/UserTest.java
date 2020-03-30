package ru.levelup.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getX() {
        int result = new User().getX();

        assertEquals("getX should retern 999",
                999,
                 result);
    }
}