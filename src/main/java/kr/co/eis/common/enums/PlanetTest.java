package kr.co.eis.common.enums;

/**
 * packageName: kr.co.eis.common.enums
 * fileName        : PlanetTest
 * author          : codejihyekim
 * date            : 2022-05-13
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-13         codejihyekim      최초 생성
 */
public class PlanetTest {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity;
        for (Planet p : Planet.values()) {
            System.out.printf("%s에서의 무게는 %f이다. %n", p, p.surfaceWeight(mass));
        }
    }
    static public enum Planet {
        MERCURY(3.302e+23, 2.429e6),
        VENUS(4.869e+24, 6.052e6),
        EARTH(5.975e+24, 6.378e6),
        MARS(6.419e+23, 3.393e6),
        JUPITER(1.899e+27, 7.149e7),
        SATURN(5.685e+26, 6.027e7),
        URANUS(8.683e+25, 2.556e7),
        NEPTUNE(1.024e+26, 2.477e7),
        ;

        private final double mass;              // 질량(kg)
        private final double radius;            // 반지름(meter)
        private final double surfaceGravity;    // 표현 중력(m / s^2)

        // 중력상수(m^3 / kg s^2)
        private static final double G = 6.67300E-11;

        // 생성자

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }

        public double getMass() {
            return mass;
        }

        public double getRadius() {
            return radius;
        }

        public double getSurfaceGravity() {
            return surfaceGravity;
        }

        public double surfaceWeight(double mass) {
            return mass * surfaceGravity; // F = ma
        }
    }
}
