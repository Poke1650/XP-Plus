package me.poke.xpplus.items.cards;

import java.util.List;

import me.poke.xpplus.Reference;
import me.poke.xpplus.xpplus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpeedCard extends ToggleableItemBase {
	
	public ItemSpeedCard() {
		setUnlocalizedName(Reference.xpplusitems.SPEED_CARD.getUnlocalizedName());
		setRegistryName(Reference.xpplusitems.SPEED_CARD.getRegistryName());
		setCreativeTab(xpplus.CREATIVE_TAB);
		setMaxStackSize(1);
		setLevelCost(30);
		setTooltipMessage("Activated - Run faster!");
	}


	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn,
													EnumHand hand) {
		if(!worldIn.isRemote){
			if(playerIn.isSneaking()){
				toggleItem(stack, playerIn);
			}
		}
		return super.onItemRightClick(stack, worldIn, playerIn, hand);
	}

	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(entityIn instanceof EntityPlayer){
			if(stack.getTagCompound().getBoolean("activated")){
				((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(1),100,2));
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
