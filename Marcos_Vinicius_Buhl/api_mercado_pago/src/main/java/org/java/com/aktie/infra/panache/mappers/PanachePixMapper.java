package com.aktie.infra.panache.mappers;
import com.aktie.domain.entities.PixBO;
import com.aktie.infra.panache.model.PanachePixCode;

public class PanachePixMapper {
    public static PixBO toDomain(PanachePixCode entity) {
        return new PixBO(entity.getId(), entity.getKey(), entity.getAmount(), entity.getEmvqrcps(), entity.getTransactionId());
    }

    public static PanachePixCode toEntity(PixBO bo) {
        PanachePixCode entity = new PanachePixCode();
        entity.setId(bo.getId());
        entity.setKey(bo.getKey());
        entity.setTransactionId(bo.getTransactionId());
        entity.setEmvqrcps(bo.getQrCode());
        entity.setAmount(bo.getAmount());
        return entity;
    }
}