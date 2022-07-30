public class Max_Min_Median {

    public Integer get_max(Integer [] grade) {
        Integer i = 0;
        Integer max = 0;
        for (i = 0; i < grade.length; i++){
            if (grade[i] > max){
                max = grade[i];
            }
        }
        return (max);
    }

    public Integer get_max_index(Integer [] grade) {
        Integer i = 0;
        Integer max = 0;
        Integer index = 0;
        for (i = 0; i < grade.length; i++){
            if (grade[i] > max){
                max = grade[i];
                index = i;
            }
        }
        return index;
    }

    public Integer get_min(Integer [] grade) {
		Integer min = grade[0];
		for(Integer i = 0; i<grade.length; i++ ) {
		   if(grade[i]<min) {
			  min = grade[i];
		   }
		}
		return min;
	 }

     public Integer get_min_index(Integer [] grade) {
		Integer min = grade[0];
        Integer index = 0;
		for(Integer i = 0; i<grade.length; i++ ) {
		   if(grade[i]<min) {
			  min = grade[i];
              index = i;
              
		   }
		}
		return index;
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
