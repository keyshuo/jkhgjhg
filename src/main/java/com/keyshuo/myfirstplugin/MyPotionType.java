package com.keyshuo.myfirstplugin;

import com.sheepion.custompotionapi.CustomPotionEffectType;
import com.sheepion.custompotionapi.CustomPotionManager;
import io.papermc.paper.potion.PotionMix;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.checkerframework.checker.units.qual.N;

import java.util.ArrayList;

/**
 * @author zdw
 * @date 2022/3/5 16:24
 */
public class MyPotionType implements CustomPotionEffectType {
    @Override
    public NamespacedKey getKey() {
        return new NamespacedKey(MyFirstPlugin.getInstance(),"my_potion");
    }

    @Override
    public boolean canBeApplied(LivingEntity entity) {
        return true;
    }

    @Override
    public boolean canBeRemovedByMilk(LivingEntity entity, int duration, int amplifier, int checkInterval) {
        return false;
    }

    @Override
    public void effect(LivingEntity entity, int duration, int amplifier, int checkInterval) {
        entity.getWorld().strikeLightning(entity.getLocation());
        entity.sendMessage("你正收到药水效果："+" duration: "+duration+" amplifier:"+amplifier+" checkInterval:"+checkInterval);
    }

    @Override
    public ArrayList<PotionMix> potionMixes() {
        ItemStack result=CustomPotionManager.getPotion(getKey(),200,1,10);
        RecipeChoice input= new RecipeChoice.MaterialChoice(Material.STONE);
        RecipeChoice ingredient=new RecipeChoice.MaterialChoice(Material.DIAMOND_BLOCK);
        PotionMix potionMix=new PotionMix(new NamespacedKey(MyFirstPlugin.getInstance(),"my_potion_mix"),result ,input,ingredient);
        ArrayList<PotionMix> mixes=new ArrayList<>();
        mixes.add(potionMix);
        return mixes;
    }

    @Override
    public Component potionDisplayName(int duration, int amplifier, int checkInterval) {
        return Component.text(ChatColor.BLUE+"我的药水");
    }

    @Override
    public ArrayList<Component> potionLore(int duration, int amplifier, int checkInterval) {
        ArrayList<Component> lore=new ArrayList<>();
        lore.add(Component.text(ChatColor.WHITE+"喝了以后被雷劈"));
        return lore;
    }

    @Override
    public Color potionColor(int duration, int amplifier, int checkInterval) {
        return Color.FUCHSIA;
    }

    @Override
    public boolean potionEnchanted() {
        return true;
    }

    @Override
    public ArrayList<Component> splashPotionLore(int duration, int amplifier, int checkInterval) {
        ArrayList<Component> lore=new ArrayList<>();
        lore.add(Component.text(ChatColor.WHITE+"喝了以后被雷劈"));
        return lore;
    }

    @Override
    public Component splashPotionDisplayName(int duration, int amplifier, int checkInterval) {
        return Component.text(ChatColor.BLUE+"我的药水");
    }

    @Override
    public Color splashPotionColor(int duration, int amplifier, int checkInterval) {
        return Color.WHITE;
    }

    @Override
    public boolean splashPotionEnchanted() {
        return true;
    }
}
