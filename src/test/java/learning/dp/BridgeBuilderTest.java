package learning.dp;

import ds.Tuple;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/7/15.
 */
public class BridgeBuilderTest {

    @Test
    public void testFindMaxBridges() throws Exception {
        BridgeBuilder bridgeBuilder = new BridgeBuilder();
        assertThat(bridgeBuilder.findMaxBridges(new Tuple[]{
                new Tuple(1, 4), new Tuple(3, 1), new Tuple(2, 2), new Tuple(4, 3)
        })).isEqualTo(2);
    }
}
