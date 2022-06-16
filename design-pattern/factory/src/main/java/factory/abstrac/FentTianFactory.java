package factory.abstrac;

import factory.abstrac.domain.FengTianPaoCheCar;
import factory.abstrac.domain.FengTianSuvCar;
import factory.abstrac.domain.PaoCheCar;
import factory.abstrac.domain.SuvCar;

public class FentTianFactory implements CarFactory {

    @Override
    public PaoCheCar createPaoChe() {
        return new FengTianPaoCheCar();
    }

    @Override
    public SuvCar createSuv() {
        return new FengTianSuvCar();
    }
}
