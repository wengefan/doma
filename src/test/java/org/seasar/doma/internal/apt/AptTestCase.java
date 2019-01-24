package org.seasar.doma.internal.apt;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import junit.framework.AssertionFailedError;
import org.seasar.aptina.unit.AptinaTestCase;
import org.seasar.doma.Dao;
import org.seasar.doma.Domain;
import org.seasar.doma.Embeddable;
import org.seasar.doma.Entity;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.internal.apt.util.MetaUtil;
import org.seasar.doma.internal.util.ResourceUtil;
import org.seasar.doma.message.Message;

public abstract class AptTestCase extends AptinaTestCase {

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    addSourcePath("src/test/java");
    addSourcePath("src/test/resources");
    setCharset("UTF-8");
    setLocale(Locale.JAPAN);
    TimeZone.setDefault(TimeZone.getTimeZone("GMT+9"));
  }

  @Override
  protected void tearDown() throws Exception {
    TimeZone.setDefault(null);
    super.tearDown();
  }

  protected String getExpectedContent() throws Exception {
    String path = getClass().getName().replace(".", "/");
    String suffix = "_" + getName().substring("test".length()) + ".txt";
    return ResourceUtil.getResourceAsString(path + suffix);
  }

  protected void assertGeneratedSource(Class<?> originalClass) throws Exception {
    String generatedClassName = getGeneratedClassName(originalClass);
    try {
      assertEqualsGeneratedSource(getExpectedContent(), generatedClassName);
    } catch (AssertionFailedError error) {
      System.out.println(getGeneratedSource(generatedClassName));
      throw error;
    }
  }

  protected String getGeneratedClassName(Class<?> originalClass) {
    if (originalClass.isAnnotationPresent(Dao.class)) {
      return originalClass.getName() + Options.Constants.DEFAULT_DAO_SUFFIX;
    }
    if (originalClass.isAnnotationPresent(Entity.class)
        || originalClass.isAnnotationPresent(Embeddable.class)
        || originalClass.isAnnotationPresent(Domain.class)
        || originalClass.isAnnotationPresent(ExternalDomain.class)) {
      return MetaUtil.toFullMetaName(originalClass.getName());
    }
    throw new AssertionFailedError("annotation not found.");
  }

  protected void assertMessage(Message message) {
    List<Diagnostic<? extends JavaFileObject>> diagnostics = getDiagnostics();
    if (diagnostics.size() == 1) {
      Message m = extractMessage(diagnostics.get(0));
      if (m == null) {
        fail();
      }
      if (message == m) {
        return;
      }
      fail("actual message id: " + m.name());
    }
    fail();
  }

  protected void assertNoMessage() {
    List<Diagnostic<? extends JavaFileObject>> diagnostics = getDiagnostics();
    if (!diagnostics.isEmpty()) {
      fail();
    }
  }

  @Override
  protected List<Diagnostic<? extends JavaFileObject>> getDiagnostics() {
    List<Diagnostic<? extends JavaFileObject>> results =
        new ArrayList<Diagnostic<? extends JavaFileObject>>();
    for (Diagnostic<? extends JavaFileObject> diagnostic : super.getDiagnostics()) {
      switch (diagnostic.getKind()) {
        case ERROR:
        case WARNING:
        case MANDATORY_WARNING:
          results.add(diagnostic);
          break;
        default:
          // do nothing
      }
    }
    return results;
  }

  protected Message getMessageCode() {
    for (Diagnostic<? extends JavaFileObject> diagnostic : getDiagnostics()) {
      return extractMessage(diagnostic);
    }
    return null;
  }

  protected Message extractMessage(Diagnostic<? extends JavaFileObject> diagnostic) {
    String message = diagnostic.getMessage(getLocale());
    int start = message.indexOf('[');
    int end = message.indexOf(']');
    if (start > -1 && end > -1) {
      String code = message.substring(start + 1, end);
      if (code.startsWith("DOMA")) {
        return Enum.valueOf(Message.class, code);
      }
    }
    return null;
  }
}
