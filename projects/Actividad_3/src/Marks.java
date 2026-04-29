public class Marks {
    double[] markList;

    public Marks(){
        markList = new double[5];
    }

    public double calculateAverage(){
        double add = 0;
        for(int i = 0; i < markList.length; i++){
            add+= markList[i];
        }
        return (add/markList.length);
    }

    public double standardDeviation(){
        double avr = calculateAverage();
        double add = 0;
        for(int i = 0; i< markList.length; i++){
            add+= Math.pow(markList[i] - avr,2);
        }
        return Math.sqrt(add/markList.length);
    }
    public double higher(){
        double higher = markList[0];
        for(int i = 0; i < markList.length; i++){
            if(markList[i] > higher){
                higher = markList[i];
            }
        }
        return  higher;
    }
    public double lower(){
        double lower = markList[0];
        for(int i = 0; i< markList.length; i++){
            if(markList[i] < lower){
                lower = markList[i];
            }
        }
        return  lower;
    }
}
