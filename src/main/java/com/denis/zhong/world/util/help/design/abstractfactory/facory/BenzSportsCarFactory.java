package com.denis.zhong.world.util.help.design.abstractfactory.facory;

import com.denis.zhong.world.util.help.design.abstractfactory.produtor.AbstractSportsCar;
import com.denis.zhong.world.util.help.design.abstractfactory.produtor.BenzSportsCar;

public class BenzSportsCarFactory extends AbstractSportsCarFactory {

    @Override
    AbstractSportsCar makeSportsCar() {
        return new BenzSportsCar();
    }
}
