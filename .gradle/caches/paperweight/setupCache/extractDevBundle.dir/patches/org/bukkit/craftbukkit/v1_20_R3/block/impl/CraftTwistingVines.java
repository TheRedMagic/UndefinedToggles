/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_20_R3.block.impl;

public final class CraftTwistingVines extends org.bukkit.craftbukkit.v1_20_R3.block.data.CraftBlockData implements org.bukkit.block.data.Ageable {

    public CraftTwistingVines() {
        super();
    }

    public CraftTwistingVines(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_20_R3.block.data.CraftAgeable

    private static final net.minecraft.world.level.block.state.properties.IntegerProperty AGE = getInteger(net.minecraft.world.level.block.TwistingVinesBlock.class, "age");

    @Override
    public int getAge() {
        return this.get(CraftTwistingVines.AGE);
    }

    @Override
    public void setAge(int age) {
        this.set(CraftTwistingVines.AGE, age);
    }

    @Override
    public int getMaximumAge() {
        return getMax(CraftTwistingVines.AGE);
    }
}
