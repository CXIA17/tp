package seedu.duke.userProfile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.InitializeCommand;
import seedu.duke.userprofile.Health;
import seedu.duke.userprofile.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class userProfileTest {

    @Test
    public void userProfileToString() {
        Profile profile = new Profile("Jack", "Robotics", 25000 );
        profile.toString();
        assertEquals("this user's name is :Jack" + '\n'
                + "occupation :Robotics"  + '\n'
                + "current health :100"
                + "current asset: 5000" , profile.toString());
    }

    @Test
    public void userHealthTest() {
        Health userHealth = new Health();
        assertEquals("100", userHealth.outputHealth());
    }
}
