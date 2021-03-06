
public class StatisticsTest {

	public static void main(String[] args) {
		int i = 0;
		for(double[] data = new double[10 + i]; i < 10; i += 10, data = new double[10 + i])
		{
				for (int j = 0; j < data.length; j++) {
					data[j] = (int)(Math.random() * 10000) / 100.0;
					if(j % 2 == 0)
					{
						data[++j] = data[--j];
					j++;
					}
						
				}
				int zScore = (int)(Math.random() * data.length);
				System.out.println("Original Data: " + Statistics.arrayToString(data));
				System.out.println("Sorted Data: " + Statistics.arrayToString(Statistics.sortData(data)));
				System.out.println("Mean of Data: " + Statistics.mean(data));
				System.out.println("Median of Data: " + Statistics.median(data));
				System.out.println("Range of Data: " + Statistics.range(data));
				System.out.println("Lower Quartile of Data: " + Statistics.lowerQuartile(data));
				System.out.println("Upper Quartile of Data: " + Statistics.upperQuartile(data));
				System.out.println("Interquartile Range of Data: " + Statistics.interquartileRange(data));
				System.out.println("Mode of Data: " + Statistics.mode(data));
				System.out.println("Standard Deviation of Data: " + Statistics.standardDeviation(data));
				System.out.println("Z-Score of " + data[zScore] + " in this data set: " + Statistics.zScore(data, zScore));
				System.out.println("Outliers of the data set: " + Statistics.outliers(data));
		}
		
	}

}
