package swea;

public class Ilta {
    static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
    static float[][] balls = {
            {60, 60},	// 흰공
            {250, 120},	// 1번공
            {-1, -1},
            {30, 30},	// 3번공
            {-1, -1},
            {-1, -1},
    };

    public static void main(String[] args) {
        하드코딩();
        사분면();
        쿠션치기();
        코사인법칙_끼인각();
        코사인법칙_세변();
    }

    static double getAngle(double side1, double side2, double side3) {
        // cos 값을 각도로 변환 (라디안 → 도)
        return Math.toDegrees(
                Math.acos(
                        (side1 * side1 + side2 * side2 - side3 * side3) / (2 * side1 * side2)
                )
        );
    }

    private static void 코사인법칙_세변() {
        // 세 변이 3, 4, 5인 직각삼각형
        System.out.println(getAngle(3, 4, 5));  // 90.0
        // 세 변이 5, 5, 5인 정삼각형
        System.out.println(getAngle(5, 5, 5)); // 60.0
    }

    public static double getSide(double side1, double side2, double angle) {
        // 코사인 법칙 적용
        return Math.sqrt(
                side1 * side1 + side2 * side2 - 2 * side1 * side2 * Math.cos(Math.toRadians(angle))
        );
    }

    private static void 코사인법칙_끼인각() {
        // 두 변이 3, 4이고 그 사이 각이 90도인 경우
        System.out.println(getSide(3, 4, 90));// 결과: 5.0 (피타고라스 정리와 일치)
        // 두 변이 5, 7이고 그 사이 각이 60도인 경우
        System.out.println(getSide(5, 7, 60));
    }


    private static void 쿠션치기() {
        float angle = (float)(
                180 - Math.toDegrees(
                        Math.atan(
                                Math.abs(balls[0][0] - balls[1][0])
                                        /
                                        Math.abs(balls[1][1] + balls[0][1])
                        )
                )
        );
        System.out.println(angle);
    }

    private static void 사분면() {
        // target 볼과 white 를 가지고 사분면 따지기
        float whiteX = balls[0][0];
        float whiteY = balls[0][1];
        float targetX = balls[1][0];
        float targetY = balls[1][1];
        double width = Math.abs(whiteX - targetX);
        double height = Math.abs(whiteY - targetY);

        float radian = -1, angle = -1;
        if (whiteX == targetX) {
            if (whiteY < targetY) {
                angle = 0;
            } else {
                angle = 180;
            }
        } else if (whiteY == targetY) {
            if (whiteX < targetX)	{
                angle = 90;
            } else {
                angle = 270;
            }
        }

//		1사분면 
        if (whiteX < targetX && whiteY < targetY) {
            radian = (float)Math.atan(width / height);
            angle = (float)Math.toDegrees(radian);
        }
//		2사분면 	
//		3사분면
//		4사분면
        float power = (float)Math.sqrt((width * width) + (height * height));
        System.out.println("power -> " + power);
        System.out.println("angle -> " + angle);
    }

    private static void 하드코딩() {

        float angle = 0;
        float power = 50;
        if ((int)balls[1][0] != -1 && (int)balls[3][0] != -1) {
            angle = 70;   // 대략 70 ~ 80 이건 잘모름
        } else if ((int)balls[3][0] != -1) {
            angle = 320;  // 대략 320 ~ 330 사이
        }

        System.out.println(angle);
        System.out.println(power);
    }


}