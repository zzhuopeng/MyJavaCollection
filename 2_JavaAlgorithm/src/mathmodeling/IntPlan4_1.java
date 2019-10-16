package mathmodeling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

//整数规划
class IntPlan4_1 {

    public static void main(String[] args) {
        double []CHANGE = {0.67, 0.63, 0.59, 0.58, 0.59, 0.60, 0.74, 0.86, 0.95, 0.96, 0.96, 0.95, 0.94, 0.95, 0.95, 0.96, 0.98, 1.00, 1.00, 0.95, 0.91, 0.82, 0.73, 0.63};

        for (int i = 0; i < CHANGE.length; i++) {
            CHANGE[i] = CHANGE[i]*2850;
        }

        List<Result4_1> results = new ArrayList<>();

        for (int CC = 0; CC<CHANGE.length; CC++) {
            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    for (int k = 0; k <= 3; k++) {
                        for (int l = 0; l <= 3; l++) {
                            for (int m = 0; m < 5; m++) {
                                for (int n = 0; n < 4; n++) {
                                    for (int o = 0; o < 2; o++) {
                                        for (int p = 0; p < 6; p++) {
                                            for (int q = 0; q < 1; q++) {
                                                //峰值为2850
                                                if (20*i + 76*j + 100*k + 197*l + 12*m + 155*n + 400*o + 50*p + 350*q <= CHANGE[CC]) {
                                                    results.add(new Result4_1(i, j, k, l, m, n, o, p, q));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/C_extra_folder/MATLAB/posibility"+CC+".txt"));
                for (Result4_1 result : results) {
                    System.out.println( result.getX1() + " " +
                                        result.getX2() + " " +
                                        result.getX3() + " " +
                                        result.getX4() + " " +
                                        result.getX5() + " " +
                                        result.getX6() + " " +
                                        result.getX7() + " " +
                                        result.getX8() + " " +
                                        result.getX9());
                    //写入文件
                    bufferedWriter.write( result.getX1() + " " +
                                        result.getX2() + " " +
                                        result.getX3() + " " +
                                        result.getX4() + " " +
                                        result.getX5() + " " +
                                        result.getX6() + " " +
                                        result.getX7() + " " +
                                        result.getX8() + " " +
                                        result.getX9());
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //清除数据
            results.clear();
        }
    }
}

class Result4_1 {
    private int x1;
    private int x2;
    private int x3;
    private int x4;
    private int x5;
    private int x6;
    private int x7;
    private int x8;
    private int x9;

    public Result4_1() {
    }

    public Result4_1(int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.x6 = x6;
        this.x7 = x7;
        this.x8 = x8;
        this.x9 = x9;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public int getX5() {
        return x5;
    }

    public void setX5(int x5) {
        this.x5 = x5;
    }

    public int getX6() {
        return x6;
    }

    public void setX6(int x6) {
        this.x6 = x6;
    }

    public int getX7() {
        return x7;
    }

    public void setX7(int x7) {
        this.x7 = x7;
    }

    public int getX8() {
        return x8;
    }

    public void setX8(int x8) {
        this.x8 = x8;
    }

    public int getX9() {
        return x9;
    }

    public void setX9(int x9) {
        this.x9 = x9;
    }
}
