package no.jansenh.netex.utilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.example.netex.utilities.IUtilities;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

class IUtilitiesTest {

  @Test
  void negate() {
    MatcherAssert.assertThat(IUtilities.negate(true), is(false));
    assertThat(IUtilities.negate(false), is(true));
  }
}
