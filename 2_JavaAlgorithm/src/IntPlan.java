import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

//整数规划
class IntPlan {
    public static final double CHANGE = 137.8858205;

    public static void main(String[] args) {

        List<Result> results = new ArrayList<>();

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 6; j++) {
                for (int k = 0; k <= 10; k++) {
                    for (int l = 0; l <= 10; l++) {

                        if (250 * i + 100 * j + 65 * k + 50 * l >= CHANGE) {
                            results.add(new Result(i, j, k, l));
                        }
                    }
                }
            }
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/C_extra_folder/MATLAB/result"+CHANGE+".txt"));
            for (Result result : results) {
                System.out.println(result.getX1() + " " + result.getX2() + " " + result.getX3() + " " + result.getX4() + " " + result.getProfit());

                //写入文件
                bufferedWriter.write( result.getX1() + " " +
                        result.getX2() + " " +
                        result.getX3() + " " +
                        result.getX4() + " " +
                        result.getProfit());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Result {
    private int x1;
    private int x2;
    private int x3;
    private int x4;

    private double profit;

    public Result() {
    }

    public Result(int x1, int x2, int x3, int x4) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
    }

    public Result(int x1, int x2, int x3, int x4, double profit) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.profit = profit;
    }

    public double computeProfit() {
        double result = 0.0;

        for (int i = 0; i < x1 / 1; i++) {
            result += 220 * Math.pow((1 + 0.08), i);
        }

        for (int i = 0; i < x2 / 2; i++) {
            result += 2 * 90 * Math.pow((1 + 0.08), i);
        }
        result += (x2 % 2) * 90 * Math.pow((1 + 0.08), (x2 / 2));

        for (int i = 0; i < x3 / 3; i++) {
            result += 3 * 60 * Math.pow((1 + 0.08), i);
        }
        result += (x3 % 3) * 60 * Math.pow((1 + 0.08), (x3 / 3));

        for (int i = 0; i < x4 / 2; i++) {
            result += 2 * 50 * Math.pow((1 + 0.08), i);
        }
        result += (x4 % 2) * 50 * Math.pow((1 + 0.08), (x4 / 2));

        return result;
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

    public double getProfit() {
        return computeProfit();
    }
}
