package factory.abstrac;

import factory.abstrac.domain.DaZhongPaoCheCar;
import factory.abstrac.domain.DaZhongSuvCar;
import factory.abstrac.domain.PaoCheCar;
import factory.abstrac.domain.SuvCar;

public class DaZhongFactory implements CarFactory {

    @Override
    public PaoCheCar createPaoChe() {
        return new DaZhongPaoCheCar();
    }

    @Override
    public SuvCar createSuv() {
        return new DaZhongSuvCar();
    }
}
