package me.arxnair.ultratech;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

public class UltraTech extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        // Slimefun4 also already comes with a bundled version of bStats
        // You can use bStats to collect usage data about your plugin
        // More info: https://bstats.org/getting-started
        // Set bStatsId to the id of your plugin
        int bStatsId = -1;
        new Metrics(this, bStatsId);

        ItemStack categoryItem = new CustomItem(Material.POLISHED_DIORITE, "&4Ultra Category", "", "&a> Click to open");
        NamespacedKey categoryId = new NamespacedKey(this, "ultra_category");
        
        Category category = new Category(categoryId, categoryItem);

        SlimefunItemStack slimefunItem = new SlimefunItemStack("MACHINE_STACKER", Material.SMITHING_TABLE, "&4Machine_Stacker", "&cUltra End-Game Machine Presser");

        ItemStack[] recipe = { new
        		ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD),
        		null, new SlimefunItems.CARBONADO, null,
        		new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD)
        		};

        SlimefunItem item = new SlimefunItem(category, slimefunItem, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }
}
