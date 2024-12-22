package no.jansenh.netex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class INetexTest {

  @Test
  void negate() {
    assertThat(INetex.negate(true), is(false));
    assertThat(INetex.negate(false), is(true));
  }
}
