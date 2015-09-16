package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/16/15.
 */
public class BadNeighboursTest {

    @Test
    public void testMaxDonations() throws Exception {
        BadNeighbours badNeighbours = new BadNeighbours();
        assertThat(badNeighbours.maxDonationCircular(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5})).isEqualTo(16);
        assertThat(badNeighbours.maxDonationCircular(new int[]{10, 3, 2, 5, 7, 8})).isEqualTo(19);
        assertThat(badNeighbours.maxDonationCircular(new int[]{11,15})).isEqualTo(15);
        assertThat(badNeighbours.maxDonationCircular(new int[]{7,7,7,7,7,7,7})).isEqualTo(21);
        assertThat(badNeighbours.maxDonationCircular(new int[]{94,40,49,65,21,21,106,80,92,81,679,4,61,6,237,12,72,74,29,95,265,35,47,1,61,
                397,52,72,37,51,1,81,45,435,7,36,57,86,81,72})).isEqualTo(2926);
        assertThat(badNeighbours.maxDonationCircular(new int[]{347,49,608,460,67,856,21,526,552,412,761,286,
                481,441,598,933,462,328,92})).isEqualTo(4866);
    }
}