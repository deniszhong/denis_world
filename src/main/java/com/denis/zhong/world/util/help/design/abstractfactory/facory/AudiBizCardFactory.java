package com.denis.zhong.world.util.help.design.abstractfactory.facory;

import com.denis.zhong.world.util.help.design.abstractfactory.produtor.AbstractBizCar;
import com.denis.zhong.world.util.help.design.abstractfactory.produtor.AudiBizCar;

public class AudiBizCardFactory extends AbstractBizFactory {

    @Override
    AbstractBizCar makeBizCar() {
        return new AudiBizCar();
    }

}
