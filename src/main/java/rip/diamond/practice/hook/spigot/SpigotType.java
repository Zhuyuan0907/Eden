package rip.diamond.practice.hook.spigot;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SpigotType {

    SPIGOT("org.spigotmc.SpigotConfig"),
    IMANITY_SPIGOT_3("org.imanity.imanityspigot.ImanitySpigot"),
    CARBON_SPIGOT("xyz.refinedev.spigot.config.CarbonConfig");

    private final String package_;

    public String getPackage() {
        return package_;
    }
}
