package ms.moreslabs.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

import static net.minecraft.block.FallingBlock.canFallThrough;

public class CustomDirtBlock extends SlabBlock {
    public CustomDirtBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(TYPE) == SlabType.DOUBLE) {
            // Convert the double slab into a different block (e.g., dirt block)
            world.setBlockState(pos, Blocks.DIRT.getDefaultState());
        }
    }
}
