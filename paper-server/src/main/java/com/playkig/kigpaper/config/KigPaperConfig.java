package com.playkig.kigpaper.config;

import io.papermc.paper.configuration.ConfigurationPart;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.util.CheckedFunction;

public class KigPaperConfig extends ConfigurationPart {
  private static KigPaperConfig INSTANCE;

  public LegacyCombatConfigImpl legacyCombat;
  public boolean sendRecipeBook = true;

  public static KigPaperConfig get() {
    return INSTANCE;
  }

  static void setInstance(KigPaperConfig instance) {
    INSTANCE = instance;
  }

  public LegacyCombatConfigImpl legacyCombat() {
    return legacyCombat;
  }

  public boolean sendRecipeBook() {
    return sendRecipeBook;
  }

  private static <T> CheckedFunction<ConfigurationNode, T, SerializationException> creator(final Class<? extends T> type, final boolean refreshNode) {
    return node -> {
      final T instance = node.require(type);
      if (refreshNode) {
        node.set(type, instance);
      }
      return instance;
    };
  }
}
