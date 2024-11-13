package zoo.models;

import zoo.actions.IEater;

public abstract class Animal {

    /**
     * По-умному конечно удалить отсюда implements IEater, и написать - public abstract void eats();
     * в этом случае нам больше не нужен этот интерфейс IEater так как его функцию может выполнить абстрактый класс
     */
    public abstract void eats();
}
