package com.company.task.observer;

import com.company.task.observer.impl.CustomArrayObserver;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
