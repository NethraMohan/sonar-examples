package org.sonar.samples.javascript;

import org.junit.Test;
import org.sonar.plugins.javascript.api.tests.TreeCheckTest;
import org.sonar.squidbridge.checks.CheckMessagesVerifier;

/**
 * Test class to test the check implementation.
 */
public class ForbiddenFunctionUseCheckTest extends TreeCheckTest {

  @Test
  public void test() throws Exception {
    CheckMessagesVerifier.verify(getIssues("src/test/resources/checks/forbiddenFunctionUseCheck.js", new ForbiddenFunctionUseCheck()))
      .next().atLine(1).withMessage("Remove the usage of this forbidden function.")
      .next().atLine(2)
      .next().atLine(4)
      .next().atLine(5)
      .noMore();
  }

}
