import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user = new User("Bob", 100, "male");

    @Test
    void testSetName() {
        user.setName("Alice");
        assertEquals("Alice",user.getName());
    }

    @Test
    void testSetAge() {
        user.setAge(50);
        assertEquals(50,user.getAge());
    }

    @Test
    void testSetSex() {
        user.setSex("female");
        assertEquals("female",user.getSex());
    }


    @Test
    void testGetUserScoresAndMetrics() {
        assertEquals(null,user.getUserScoresAndMetrics());
    }

    @Test
    void setUserScoresAndMetrics() {
        Trait[] traits = new Trait[5];
        for(int i = 0; i<5;i++){
            traits[i]=new Trait("Test"+i,i,i+1,i+2,i+3,"low");
        }

        user.setUserScoresAndMetrics(traits);

        assertArrayEquals(traits,user.getUserScoresAndMetrics());
    }
}