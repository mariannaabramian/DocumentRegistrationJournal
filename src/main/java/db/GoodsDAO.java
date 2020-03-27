package db;

import model.Good;
import model.GoodsTN;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class GoodsDAO {
    private EntityManager manager;

    public GoodsDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager can't ");
        this.manager = manager;
    }

    public Good createGood (String goodsName, String goodNomenCode){
        Good goodsTN = new Good();
        goodsTN.setGoodName(goodsName);
        goodsTN.getGoodNomenclatureCode();
        return goodsTN;
    }

    // создать справочник Товарная номенклатура
    // public List<Good> FillGoodNomenclatureDictionary(){
    // }
}
