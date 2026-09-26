package com.playkig.kigpaper.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fired when a world explosion is displayed to a player.
 */
public class ExplosionDisplayEvent extends PlayerEvent implements Cancellable {
  private static final HandlerList HANDLER_LIST = new HandlerList();

  private final Entity source;
  private boolean cancelled;

  public ExplosionDisplayEvent(@NotNull Player player, Entity source) {
    super(player);
    this.source = source;
  }

  @Nullable
  public Entity getSource() {
    return source;
  }

  public static HandlerList getHandlerList() {
    return HANDLER_LIST;
  }

  @Override
  public HandlerList getHandlers() {
    return HANDLER_LIST;
  }

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean cancel) {
    this.cancelled = cancel;
  }
}
