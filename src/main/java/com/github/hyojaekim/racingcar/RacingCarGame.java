package com.github.hyojaekim.racingcar;

public class RacingCarGame {
    private Car[] cars;                 // 각각의 자동차 정보
    private int maxPosition = 0;        // 모든 자동차 중에서 최대 이동 거리

    public RacingCarGame(String cars) {
        registerCar(cars);
    }

    private void registerCar(String carsName) {
        String[] divCarsName = carsName.split(",");

        this.cars = new Car[divCarsName.length];
        for (int i = 0; i < divCarsName.length; i++) {
            this.cars[i] = new Car(divCarsName[i]);
        }
    }

    public void startRacingGame() {
        for (int i = 0; i < this.cars.length; i++) {
            this.cars[i].printCarPosition(isMovePosition());
        }
        System.out.println();
    }

    private boolean isMovePosition() {
        int randomNumber = (int) (Math.random() * 10);
        boolean result = (randomNumber >= 4) ? true : false;

        return result;
    }

    public void setMaxPosition() {
        for (int i = 0; i < cars.length; i++) {
            this.maxPosition = cars[i].collectMaxPosition(maxPosition);
        }
    }

    public void printVictoryCar() {
        int cnt = 0;

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].isVictoryCar(maxPosition, cnt)) {
                cnt++;
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }
}