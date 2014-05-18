package miam.domain;

import org.bson.util.Assertions;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {


    @Test
    public void shouldMatchStringWithValueEnum() {
        Assert.assertTrue(Color.valueOfString("red").equals(Color.RED));
    }

}