public class Calc_STD {
    public double calc_std(Integer [] grade) {
        double sum = 0.0, standardDeviation = 0.0;
        int length = grade.length;

        for(double num : grade) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: grade) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
    
}
