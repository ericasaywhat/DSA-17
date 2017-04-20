import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class DistanceTest {

    @Test
    public void testMinEditDist1() {
        assertThat(EditDistance.minEditDist("sunday", "saturday"), is(3));
    }

    @Test
    public void testMinEditDist2() {
        assertThat(EditDistance.minEditDist("sidd", "squid"), is(3));
    }

    @Test
    public void testMinEditDist3() {
        assertThat(EditDistance.minEditDist("katie", "rabies"), is(3));
    }

    @Test
    public void testMinEditDist4() {
        assertThat(EditDistance.minEditDist("katie", "sidd"), is(5));
    }

    @Test
    public void testMinEditDist5() {
        assertThat(EditDistance.minEditDist("", "sidd"), is(4));
    }

    @Test
    public void testMidEditDist6() { assertThat(EditDistance.minEditDist("", ""), is(0)); }

    @Test
    public void testMidEditDist7() { assertThat(EditDistance.minEditDist("ab", "ba"), is(2)); }

    @Test
    public void testMidEditDist8() { assertThat(EditDistance.minEditDist("abbabbabba", "abbabbabbb"), is(1)); }
}
