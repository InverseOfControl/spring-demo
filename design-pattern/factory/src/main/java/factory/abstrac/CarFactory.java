package factory.abstrac;

import factory.abstrac.domain.PaoCheCar;
import factory.abstrac.domain.SuvCar;

/**
 * 提供一个抽象接口用来创建一个产品家族
 */
public interface CarFactory {

    PaoCheCar createPaoChe();

    SuvCar createSuv();

}
