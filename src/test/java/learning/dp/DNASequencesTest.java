package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 10/6/15.
 */
public class DNASequencesTest {

    @Test
    public void testFindLCS() throws Exception {
        DNASequences dnaSequences = new DNASequences();
        assertThat(dnaSequences.findLCS("lovxxelyxxxxx","xxxxxxxlovely",3)).isEqualTo(6);
        assertThat(dnaSequences.findLCS("lovxxelyxxxxx","xxxxxxxlovely",1)).isEqualTo(7);
        assertThat(dnaSequences.findLCS("lovxxxelxyxxxx","xxxlovelyxxxxxxx",3)).isEqualTo(10);
        assertThat(dnaSequences.findLCS("lovxxxelyxxx","xxxxxxlovely",4)).isEqualTo(0);
        assertThat(dnaSequences.findLCS("pqrz","pqrpqrz",3)).isEqualTo(4);
    }
}
