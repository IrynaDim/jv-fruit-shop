package core.basesyntax;

import core.basesyntax.AddFruit;
import core.basesyntax.Fruit;
import core.basesyntax.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddFruitTest {

    public final static List<Fruit> EXPECTED = List.of(
            new Fruit("banana","2020-10-15"),
            new Fruit("banana","2020-10-15"));

    public final static List<Fruit> EXPECTED2 = List.of(
            new Fruit("banana","2020-10-15"),
            new Fruit("banana","2020-10-15"));

    @Test
    public void adding_Test_OK() {
        AddFruit add = new AddFruit ();
        List <Fruit> fruitsAvailable = new ArrayList<>();
        List<Fruit> fruits = add.operation(fruitsAvailable,
                new Transaction("s","banana"
                        ,2,"2020-10-15"));
        Assert.assertEquals(EXPECTED.size(), fruits.size());
    }

    @Test
    public void adding_Test2_OK() {
        AddFruit add = new AddFruit ();
        List <Fruit> fruitsAvailable = new ArrayList<>();
        List<Fruit> fruits = add.operation(fruitsAvailable,
                new Transaction("r","banana"
                        ,2,"2020-10-15"));
        Assert.assertEquals(EXPECTED.size(), fruits.size());
    }
}
