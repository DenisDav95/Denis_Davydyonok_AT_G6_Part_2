package classswork.people;

import org.junit.Assert;
import org.junit.Test;
import people.ManualEngineer;

public class ManualEngineerTests {

    ManualEngineer testEngineer = new ManualEngineer(5, 8);

    @Test
    public void ageTest() {
        Assert.assertEquals("The age is not correct",5, testEngineer.getAge() );
    }

    @Test
    public void skillTest() {
        Assert.assertEquals("The skill is not correct", 16, testEngineer.getSkill());
    }

    @Test
    public void experienceTest() {
        Assert.assertEquals("The experience is not correct", 8, testEngineer.getExperience());
    }
}
