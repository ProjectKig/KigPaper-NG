package com.playkig.kigpaper.config;

import io.papermc.paper.configuration.ConfigurationPart;

public class LegacyCombatConfigImpl extends ConfigurationPart implements LegacyCombatConfig {
  public boolean disableSweepingAttacks = false;
  public boolean allowSprintCriticals = false;
  public boolean legacyRodMechanics = false;
  public boolean legacyHitSounds = false;
  public boolean disableDamageParticles = false;
  public boolean airborneVerticalKnockback = false;

  @Override
  public boolean disableSweepingAttacks() {
    return disableSweepingAttacks;
  }

  @Override
  public boolean allowSprintCriticals() {
    return allowSprintCriticals;
  }

  @Override
  public boolean legacyRodMechanics() {
    return legacyRodMechanics;
  }

  @Override
  public boolean legacyHitSounds() {
    return legacyHitSounds;
  }

  @Override
  public boolean disableDamageParticles() {
    return disableDamageParticles;
  }

  @Override
  public boolean airborneVerticalKnockback() {
    return airborneVerticalKnockback;
  }
}
