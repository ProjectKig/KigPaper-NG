package com.playkig.kigpaper.config;

import io.papermc.paper.configuration.ConfigurationPart;

public class KigPaperConfig extends ConfigurationPart {
  private static KigPaperConfig INSTANCE;

  public DefaultLegacyCombatConfig legacyCombat;
  public boolean sendRecipeBook = true;
  public boolean legacyMoveInterpolation = false;

  public static KigPaperConfig get() {
    return INSTANCE;
  }

  static void setInstance(KigPaperConfig instance) {
    INSTANCE = instance;
  }

  public DefaultLegacyCombatConfig legacyCombat() {
    return legacyCombat;
  }

  public boolean sendRecipeBook() {
    return sendRecipeBook;
  }

  public boolean legacyMoveInterpolation() {
    return legacyMoveInterpolation;
  }
}
