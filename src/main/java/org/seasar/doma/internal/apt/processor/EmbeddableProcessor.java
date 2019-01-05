package org.seasar.doma.internal.apt.processor;

import static org.seasar.doma.internal.util.AssertionUtil.assertNotNull;

import java.io.IOException;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.element.TypeElement;
import org.seasar.doma.Embeddable;
import org.seasar.doma.internal.apt.Options;
import org.seasar.doma.internal.apt.generator.EmbeddableTypeGenerator;
import org.seasar.doma.internal.apt.generator.Generator;
import org.seasar.doma.internal.apt.meta.entity.EmbeddableMeta;
import org.seasar.doma.internal.apt.meta.entity.EmbeddableMetaFactory;

@SupportedAnnotationTypes({"org.seasar.doma.Embeddable"})
@SupportedOptions({
  Options.VERSION_VALIDATION,
  Options.RESOURCES_DIR,
  Options.LOMBOK_VALUE,
  Options.LOMBOK_ALL_ARGS_CONSTRUCTOR,
  Options.TEST,
  Options.DEBUG
})
public class EmbeddableProcessor extends AbstractGeneratingProcessor<EmbeddableMeta> {

  public EmbeddableProcessor() {
    super(Embeddable.class);
  }

  @Override
  protected EmbeddableMetaFactory createTypeElementMetaFactory() {
    return new EmbeddableMetaFactory(ctx);
  }

  @Override
  protected Generator createGenerator(TypeElement typeElement, EmbeddableMeta meta)
      throws IOException {
    assertNotNull(typeElement, meta);
    return new EmbeddableTypeGenerator(ctx, typeElement, meta);
  }
}
