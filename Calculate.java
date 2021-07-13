import java.util.Arrays;

public class Calculate {

    public int result(String text) {
        text = text.substring(1,text.length()-1);
        String [] arr = text.split(",");

        int count = 0;
        int iMax = 0;
        int iMin = 0;
        double sum = 0.0;
        double error = 0.0;
        double max = 0.0;
        boolean flag = true;

        double[] din = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            din[i] = Double.parseDouble(arr[i]);
        }
        Arrays.sort(din);
        while (flag) {
            for (int i = 0; i < din.length; i++) {

                if (din[i] > max) {
                    max = din[i];
                    iMax = i;
                }
            }
            iMin = iMax;
            din[iMax] = 0;
            sum = max;
            for (int i = 0; i < din.length; i++) {
                if (sum + din[i] < 2.0) {
                    sum += din[i];
                    iMin = i;
                }
                din[iMin] = 0;
            }
            count += 2;
            for (double v : din) {
                error += v;

            }
            if (error == 0) {
                flag = false;
            }
            error = 0;
            max = 0;
        }

        return count;
    }
}
