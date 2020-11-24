package com.denis.zhong.world.util.help.design.abstractfactory.facory;

import com.denis.zhong.world.util.help.design.abstractfactory.produtor.AbstractBizCar;

public abstract class AbstractBizFactory implements IFactory{

   abstract AbstractBizCar makeBizCar();

}
