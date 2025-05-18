package net.midget807.trapsntrickery.item.custom;

import net.midget807.trapsntrickery.entity.custom.AbstractSlimeCubeProjectileEntity;
import net.midget807.trapsntrickery.entity.custom.MagmaCubeProjectileEntity;
import net.midget807.trapsntrickery.entity.custom.SlimeCubeProjectileEntity;
import net.midget807.trapsntrickery.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class SlimeCubeItem extends Item {
    private final boolean isMagma;

    public SlimeCubeItem(Settings settings, EntityType<? extends SlimeEntity> entityType) {
        super(settings);
        this.isMagma = entityType == EntityType.MAGMA_CUBE;
    }
    public AbstractSlimeCubeProjectileEntity createSlime(World world, LivingEntity owner, ItemStack stack) {
        SlimeCubeProjectileEntity slimeCubeProjectile = new SlimeCubeProjectileEntity(owner, world);
        slimeCubeProjectile.initFromStack(stack);
        MagmaCubeProjectileEntity magmaCubeProjectile = new MagmaCubeProjectileEntity(owner, world);
        magmaCubeProjectile.initFromStack(stack);
        return isMagma ? magmaCubeProjectile : slimeCubeProjectile;
    }
    public SlimeEntity getSlimeToSpawn(World world, ItemStack itemStack) {
        SlimeEntity slimeEntity;
        if (itemStack.isOf(ModItems.SLIME_CUBE_ITEM)) {
            slimeEntity = new SlimeEntity(EntityType.SLIME, world);
            slimeEntity.setSize(1, true);
        } else if (itemStack.isOf(ModItems.MAGMA_CUBE_ITEM)) {
            slimeEntity = new SlimeEntity(EntityType.MAGMA_CUBE, world);
            slimeEntity.setSize(1, true);
        } else {
            slimeEntity = null;
        }
        return slimeEntity;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            if (user.isSneaking()) {
                SlimeEntity slimeEntity = getSlimeToSpawn(world, itemStack);
                if (slimeEntity == null) {
                    return TypedActionResult.fail(itemStack);
                } else {
                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    world.emitGameEvent(user, GameEvent.ENTITY_PLACE, slimeEntity.getPos());
                    BlockPos blockPos = hitResult.getBlockPos();
                    Direction side = hitResult.getSide();
                    slimeEntity.updatePosition(blockPos.offset(side).getX(), blockPos.offset(side).getY(), blockPos.offset(side).getZ());
                    slimeEntity.setPos(blockPos.offset(side).getX(), blockPos.offset(side).getY(), blockPos.offset(side).getZ());
                    world.spawnEntity(slimeEntity);
                    itemStack.decrementUnlessCreative(1, user);
                    return TypedActionResult.success(itemStack);
                }
            } else {
                AbstractSlimeCubeProjectileEntity projectile = createSlime(world, user, itemStack);
                projectile.updatePosition(user.getX(), user.getEyeY() + 1, user.getZ());
                projectile.setPos(user.getX(), user.getEyeY(), user.getZ());
                projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.3f, 0.5f);
                world.spawnEntity(projectile);
                itemStack.decrementUnlessCreative(1, user);
                return TypedActionResult.success(itemStack);
            }
        } else {
            AbstractSlimeCubeProjectileEntity projectile = createSlime(world, user, itemStack);
            projectile.updatePosition(user.getX(), user.getEyeY() + 1, user.getZ());
            projectile.setPos(user.getX(), user.getEyeY(), user.getZ());
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.3f, 0.5f);
            world.spawnEntity(projectile);
            itemStack.decrementUnlessCreative(1, user);
            return TypedActionResult.success(itemStack);
        }
    }
}
