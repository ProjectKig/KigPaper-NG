package com.playkig.kigpaper.event;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Fired when an entity broadcasts a movement packet.
 */
public class EntityMovementPacketEvent extends EntityEvent implements Cancellable {
  private static final HandlerList HANDLER_LIST = new HandlerList();

  private final Object packet;
  private boolean cancelled;

  public EntityMovementPacketEvent(@NotNull Entity entity, Object packet) {
    super(entity);
    this.packet = packet;
  }

  public Object getPacket() {
    return packet;
  }

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }

  public static HandlerList getHandlerList() {
    return HANDLER_LIST;
  }

  @Override
  public HandlerList getHandlers() {
    return HANDLER_LIST;
  }
}
