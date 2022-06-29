package com.yazici.huaweitask.utils;

import java.util.Objects;
import java.util.function.Consumer;

public final class StreamUtils {

  public static <T> void setIfNotNull(T value, Consumer<T> setter) {
    if (Objects.nonNull(value)) {
      setter.accept(value);
    }
  }
}
