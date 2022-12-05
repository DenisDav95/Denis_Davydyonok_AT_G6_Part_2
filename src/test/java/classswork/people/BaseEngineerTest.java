package classswork.people;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import people.AutomatedEngineer;
import people.Engineer;
import people.ManualEngineer;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BaseEngineerTest {

    private Engineer en;
    private int skill;

    public BaseEngineerTest(Engineer en, int skill) {
        this.en = en;
        this.skill = skill;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                {new ManualEngineer(23, 8), 16},
                {new AutomatedEngineer(25,8), 24}
        });
    }

    @Test
    public void skillTest() {
        Assert.assertEquals("The skill is not correct", skill, en.getSkill());
    }
}
