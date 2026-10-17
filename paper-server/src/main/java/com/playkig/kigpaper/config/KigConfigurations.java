package com.playkig.kigpaper.config;

import io.papermc.paper.configuration.ConfigurationPart;
import io.papermc.paper.configuration.Configurations;
import io.papermc.paper.configuration.serializer.ComponentSerializer;
import io.papermc.paper.configuration.serializer.EnumValueSerializer;
import io.papermc.paper.configuration.serializer.IdentifierSerializer;
import io.papermc.paper.configuration.serializer.NbtPathSerializer;
import io.papermc.paper.configuration.serializer.collection.map.MapSerializer;
import io.papermc.paper.configuration.type.BooleanOrDefault;
import io.papermc.paper.configuration.type.Duration;
import io.papermc.paper.configuration.type.DurationOrDisabled;
import io.papermc.paper.configuration.type.number.DoubleOr;
import io.papermc.paper.configuration.type.number.IntOr;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.ConfigurationOptions;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.util.CheckedFunction;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

import java.lang.reflect.Type;
import java.nio.file.Path;

import static io.leangen.geantyref.GenericTypeReflector.erase;

public class KigConfigurations extends Configurations<KigPaperConfig, Void> {
  public KigConfigurations(final Path globalFolder) {
    super(globalFolder, KigPaperConfig.class, Void.class, "kig-paper.yml",
            "kig-world-defaults.yml", "kig-world.yml");
  }

  public void reloadConfigs(MinecraftServer server) {
    try {
      this.initializeGlobalConfiguration(server.registryAccess(), reloader(this.globalConfigClass, KigPaperConfig.get()));
    } catch (Exception ex) {
      throw new RuntimeException("Could not reload KigPaper configuration files", ex);
    }
  }

  @Override
  protected KigPaperConfig initializeGlobalConfiguration(RegistryAccess registryAccess, CheckedFunction<ConfigurationNode, KigPaperConfig, SerializationException> creator) throws ConfigurateException {
    KigPaperConfig config = super.initializeGlobalConfiguration(registryAccess, creator);
    KigPaperConfig.setInstance(config);
    return config;
  }

  @Override
  protected boolean isConfigType(Type type) {
    return ConfigurationPart.class.isAssignableFrom(erase(type));
  }

  @Override
  protected int globalConfigVersion() {
    return 0;
  }

  @Override
  protected int worldConfigVersion() {
    return 0;
  }

  @Override
  protected YamlConfigurationLoader.Builder createLoaderBuilder() {
    return super.createLoaderBuilder()
            .defaultOptions(KigConfigurations::defaultOptions);
  }

  private static ConfigurationOptions defaultOptions(ConfigurationOptions options) {
    return options.serializers(builder -> builder
            .register(MapSerializer.TYPE, new MapSerializer(false))
            .register(new EnumValueSerializer())
            .register(new ComponentSerializer())
            .register(IntOr.Default.SERIALIZER)
            .register(IntOr.Disabled.SERIALIZER)
            .register(DoubleOr.Default.SERIALIZER)
            .register(DoubleOr.Disabled.SERIALIZER)
            .register(BooleanOrDefault.SERIALIZER)
            .register(Duration.SERIALIZER)
            .register(DurationOrDisabled.SERIALIZER)
            .register(NbtPathSerializer.SERIALIZER)
            .register(IdentifierSerializer.INSTANCE)
    );
  }
}