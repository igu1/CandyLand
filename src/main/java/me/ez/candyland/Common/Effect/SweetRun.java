package me.ez.candyland.Common.Effect;

import me.ez.candyland.Init.Iteminit;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Random;

public class SweetRun extends MobEffect {

//    List<ItemStack> candies = List.of(new ItemStack[]{
//            new ItemStack(Iteminit.BLUE_CANDY.get()),
//            new ItemStack(Iteminit.RED_CANDY.get()),
//            new ItemStack(Iteminit.YELLOW_CANDY.get()),
//            new ItemStack(Iteminit.GREEN_CANDY.get()),
//    });

    public SweetRun(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amp) {
        if (!entity.level.isClientSide){
            int x = entity.getBlockX();
            int y = entity.getBlockY();
            int z = entity.getBlockZ();
            Random r = new Random();

//            entity.level.addFreshEntity(CreateItemEntity(candies.get(r.nextInt(0, candies.size())), x ,y , z, entity));
        }
        super.applyEffectTick(entity, amp);
    }

    @Override
    public boolean isDurationEffectTick(int dur, int amp) {
        int j = 25 >> amp;
        if (j > 0) {
            return dur % j == 0;
        } else {
            return true;
        }
    }

    private ItemEntity CreateItemEntity(ItemStack stack, int x, int y, int z, LivingEntity entity){
        return new ItemEntity(entity.level, x, y ,z , stack);
    }
}
