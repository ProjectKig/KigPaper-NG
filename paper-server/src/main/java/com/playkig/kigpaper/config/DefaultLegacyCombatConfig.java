package com.playkig.kigpaper.config;

import io.papermc.paper.configuration.ConfigurationPart;

public class DefaultLegacyCombatConfig extends ConfigurationPart implements LegacyCombatConfig {
  public boolean disableSweepingAttacks = false;
  public boolean allowSprintCriticals = false;
  public boolean legacyProjectiles = false;
  public boolean legacyHitSounds = false;
  public boolean disableDamageParticles = false;
  public boolean airborneVerticalKnockback = false;
  public boolean zeroDamageHits = false;
  public boolean independentExtraKnockback = false;

  @Override
  public boolean disableSweepingAttacks() {
    return disableSweepingAttacks;
  }

  @Override
  public boolean allowSprintCriticals() {
    return allowSprintCriticals;
  }

  @Override
  public boolean legacyProjectiles() {
    return legacyProjectiles;
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

  @Override
  public boolean zeroDamageHits() {
    return zeroDamageHits;
  }

  @Override
  public boolean independentExtraKnockback() {
    return independentExtraKnockback;
  }
}
