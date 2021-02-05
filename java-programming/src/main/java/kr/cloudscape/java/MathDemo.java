package kr.cloudscape.java;

public class MathDemo {

    public boolean isPrime(int n) {
        if (n == 1)
            return false;

        for (int i=2; i < n; i++) {
            if (n%i == 0)
                return false;
        }

        return true;
    }

    public boolean isPrimeBetter(int n) {
        if (n == 1)
            return false;

        // 입력값의 반만 loop를 돈다. 반 이상의 숫자는 나누어봤자 의미가 없기 때문.
        // 예를 들어 입력값이 29일 경우 i == 14 까지, 즉 아래의 경우 if statement는 12번 실행되며, 29%14 다음의 경우 -
        // 29%15, 29%16 등 - 는 어차피 나누어 떨어지지 않는다.
        for (int i=2; i*2 < n; i++) {
            if (n%i == 0)
                return false;
        }

        return true;
    }

    public void bitManipulation() {
        int i = 78;

        System.out.println(i%4);
        System.out.println(i&3);
        System.out.println(i%16);
        System.out.println(i&15);
    }
}
