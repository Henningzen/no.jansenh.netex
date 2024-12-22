package no.jansenh.netex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class AppTest {

  @Test
  void verify() {
    App app = new App();
    assertThat(app.verify(false), is(true));
    assertThat(app.verify(true), is(false));
  }
}
