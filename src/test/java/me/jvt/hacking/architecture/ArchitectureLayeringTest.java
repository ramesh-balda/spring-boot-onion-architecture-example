package me.jvt.hacking.architecture;

import static com.tngtech.archunit.base.DescribedPredicate.describe;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AnalyzeClasses(packages = "me.jvt.hacking")
class ArchitectureLayeringTest {
  private static final String APPLICATION_RING = "..application..";
  private static final String INFRASTRUCTURE_RING = "..infrastructure..";
  private static final String DOMAIN_RING = "..domain..";

  @ArchTest
  @SuppressWarnings("unused")
  private final ArchRule onionArchitecture = JMoleculesArchitectureRules.ensureOnionClassical();

  @ArchTest
  @SuppressWarnings("unused")
  private final ArchRule mockMvcAnnotationShouldOnlyBeUsedInInfrastructureRing =
      classes()
          .that()
          .areAnnotatedWith(AutoConfigureMockMvc.class)
          .should()
          .resideInAPackage(INFRASTRUCTURE_RING);

  @ArchTest
  @SuppressWarnings("unused")
  private final ArchRule webMvcTestAnnotationShouldOnlyBeUsedInInfrastructureRing =
      classes()
          .that()
          .areAnnotatedWith(WebMvcTest.class)
          .should()
          .resideInAPackage(INFRASTRUCTURE_RING);

  @ArchTest
  @SuppressWarnings("unused")
  private final ArchRule springBootTestAnnotationShouldOnlyBeUsedInApplicationRing =
      classes()
          .that()
          .areAnnotatedWith(SpringBootTest.class)
          .should()
          .resideInAPackage(APPLICATION_RING);

  @ArchTest
  @SuppressWarnings("unused")
  private final ArchRule springBootApplicationAnnotationShouldOnlyBeUsedInApplicationRing =
      classes()
          .that()
          .areAnnotatedWith(SpringBootApplication.class)
          .should()
          .resideInAPackage(APPLICATION_RING);

  @ArchTest
  @SuppressWarnings("unused")
  private final ArchRule mockMvcShouldOnlyBeUsedInInfrastructureRing =
      classes()
          .that()
          .containAnyFieldsThat(
              describe(
                  "are instances of `MockMvc`", f -> f.getRawType().isEquivalentTo(MockMvc.class)))
          .should()
          .resideInAPackage(INFRASTRUCTURE_RING);

  @ArchTest
  @SuppressWarnings("unused")
  private final ArchRule springShouldNotBeUsedInDomainRing =
      classes()
          .that()
          .resideInAnyPackage(DOMAIN_RING)
          .should()
          .notBeAnnotatedWith(
              describe(
                  "Spring Framework annotations",
                  a -> a.getType().getName().startsWith("org.springframework")));
}
