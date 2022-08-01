// source: https://www.programiz.com/java-programming/examples/standard-deviation#:~:text=To%20calculate%20the%20standard%20deviation%2C%20calculateSD()%20function%20is%20created,to%20the%20main()%20function.
public class Calc_STD {
    public double calc_std(Integer [] grade) {
        double sum = 0.0, standardDeviation = 0.0;
        int length = grade.length;

        for(double num : grade) { // sum all grades
            sum += num;
        }

        double mean = sum/length; //getting mean grade

        for(double num: grade) {
            standardDeviation += Math.pow(num - mean, 2); // applying method "pow" from class "Math"
        }

        return Math.sqrt(standardDeviation/length); // returning square root as a result
    }
    
}
