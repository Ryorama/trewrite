package kmerrill285.trewrite.entities.monsters;

import kmerrill285.trewrite.core.items.ItemStackT;
import kmerrill285.trewrite.entities.EntityItemT;
import kmerrill285.trewrite.items.ItemsT;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityDrownedT extends DrownedEntity {

	public int money;
	
	public EntityDrownedT(EntityType<EntityDrownedT> type, World worldIn) {
		super(type, worldIn);
	}
	
	public EntityDrownedT(World world) {
		super(EntityType.DROWNED, world);
	}

	@Override
	public void dropLoot(DamageSource source, boolean b) {
//		EntityItemT.spawnItem(this.getEntityWorld(), this.getPosition(), new ItemStackT(ItemsT.DEMONITE_ORE, this.rand.nextInt(87 - 30) + 30, null));
    }
	
	protected void registerAttributes() {
	      super.registerAttributes();
	      
	      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(rand.nextInt(10) + 35);
	      this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(rand.nextInt(3) + 4);
	      this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(rand.nextDouble() * 0.1 + 0.5);
	      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(rand.nextInt(7) + 12);
	      
	      money = rand.nextInt(20) + 50;
	}
}
