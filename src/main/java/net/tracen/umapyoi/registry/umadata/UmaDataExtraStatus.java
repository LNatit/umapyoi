package net.tracen.umapyoi.registry.umadata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record UmaDataExtraStatus(int actionPoint, int resultRanking, Motivations motivation) {
	public static final Codec<UmaDataExtraStatus> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			Codec.INT.fieldOf("action_point").forGetter(UmaDataExtraStatus::actionPoint),
			Codec.INT.fieldOf("result_ranking").forGetter(UmaDataExtraStatus::resultRanking),
			Motivations.CODEC.fieldOf("motivation").forGetter(UmaDataExtraStatus::motivation)
			).apply(instance, UmaDataExtraStatus::new));
    
	public static final StreamCodec<ByteBuf, UmaDataExtraStatus> STREAM = StreamCodec.composite(
			ByteBufCodecs.INT, UmaDataExtraStatus::actionPoint,
			ByteBufCodecs.INT, UmaDataExtraStatus::resultRanking,
			ByteBufCodecs.STRING_UTF8.map(
			        // String -> Motivation
					string -> Motivations.valueOf(string.toUpperCase()),
			        // Motivation -> String
					instance -> instance.name().toLowerCase()
			    ), UmaDataExtraStatus::motivation,
			UmaDataExtraStatus::new
	);
}