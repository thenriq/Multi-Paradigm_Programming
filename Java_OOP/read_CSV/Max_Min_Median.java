public class Max_Min_Median {

    public double get_max(Integer [] grade) {
        Integer i = 0;
        Integer max = 0;
        for (i = 0; i < grade.length; i++){
            if (grade[i] > max){
                max = grade[i];
            }
        }
        return (max);
    }

    public Integer min(Integer [] array) {
		Integer min = array[0];
		for(Integer i = 0; i<array.length; i++ ) {
		   if(array[i]<min) {
			  min = array[i];
		   }
		}
		return min;
	 }

     public double get_average(Integer [] grade) {
        Integer i = 0;
        double sum = 0.0;
        for (i = 0; i < grade.length; i++){
            sum += grade[i];
        }
        return (sum / (grade.length));
    }
}
